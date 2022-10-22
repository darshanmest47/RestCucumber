package Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.InputStream;

public class Utils {

    public static String getJSONStringValue(Response resp,String value){
        JsonPath js= new JsonPath(resp.asString());
        return js.getString(value);

    }

}
