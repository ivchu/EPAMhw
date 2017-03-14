package hw.epam.properties;

import org.junit.Test;

import java.io.IOException;


public class PropertiesReaderTest {

    @Test
    public void TestingSomething() throws IOException {
        PropertiesReader propertiesReader = new PropertiesReader();
        propertiesReader.setDefaultPropertiesKeys();
        System.out.println(propertiesReader.readProperties("C://ivan//java//epamhw//unit05//task02//src//main//niceprop.properties"));
        System.out.println("----------------");
        propertiesReader.readProperties("C://ivan//java//epamhw//unit05//task02//src//main//shitprop.properties");
    }
}