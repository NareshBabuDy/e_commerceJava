

package e_commerce.controller;

import e_commerce.utils.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static e_commerce.utils.AppInput.enterInt;
import static e_commerce.utils.AppInput.enterString;
import static e_commerce.utils.FileUtils.getCartFile;
import static e_commerce.utils.Utils.println;
import static java.lang.Integer.parseInt;

public class ProductController {

    public static void Products() {
        loadproduct();
        try {
            String choice = enterString(StringUtils.PRODUCT_ID);
            addtocart(choice);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


//    private static void addtocart(int choice) throws IOException {
//        String productname = findproduct(String.valueOf(choice));
//        String user = UserUtils.getLoggedInUser().getEmail();
//        FileWriter cartAdd = new FileWriter(getCartFile(), true);
//        Scanner scanner = new Scanner(getCartFile());
//        String newcart;
//        while (scanner.hasNext()) {
//            String value = scanner.next().trim();
//            if (!value.startsWith("email")) {
//                String[] cartArray = value.split(",");
//                if (user == cartArray[0]) {
//                    while (scanner.hasNext()) {
//                        String cart = scanner.next().trim();
//                        if (!cart.startsWith("email")) {
//                            String[] userCart = cart.split(",");
//                            if (userCart[1] == productname) {
//                                String[] ucProd = (userCart[1].split("-"));
//                                int intValue = parseInt(ucProd[1]);
//                                intValue += 1;
//                                newcart = (user + "," + productname + "-" + intValue);
//                            }
//                        }
//                    }
//                    cartAdd.append((user + "," + productname));
//                } else {
//                    cartAdd.append(user + "," + productname + "-" + 1);
//
//                }
//            }
//        }
//        Products();
//    }

    static void addtocart(String choice) throws IOException {
        String productname = findproduct(choice);
        String user = UserUtils.getLoggedInUser().getEmail();
        FileWriter cartAdd = new FileWriter(getCartFile(), true);
        Scanner scanner = new Scanner(getCartFile());

        while (scanner.hasNext()) {
            String cart = scanner.next().trim();
            if (!cart.startsWith("email")) {
                String[] cartArray = cart.split(",");
                if (cartArray[0].equals(user)) {
                    if (cartArray[1].equals(productname)) {
                        int count = parseInt(cartArray[2]);
                        int updcount =count + 1;

//                        cartArray[2].replace((char) count, (char) updcount);
                        cartAdd.write( user + "," + productname + "," + updcount+"\n");
                        cartAdd.close();
                        Products();
                    } else {
                        String str = "\n" + user + "," + productname + "," + 1;
                        cartAdd.append(str);
                        cartAdd.close();
                        Products();
                    }

                }


            }
            else {
                cartAdd.write("\n" + user + "," + productname + "," + 1);
                cartAdd.close();
                Products();
            }
        }
    }


    private static String findproduct(String choice) {
        try {
            Scanner scanner = new Scanner(FileUtils.getProductFile());
            while (scanner.hasNext()) {
                String prod = scanner.next().trim();
                if (!prod.startsWith("id")) {

                    String[] userArray = prod.split(",");
                    if (choice.equals(userArray[0])) {
                        println(userArray[1]);
                        return userArray[1];
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return "null";
    }


    public static void loadproduct() {
        try {
            Scanner scanner = new Scanner(FileUtils.getProductFile());
            while (scanner.hasNext()) {
                String prod = scanner.next().trim();
                if (!prod.startsWith("id")) {
                    String[] userArray = prod.split(",");
                    println(userArray[0] + ". " + userArray[1] + " Rs." + userArray[2] + " " + userArray[3]);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}