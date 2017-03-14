package hw.epam.task0501;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;


public class FileSystemSlaveTest {
    static FileSystemSlave fileSystemSlave = new FileSystemSlave();

    @Test(expected = NoPathRuntimeException.class)
    public void moveToExceptionTest() throws Exception {
        fileSystemSlave.moveTo("asdsa");
    }

    @Test
    public void moveToCorrectWorkTest() throws Exception {
        File rightOne = new File("C://ivan//java//epamhw//unit05//task01//src/main");
        File ourFile = fileSystemSlave.moveTo("C://ivan//java//epamhw//unit05//task01//src/main");
        Assert.assertEquals(rightOne,ourFile);
    }

    @Test
    public void getPathFiles() throws Exception {
        String mustbe = "epamhw\n" +
                "gitstudy\n" +
                "Javarush\n" +
                "libraries\n" +
                "Темы занятий.txt\n";
        Assert.assertEquals(mustbe, fileSystemSlave.getPathFiles("C://ivan//java"));
    }

    @Test
    public void readTextFileByPath() throws Exception {

    }

    @Test
    public void makeDirInPath() throws Exception {

    }

    @Test
    public void createFile() throws Exception {

    }

    @Test
    public void removeFile() throws Exception {

    }

    @Test
    public void writeToFile() throws Exception {

    }

}