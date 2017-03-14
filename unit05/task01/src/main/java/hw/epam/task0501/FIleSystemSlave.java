package hw.epam.task0501;

import java.io.*;

public class FIleSystemSlave {

    public static void main(String[] args) throws IOException {
        File file = new File("C://ivan//java//epamhw//unit05//task01//src//main");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] gg = new byte[inputStream.available()];
        inputStream.read(gg);

    }

    public File moveTo(String pathName) {
        return new File(pathName);
    }

    public String[] getPathFiles(String pathName) {
        File currentFile = moveTo(pathName);
        String[] files = currentFile.list();
        return files;
    }

    public String readTextFileByPath(String filePath) {
        File currentFile = moveTo(filePath);
        String fileInfo = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(currentFile)));
            StringBuffer lines = new StringBuffer("");
            String line;
            while ((line = reader.readLine()) != null) {
                lines.append(line);
            }
            fileInfo = lines.toString();
        } catch (FileNotFoundException e) {
            System.out.println("не прочитали текстовый файл");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("косяк с прочтением строки из файла");
            e.printStackTrace();
        }
        return fileInfo;
    }

    public boolean makeDirInPath(String pathName, String dirName){
        File currentFile = moveTo(pathName);
        if (currentFile.isDirectory()) {
            return currentFile.mkdir();
        }else {
            return false;
        }
    }

    public boolean createFile(String pathName, String fileName){
        File currentPath = moveTo(pathName);
        File newFile = new File(currentPath.getAbsolutePath() + "//" + fileName);
        try {
            return newFile.createNewFile();
        } catch (IOException e) {
            System.out.println("не смогли создать новый файл, но это ничего");
            e.printStackTrace();
            return false;
        }
    }


}
