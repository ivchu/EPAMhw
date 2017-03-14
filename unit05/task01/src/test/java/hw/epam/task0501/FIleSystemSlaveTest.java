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
        String fileText =  "I hurt myself today \n" +
                "To see if I still feel \n" +
                "I focus on the pain \n" +
                "The only thing that's real \n" +
                "The needle tears a hole\n" +
                "The old familiar sting \n" +
                "Try to kill it all away \n" +
                "But I remember everything \n";
        String readFileText = fileSystemSlave.readTextFileByPath("C://ivan//java//epamhw//unit05//task01//src/main//textFile.txt");
        Assert.assertEquals(fileText, readFileText);

    }

    @Test
    public void makeDirInPath() throws Exception {
        boolean isFileDone = fileSystemSlave.makeDirInPath("C://ivan//java//epamhw//unit05//task01//src/main", "djigurda");
        Assert.assertTrue(isFileDone);
        File fileForCheck = new File("C://ivan//java//epamhw//unit05//task01//src/main//djigurda");
        Assert.assertTrue(fileForCheck.exists());
    }

    @Test
    public void createFile() throws Exception {
        boolean isFileDone = fileSystemSlave.createFile("C://ivan//java//epamhw//unit05//task01//src/main", "djigurda.txt");
        Assert.assertTrue(isFileDone);
        File fileForCheck = new File("C://ivan//java//epamhw//unit05//task01//src/main//djigurda.txt");
        Assert.assertTrue(fileForCheck.exists());
    }

    @Test
    public void removeFile() throws Exception {

    }

    @Test
    public void writeToFile() throws Exception {

    }

}