package propertyHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ReadWriteProperty {
    Properties properties =new Properties();

    private final static String FILE_NAME = "db_config.properties";

    public void writeProperty() throws IOException {
        OutputStream os = new FileOutputStream(FILE_NAME);
        properties.setProperty("username","root");
        properties.setProperty("password","root");
        properties.setProperty("port","3306");
        properties.store(os,null);
    }

    public static void main(String[] args) throws IOException {
        new ReadWriteProperty().writeProperty();
    }
}
