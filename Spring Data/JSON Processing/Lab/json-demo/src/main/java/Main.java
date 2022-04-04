import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        _01_FROM_JSON
//        String json = """
//                {
//                "firstName" : "Ivan",
//                "lastName" : "Dimitrov",
//                "age" : 54,
//                "height" : 179.5,
//                "isMarried" : true,
//                "wife" : {"firstName" : "Ganka", "age" : 50, "height" : 175.2},
//                "kids" : [{"firstName" : "Ivancho", "age" : 13, "height" : 160.5}, {"firstName" : "Marika", "age" : 12, "height" : 150.5}],
//                "dog" : null
//                }
//                """;
//
//        Gson gson = new Gson();
//
//        PersonDTO personDTO = gson.fromJson(json, PersonDTO.class);


//        _02_TO_JSON
//        DogDTO dogDTO = new DogDTO("Robie", 8, 50.5);
//        WifeDTO wifeDTO = new WifeDTO("Ganka", null, 50, true, 175.2);
//        List<KidsDTO> kids = List.of(new KidsDTO("Ivancho", null, 13, 160.5), new KidsDTO("Marika", null, 12, 150.5));
//        PersonDTO personDTO = new PersonDTO("Ivan", "Dimitrov", 54,  true, 179.5, wifeDTO, kids, dogDTO);
//
//        Gson gson = new GsonBuilder()
//                .excludeFieldsWithoutExposeAnnotation()
//                .setPrettyPrinting()
//                .create();
//
//        String json = gson.toJson(personDTO);
//
//        System.out.println(json);

//        _03_FROM_JSON_Object[]
//        String json = """
//                {
//                "testArr" : [{"String" : "Pesho"}, {"age" : 10}, {"weight" : 10.5}, {"isMarried": true}]
//                }
//                """;
//
//        Gson gson = new Gson();
//
//        TestDTO testDTO = gson.fromJson(json, TestDTO.class);
    }
}
