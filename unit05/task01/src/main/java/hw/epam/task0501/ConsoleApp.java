package hw.epam.task0501;

import java.util.Scanner;

public class ConsoleApp {
    private Scanner consoleScanner = new Scanner(System.in);
    String command = "";


    public void run(){
        System.out.println("Hello World");
        System.out.println("U can do smth with files using this app");
        System.out.println("But i won`t tell u, what can u do, and how to do smth");
        while (true){
            System.out.println("Input some command");
            command = consoleScanner.nextLine();
            switch (command){
                case "biba":
            }
        }
    }
}
