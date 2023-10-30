package e_commerce.view;

import e_commerce.utils.StringUtils;

import static e_commerce.utils.Utils.println;

public class LoginPage {
    public void printInvalidCredentials() {
        try {
            println("#---------------------#");
            println(StringUtils.INVALID_CREDENTIALS);
            println("#---------------------#");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
