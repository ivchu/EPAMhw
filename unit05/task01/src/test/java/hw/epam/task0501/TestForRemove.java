package hw.epam.task0501;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class TestForRemove {
    FileSystemSlave fileSystemSlave = new FileSystemSlave();
    @Test
    public void removeFile() throws Exception {
        fileSystemSlave.createFile("C://ivan//java//epamhw//unit05//task01//src/main", "djigurda.txt");
        fileSystemSlave.createFile("C://ivan//java//epamhw//unit05//task01//src/main", "djigurda");
        boolean fileRemoved = fileSystemSlave.remove("C://ivan//java//epamhw//unit05//task01//src/main//djigurda.txt");
        Assert.assertTrue(fileRemoved);
        boolean dirRemoved = fileSystemSlave.remove("C://ivan//java//epamhw//unit05//task01//src/main//djigurda");
        Assert.assertTrue(dirRemoved);
        File fileForCheckFile = new File("C://ivan//java//epamhw//unit05//task01//src/main//djigurda.txt");
        Assert.assertTrue(!fileForCheckFile.exists());
        File fileForCheckDir = new File("C://ivan//java//epamhw//unit05//task01//src/main//djigurda");
        Assert.assertTrue(!fileForCheckDir.exists());
    }
}
