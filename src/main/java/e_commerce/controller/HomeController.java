package e_commerce.controller;

import e_commerce.controller.impl.IHomeController;
import e_commerce.utils.AppException;
import e_commerce.utils.AppInput;
import e_commerce.utils.StringUtil;
import e_commerce.utils.Utils;

public class HomeController implements IHomeController {

    private final ProductController productController;

    public HomeController() {
        productController = new ProductController();
    }

    @Override
    public void printMenu() throws AppException {
        Utils.println(StringUtil.WELCOME_MESSAGE);
        Utils.println(StringUtil.HOME_MENU);
        productController.option(AppInput.enterInt(StringUtil.ENTER_CHOICE));
    }
}
