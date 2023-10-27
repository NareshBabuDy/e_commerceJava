package e_commerce.utils;

import java.io.File;
import java.util.Scanner;

public class AppScanner {
    private static Scanner scanner;

    private static Scanner fileSanner;
    public static Scanner getScanner() {
        if (scanner == null)
            scanner = new Scanner(System.in);
        return scanner;
    }
    public static Scanner getScannerf(File msg) {
        if (fileSanner == null)
            fileSanner = new Scanner(System.in);
        return fileSanner;
    }
}
