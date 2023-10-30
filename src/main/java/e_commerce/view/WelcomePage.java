package e_commerce.view;

import e_commerce.utils.StringUtils;

import static e_commerce.utils.Utils.println;

public class WelcomePage {
    public void welcome() {
        try {
            println(StringUtils.WELCOME_MESSAGE);
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
