package e_commerce.controller;

import e_commerce.utils.AppException;
import e_commerce.utils.StringUtils;
import e_commerce.view.CartPage;
import e_commerce.view.HomePage;
import e_commerce.view.ProductsPage;

import static e_commerce.utils.AppInput.enterInt;
import static e_commerce.utils.UserUtils.setLoggedInUser;
import static e_commerce.utils.Utils.println;

public class HomeController {
    private final HomePage homePage;
    private final CategoryController categoryController;
    private final ProductsPage productsPage;
    private final CartController cartController;
    public HomeController() {
        homePage = new HomePage();
        categoryController = new CategoryController();
        productsPage = new ProductsPage();
        cartController = new CartController();
        
    }

    public void printMenu() {
        homePage.printMenu();
        try {
            int choice = enterInt(StringUtils.ENTER_CHOICE);
            switch (choice){
                case 1:
                    categoryController.catogory();
                    break;
                case 2:
                    productsPage.Product();
                    break;
                case 3:
                    cartController.loadcart();
                    break;
                case 4:

                    break;

            }
        } catch (AppException appException) {
            invalidChoice(appException);
        }
    }

    private void invalidChoice(AppException appException) {
        println(appException.getMessage());
        printMenu();
    }
}
