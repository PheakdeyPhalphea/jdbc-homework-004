package unitl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class LoadProperties {
        public static final Properties properties = new Properties();
        public static void loadProperties (){
                try(BufferedReader bufferedReader = new BufferedReader(new FileReader("application.properties"))) {
                    properties.load(bufferedReader);
                } catch (Exception e) {
                    System.out.println( "Problem during loading properties: " + e.getMessage());
                }
        }
}
