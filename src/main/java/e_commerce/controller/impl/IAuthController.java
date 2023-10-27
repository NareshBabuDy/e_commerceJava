package e_commerce.controller.impl;

import e_commerce.utils.AppException;

public interface IAuthController {

    void authMenu();

    void login() throws AppException;

    void register();

    void logout();

}
