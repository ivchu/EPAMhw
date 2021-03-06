package hw.epam.properties;


import hw.epam.properties.Exceptions.IllegalKeyForProperties;
import hw.epam.properties.Exceptions.NoSuchPropertyFileException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@FixMethodOrder
public class PropertiesReaderTest {
    Map<String, String> testingResources;
    PropertiesReader testingUnit;
    String path = "C://ivan//java//epamhw//unit06//task02//src//Resources//props.properties";
    @Before
    public void init(){
        testingUnit = new PropertiesReader();
        testingResources = new HashMap<>();
        testingResources.put("name", "agent");
        testingResources.put("password", "007");
    }

    @Test
    public void testReadingMethodReturnsMapWithRightElments(){
        Assert.assertEquals(testingResources, testingUnit.readPropertiesInMap(path));
    }

    @Test(expected = NullPointerException.class)
    public void testThatReadPropertiesInMaphrowsNullPointerExceptionForNullPath(){
        testingUnit.readPropertiesInMap(null);
    }

    @Test(expected = NoSuchPropertyFileException.class)
    public void testThatReadPropertiesInMapThrowsNoSuchPropertyFileExceptionForWrongPath(){
        testingUnit.readPropertiesInMap("dsfdsfsda");
    }

    @Test(expected = IllegalKeyForProperties.class)
    public void testThatGetPropertyThrowsIllegalKeyForPropertiesExceptionForWrongKey(){
        testingUnit.getProperty("ggg");
    }

    @Test
    public void testThatGetPropertyWorksWell(){
        PropertiesReader getTestReader = new PropertiesReader();
        getTestReader.readPropertiesInMap(path);
        Assert.assertEquals(testingResources.get("name"), getTestReader.getProperty("name"));
        Assert.assertEquals(testingResources.get("password"), getTestReader.getProperty("password"));
    }

    @Test(expected = NullPointerException.class)
    public void testThatGetPropertyThrowsNullPointerExceptionForNullKey(){
        testingUnit.getProperty(null);
    }

}