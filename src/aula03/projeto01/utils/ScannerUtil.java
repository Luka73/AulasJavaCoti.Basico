package aula03.projeto01.utils;

import java.util.Scanner;

public class ScannerUtil {

    @SuppressWarnings("resource")
    public static String read(String message) throws Exception {
        System.out.println(message);
        return new Scanner(System.in).next();
    }
}
