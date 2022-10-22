package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    Properties props = new Properties();
    public PropertyUtils(String path) throws Throwable {
        FileInputStream fis = new FileInputStream(path);
        props.load(fis);
    }

    public String getProperty(String value){
        return props.getProperty(value);
    }


}
