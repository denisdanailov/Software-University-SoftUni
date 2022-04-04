package com.example.cardealer.services;

import com.example.cardealer.dtos.carDTOs.CreateCarFactory;
import com.example.cardealer.dtos.customerDTOs.CreateCustomerDTO;
import com.example.cardealer.dtos.customerDTOs.CustomerFactoryDTO;
import com.example.cardealer.dtos.partDTOs.CreatePartDTO;
import com.example.cardealer.dtos.partDTOs.CreatePartsFactory;
import com.example.cardealer.dtos.supplierDTOs.CreateSuppliersDTO;
import com.example.cardealer.dtos.supplierDTOs.CreateSuppliersFactory;
import com.example.cardealer.entities.*;
import com.example.cardealer.repositories.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedingServiceImpl implements SeedingService {

    private final ModelMapper modelMapper;
    private final Random random;
    private final SupplierRepository supplierRepo;
    private final PartRepository partRepo;
    private final CarRepository carRepo;
    private final CustomerRepository customerRepo;
    private final SaleRepository saleRepo;

    @Autowired
    public SeedingServiceImpl(SupplierRepository supplierRepo, PartRepository partRepo, CarRepository carRepo, CustomerRepository customerRepo, SaleRepository saleRepo) {
        this.supplierRepo = supplierRepo;
        this.partRepo = partRepo;
        this.carRepo = carRepo;
        this.customerRepo = customerRepo;
        this.saleRepo = saleRepo;

        this.random = new Random();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void seedSuppliers() throws JAXBException {
        File suppliersFile = new File(SUPPLIERS_FILE_PATH);

        JAXBContext jaxbContext = JAXBContext.newInstance(CreateSuppliersFactory.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        CreateSuppliersFactory suppliersFactory = (CreateSuppliersFactory) unmarshaller.unmarshal(suppliersFile);

        List<CreateSuppliersDTO> suppliersDTOList = suppliersFactory.getSuppliers();

        List<Supplier> suppliersList = suppliersDTOList.stream().map(dto -> modelMapper.map(dto, Supplier.class)).collect(Collectors.toList());

        this.supplierRepo.saveAll(suppliersList);
    }

    @Override
    public void seedParts() throws JAXBException {
        File partsFile = new File(PARTS_PATH_FILE);

        JAXBContext jaxbContext = JAXBContext.newInstance(CreatePartsFactory.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        CreatePartsFactory createPartsFactory = (CreatePartsFactory) unmarshaller.unmarshal(partsFile);

        List<CreatePartDTO> partsDtoList = createPartsFactory.getParts();

        List<Part> partsList = partsDtoList.stream().map(dto -> modelMapper.map(dto, Part.class)).collect(Collectors.toList());

        for (Part part : partsList) {
            int randSupplierId = random.nextInt((int) this.supplierRepo.count()) + 1;

            Optional<Supplier> supplierOpt = this.supplierRepo.findById(randSupplierId);

            part.setSupplier(supplierOpt.get());
        }

        this.partRepo.saveAll(partsList);
    }

    @Override
    public void seedCars() throws JAXBException {
        File carsFile = new File(CARS_FILE_PATH);

        JAXBContext jaxbContext = JAXBContext.newInstance(CreateCarFactory.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        CreateCarFactory createCarFactoryDTO = (CreateCarFactory) unmarshaller.unmarshal(carsFile);

        List<Car> carsCollection = createCarFactoryDTO.getCars().stream().map(dto -> modelMapper.map(dto, Car.class)).collect(Collectors.toList());

        for (Car car : carsCollection) {
            Set<Part> partsCollection = this.random.ints(15, 1, (int) this.partRepo.count() + 1)
                    .mapToObj(id -> this.partRepo.findById(id).get())
                    .collect(Collectors.toSet());

            car.setParts(partsCollection);
        }

        this.carRepo.saveAll(carsCollection);
    }

    @Override
    public void seedCustomers() throws JAXBException {
        File customersFile = new File(CUSTOMERS_FILE_PATH);

        JAXBContext jaxbContext = JAXBContext.newInstance(CustomerFactoryDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        CustomerFactoryDTO customerFactoryDTO = (CustomerFactoryDTO) unmarshaller.unmarshal(customersFile);

        List<CreateCustomerDTO> customersDtoList = customerFactoryDTO.getCustomers();

        TypeMap<CreateCustomerDTO, Customer> typeMap = modelMapper.typeMap(CreateCustomerDTO.class, Customer.class);
        Converter<String, LocalDate> toLocalDate = cxt -> LocalDate.parse(cxt.getSource(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        typeMap.addMappings(mapper -> mapper.using(toLocalDate).map(CreateCustomerDTO::getDateOfBirth, Customer::setDateOfBirth));

        List<Customer> customerList = customerFactoryDTO.getCustomers().stream().map(typeMap::map).collect(Collectors.toList());

        this.customerRepo.saveAll(customerList);
    }

    @Override
    public void seedSales() {

        List<Sale> salesList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {

            int randCarId = random.nextInt((int) this.carRepo.count()) + 1;

            int randCustomerId = random.nextInt((int) this.customerRepo.count()) + 1;

            double[] discounts = new double[]{0, 0.05, 0.1, 0.15, 0.2, 0.3, 0.4, 0.5};

            int randIndex = random.nextInt(discounts.length);

            Optional<Car> carOpt = this.carRepo.findById(randCarId);

            Optional<Customer> customerOpt = this.customerRepo.findById(randCustomerId);

            Sale sale = new Sale(carOpt.get(), customerOpt.get(), discounts[randIndex]);

            salesList.add(sale);
        }

        this.saleRepo.saveAll(salesList);
    }

}
