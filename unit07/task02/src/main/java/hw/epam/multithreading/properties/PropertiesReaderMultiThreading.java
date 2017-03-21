package hw.epam.multithreading.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Properties load method is synchronized, so the solution from the last lesson
 * works well
 */
public class PropertiesReaderMultiThreading {
    private String propertiesPath;
    private List<String> propertiesKeys = new ArrayList<>();

    public void setDefaultPropertiesKeys() {
        propertiesKeys.add("password");
        propertiesKeys.add("username");
    }

    public void addPropertiesKey(String key) {
        propertiesKeys.add(key);
    }

    private void setPropertiesPath(String path) throws NoSuchFileException {
        File propertyFile = new File(path);
        if (propertyFile.isFile()) {
            propertiesPath = path;
        } else {
            throw new NoSuchFileException("Wrong properties path");
        }
    }

    public String readProperties(String path) throws IOException {
        setPropertiesPath(path);
        Properties currentProperties = new Properties();
        FileInputStream propertiesInput = new FileInputStream(propertiesPath);
        StringBuffer result = new StringBuffer("");
        try {
            currentProperties.load(propertiesInput);
        } catch (FileNotFoundException e) {
            System.out.println("probably i shouldn`t appear");
            e.printStackTrace();
        } finally {
            propertiesInput.close();
        }
        for (int i = 0; i < propertiesKeys.size(); i++) {
            if (currentProperties.containsKey(propertiesKeys.get(i))) {
                result.append(propertiesKeys.get(i) + "=" + currentProperties.getProperty(propertiesKeys.get(i)) + "\n");
            } else {
                throw new IllegalStateException("в файле нету нужных нам ключей");
            }
        }
        String forreturn = result.toString();
        return forreturn.substring(0, forreturn.length() - 1);
    }

    public PropertiesReaderMultiThreading(String path) {
        this.propertiesPath = path;
    }

    public String readProperty(String key) throws IOException {
        FileInputStream propertiesInput = new FileInputStream(propertiesPath);
        Properties currentProperties = new Properties();
        try {
            currentProperties.load(propertiesInput);
        } finally {
            propertiesInput.close();
        }
        if (currentProperties.containsKey(key)) {
            return (String) currentProperties.get(key);
        } else throw new IllegalArgumentException("no suck key in Properties");
    }
}