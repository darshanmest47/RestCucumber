package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class BaseSetUp {
    static PropertyUtils config;
    static RequestSpecification req=null;

    public static RequestSpecification baseSetUp() throws Throwable {
     config = new PropertyUtils(System.getProperty("user.dir")+"/src/main/java/Configurations/configs.properties");
     System.out.println(config.getProperty("BASE_URI"));
     if(req==null){
         PrintStream p = new PrintStream(new FileOutputStream("logs.txt"));
         req = new RequestSpecBuilder().setBaseUri(config.getProperty("BASE_URI")).setContentType(ContentType.JSON)
                 .addFilter(RequestLoggingFilter.logRequestTo(p))
                 .addFilter(ResponseLoggingFilter.logResponseTo(p))
                 .build();

         return req;
     }

        return req;
    }



}
