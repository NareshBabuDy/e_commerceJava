package e_commerce.view;

import e_commerce.utils.StringUtils;

import static e_commerce.utils.Utils.println;

public class RegisterPage {
    public void printRegistrationSuccessful() {
        try {
            println("#---------------------#");
            println(StringUtils.REGISTRATION_SUCCESSFUL);
            println("#---------------------#");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void passwordMisMatch() {
        try {
            println("#---------------------#");
            println(StringUtils.PASSWORD_MISMATCH);
            println("#---------------------#");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
