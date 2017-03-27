package hw.epam.properties;


import hw.epam.properties.Exceptions.IllegalKeyForProperties;
import hw.epam.properties.Exceptions.NoSuchPropertyFileException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Class which can load properties into map, and then let u works with properties using HashMap
 */

public class PropertiesReader {
    private Map<String, String> properties = new HashMap<>();

    public PropertiesReader() {
    }

    /**
     * Using this method u can load a property file into hashmap which stored in the class, and then
     * use method getProperty, to get Properties by key, also this method returns unmodifiableMap with
     * keys and values of the properties File, so u can save it, and work with it.
     * @param path this is a path of the properties File
     * @return unmodifiableMap which contains keys and value from properties File
     */
    public Map<String, String> readPropertiesInMap(String path) {
        if (path == null) {
            throw new NullPointerException();
        }
        Map<String, String> currentProps = new HashMap<>();
        Properties currentProperties = readPropertiesFromFile(path);
        for (String key : currentProperties.stringPropertyNames()){
            currentProps.put(key, currentProperties.getProperty(key));
        }
        properties = currentProps;
        return Collections.unmodifiableMap(currentProps);
    }

    private Properties readPropertiesFromFile(String path) {
        Properties newProperties;
        newProperties = new Properties();
        File propertyFile = new File(path);
        if (!propertyFile.isFile()) {
            throw new NoSuchPropertyFileException("Wrong properties path");
        }
        FileInputStream input = null;
        try {
            input = new FileInputStream(propertyFile);
            newProperties.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("shouldn't get here");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("problems with loading properties from file");
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("FileInputStream can`t be closed");
            }
        }
        return newProperties;
    }


    public String getProperty(String key) {
        if (key == null){
             throw new NullPointerException("Key can`t be null");
        }
        if (properties.containsKey(key)) {
            String property = properties.get(key);
            return property;
        } else {
            throw new IllegalKeyForProperties("no such key in properties");
        }
    }
}
