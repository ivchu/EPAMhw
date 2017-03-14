package hw.epam.task0501;

import java.util.Scanner;

public class ConsoleApp {
    private FileSystemSlave ourWorker = new FileSystemSlave();
    private Scanner consoleScanner = new Scanner(System.in);
    private String command = "";
    private String path = "";


    public void run() {
        /*
        GetPathFiles - getfiles
        readTextFileByPath - readfile
        createFile - create
        remove - remove
        writeToFile - write/append
        ending - quit
         */
        System.out.println("Hello World");
        System.out.println("U can do smth with files using this app");
        System.out.println("But i won`t tell u, what can u do, and how to do smth");
        while (true) {
            System.out.println("Input some command");
            command = consoleScanner.nextLine();
            switch (command) {
                case "getfiles":
                    getPath();
                    ourWorker.getPathFiles(path);
                    break;
                case "readfile":
                    getPath();
                    ourWorker.readTextFileByPath(path);
                    break;
                case "create":
                    getPath();
                    System.out.println("we need some name for the file");
                    String filename = consoleScanner.nextLine();
                    ourWorker.createFile(path, filename);
                    break;
                case "remove":
                    getPath();
                    ourWorker.remove(path);
                    break;
                case "write":
                    getPath();
                    writeInfo(false);
                    break;
                case "append":
                    getPath();
                    writeInfo(true);
                    break;
                case "quit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("вы ввели неверную команду, попробуйте еще разок, вдруг заработает");
                    break;
            }
        }
    }

    private void writeInfo(boolean appentToFile) {
        StringBuffer infoForWriting = new StringBuffer("");
        String line;
        System.out.println("what do u want to write, Enter will be the end of info");
        while ((line = consoleScanner.nextLine()) != "") {
            infoForWriting.append(line + "\n");
        }
        ourWorker.writeToFile(path, infoForWriting.toString(), appentToFile);
    }

    private void getPath() {
        System.out.println("Write absolute path to file");
        path = consoleScanner.nextLine();
    }
}
