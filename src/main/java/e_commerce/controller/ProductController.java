package e_commerce.controller;

import e_commerce.controller.impl.IProductController;
import e_commerce.utils.AppException;
import e_commerce.utils.AppScanner;
import e_commerce.utils.FileUtil;
import e_commerce.utils.Utils;
import e_commerce.view.CatogoryPage;

import java.util.Scanner;

public class ProductController  {
    private final CatogoryController catogoryController;
    public ProductController() {
        catogoryController = new CatogoryController();
    }

    public void option(int choice){
        switch (choice){
            case 1:
//                catogoryController.
                break;
            case 2:

                break;
        }

    }

//    public void loadProduct() {
//        try {
//            Scanner fscanner = AppScanner.getScannerf(FileUtil.getProductsFile());
//            while (fscanner.hasNext()) {
//                String prod = fscanner.next().trim();
//                if (!prod.startsWith("id")) {
//                    String[] userArray = prod.split(",");
////                    Utils.println(userArray[0]);
//                    Utils.print(userArray[1] + " " + userArray[2] + " " + userArray[3]);
//                }
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
////        Utils.println("hello");
//    }
}
