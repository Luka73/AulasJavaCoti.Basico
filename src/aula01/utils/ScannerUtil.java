package aula01.utils;

import java.util.Scanner;

public class ScannerUtil {

    private Scanner sc;

    public ScannerUtil() {
        sc = new Scanner(System.in);
    }

    public String read(String msg) throws Exception { // --> obriga a quem chamar tratar a exception
        System.out.println(msg);
        return sc.nextLine();
    }
}
