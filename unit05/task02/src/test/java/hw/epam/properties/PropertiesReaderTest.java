package hw.epam.properties;

import hw.epam.properties.Exceptions.IllegalKeyForProperties;
import hw.epam.properties.Exceptions.NoSuchPropertyFileException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


public class PropertiesReaderTest {

    @Test
    public void testingGoodInputPropertiesIsWorkingWell() throws IOException {
        String resultMustBe = "password=hoala\n" + "username=koala";
        PropertiesReader propertiesReader = new PropertiesReader();
        propertiesReader.setDefaultPropertiesKeys();
        String ourResult = propertiesReader.readProperties("C://ivan//java//epamhw//unit05//task02//src//main//niceprop.properties");
        Assert.assertEquals(resultMustBe, ourResult);
    }

    @Test(expected = IllegalKeyForProperties.class)
    public void testingBadInputPropertiesThrowsRightExept() throws IOException {
        PropertiesReader propertiesReader = new PropertiesReader();
        propertiesReader.setDefaultPropertiesKeys();
        String ourResult = propertiesReader.readProperties("C://ivan//java//epamhw//unit05//task02//src//main//shitprop.properties");
    }

    @Test(expected = NoSuchPropertyFileException.class)
    public void testingWrongPathThrowsRightException() throws IOException {
        PropertiesReader propertiesReader = new PropertiesReader();
        propertiesReader.readProperties("C://ivan//javafddas");
    }
}