package e_commerce.controller;

import e_commerce.controller.impl.IAppController;
import e_commerce.view.WelcomePage;

public class AppController implements IAppController {
    private final WelcomePage welcomePage;
    private AuthController authController;


    public AppController() {
        welcomePage = new WelcomePage();
        authController = new AuthController();
    }

    public void init() {
        welcomePage.welcome();
        authController.authMenu();
    }
}
