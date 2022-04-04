package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import softuni.exam.enums.Rating;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;
import softuni.exam.util.impl.ValidationUtilImpl;
import softuni.exam.util.impl.XmlParserImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson getGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ValidationUtil getValidationUtil() {
        return new ValidationUtilImpl();
    }

    @Bean
    @Primary
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Bean(name = "mapperStringToLocalDateTimeConv")
    public ModelMapper getModelMapperWithStringToLDTConv() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(MappingContext<String, LocalDateTime> mappingContext) {
                String dateTimeSource = mappingContext.getSource();
                return LocalDateTime.parse(dateTimeSource, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        });

        return modelMapper;
    }

    @Bean(name = "mapperStringToLocalDateConv")
    public ModelMapper getModelMapperWithStringToLDConv() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                String dateSource = mappingContext.getSource();
                return LocalDate.parse(dateSource, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        });

        return modelMapper;
    }

    @Bean(name = "mapperStringToRatingConv")
    public ModelMapper getModelMapperWithStringToRatingConv() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(new Converter<String, Rating>() {
            @Override
            public Rating convert(MappingContext<String, Rating> mappingContext) {
                String sourceRating = mappingContext.getSource();
                return Rating.valueOf(sourceRating);
            }
        });

        return modelMapper;
    }

    @Bean
    public XmlParser getXmlParser() {
        return new XmlParserImpl();
    }
}
