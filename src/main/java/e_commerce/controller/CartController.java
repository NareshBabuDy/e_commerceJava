package e_commerce.controller;

import e_commerce.models.User;
import e_commerce.utils.StringUtils;
import e_commerce.utils.UserUtils;
import e_commerce.utils.Utils;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static e_commerce.utils.FileUtils.getCartFile;
import static e_commerce.utils.Utils.println;

public class CartController {

    public void loadcart() {
        try {
            User user = UserUtils.getLoggedInUser();
            Scanner scanner = new Scanner(getCartFile());
            while (scanner.hasNext()) {
                String cart = scanner.next().trim();
                if (!cart.startsWith("email")) {
                    String[] cartArray = cart.split(",");
                    if(user.equals(cartArray[0])){
                        if (cartArray[0].equals(user)) {
                            String[] prodarray = cartArray[1].split(":");
                            String[] procount = prodarray[0].split("-");
                            for (int i = 0; i <= prodarray.length; i++) {
                                for (int j = 0; j <= procount.length; j++) {
                                    println(StringUtils.YOUR_CART);
                                    println("User Name: " + user.getName());
                                    println( procount[0] + " " + procount[1]);
                                }
                            }

                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
