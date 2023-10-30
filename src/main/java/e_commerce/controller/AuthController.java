package e_commerce.controller;

import e_commerce.controller.impl.IAuthController;
import e_commerce.models.Role;
import e_commerce.models.User;
import e_commerce.utils.AppException;
import e_commerce.utils.AppInput;
import e_commerce.utils.StringUtils;
import e_commerce.view.AuthPage;
import e_commerce.view.LoginPage;
import e_commerce.view.RegisterPage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static e_commerce.utils.AppInput.enterString;
import static e_commerce.utils.FileUtils.getCredentialsFile;
import static e_commerce.utils.UserUtils.setLoggedInUser;
import static e_commerce.utils.Utils.println;

public class AuthController implements IAuthController {
    private final AuthPage authPage;
    private final HomeController homeController;
    private final LoginPage loginPage;
    private final RegisterPage registerPage;


    public AuthController() {
        homeController = new HomeController();
        authPage = new AuthPage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
    }

    public void authMenu() {
        authPage.logingway();
        int choice;
        try {
            choice = AppInput.enterInt(StringUtils.ENTER_CHOICE);
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                default:
                    invalidChoice(new AppException(StringUtils.INVALID_CHOICE));
                    break;
            }
        } catch (AppException appException) {
            invalidChoice(appException);
        }

    }

    @Override
    public void login() {
        String email, password;
        email = enterString(StringUtils.ENTER_EMAIL);
        password = enterString(StringUtils.ENTER_PASSWORD);
        User user = validate(email, password);
        if (user != null) {
            setLoggedInUser(user);
            homeController.printMenu();
        } else {
            loginPage.printInvalidCredentials();
            authMenu();
        }

    }

    @Override
    public void register() {
        String name, email, password, c_password;
        name = enterString(StringUtils.ENTER_NAME);
        email = enterString(StringUtils.ENTER_EMAIL);
        password = enterString(StringUtils.ENTER_PASSWORD);
        c_password = enterString(StringUtils.ENTER_PASSWORD_AGAIN);

        if (password.equals(c_password)) {
            try {
                FileWriter csvWriter = new FileWriter(getCredentialsFile(), true);
                int id = (int) (Math.random() * 100);
                csvWriter.append("\n");
                csvWriter.append(id + "," + name + "," + email + "," + password);
                csvWriter.flush();
                csvWriter.close();
                registerPage.printRegistrationSuccessful();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            registerPage.passwordMisMatch();
        }
        authMenu();
    }

    public User validate(String email, String password) {
        try {
            Scanner scanner = new Scanner(getCredentialsFile());
            while (scanner.hasNext()) {
                String value = scanner.next().trim();
                if (!value.startsWith("id")) {
                    String[] userArray = value.split(",");
                    if (userArray[2].equals(email) && userArray[3].equals(password)) {
                        User user = new User();
                        user.setId(Integer.parseInt(userArray[0]));
                        user.setName(userArray[1]);
                        user.setEmail(userArray[2]);
                        user.setPassword(userArray[3]);
                        if (user.getEmail().equals("admin@admin.com"))
                            user.setRole(Role.ADMIN);
                        else
                            user.setRole(Role.USER);
                        return user;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void logout() {

    }


    private void invalidChoice(AppException e) {
        println(e.getMessage());
        authMenu();
    }

}
