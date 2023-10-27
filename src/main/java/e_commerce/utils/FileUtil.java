package e_commerce.utils;

import java.io.File;

public class FileUtil {

    public static File credentailsFile;
    public static File productLoad;

    public static File getCredentialsFile() {
        if (credentailsFile == null)
            credentailsFile = new File("src/main/java/e_commerce/assests/credentials.csv");
        return credentailsFile;
    }

    public static File getProductsFile() {
        if (productLoad == null)
            new File("src/main/java/e_commerce/assests/product.csv");
        return productLoad;
    }

}
