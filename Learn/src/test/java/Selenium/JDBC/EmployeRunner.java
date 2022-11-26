package Selenium.JDBC;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class EmployeRunner {

    public static void main(String[] args) throws IOException {


        //Question   Convert to POJO Object to JSON files

         Address add=new Address("sd","asd","asd","sad");
         Employee emp=new Employee("Sarthak",2,"KVno1",add);

         ObjectMapper mapper=new ObjectMapper();
         mapper.writeValue(new File("E:/SeleniumGithubProject/Learn/src/test/java/Fikes/Emp3.json"),emp);
         String json = "{\n" +
                "  \"name\": \"Sarthak\",\n" +
                "  \"rollNo\": 2,\n" +
                "  \"SchoolName\": \"KVno1\",\n" +
                "  \"adress\": {\n" +
                "    \"colonyName\": \"sd\",\n" +
                "    \"houseNo\": \"asd\",\n" +
                "    \"city\": \"asd\",\n" +
                "    \"state\": \"sad\"\n" +
                "  },\n" +
                "  \"schoolName\": \"KVno1\"\n" +
                "}";

        Map<String, Object> map
                = mapper.readValue(json, new TypeReference<Map<String,Object>>(){});


        System.out.println(map.get("schoolName"));


    }
}
