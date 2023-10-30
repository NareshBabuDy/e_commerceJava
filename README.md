# e_commerceJava
Challenges Faced:
In the Initial period I Struggled to load the product from the csv file.
Then I tried to increase the count in the cart of the specific product.



1. Login - Existing User and Admin
2. Register - New User
3. Home - User
    * View Categories 
        - View products based on category.
    * View Products 
    * View Cart 
        - Add products to cart.
        - Check out products from cart.
    * View Order 
    * Logout
4. Home - Admin 
    * View Categories 
        - Add Category 
        - Remove Category 
    * View Products 
        - Add Product 
        - Edit Product 
        - Delete Product 
    * View Orders 
    * Logout
Steps:
1. "User credential" file for storing user data.
2. "Category data" file for storing categories.
3. "Product data" file for storing Products.
4. "Cart data" file for storing user cart details.
5. "Order data" file for storing user order details.Steps:
------
1. Used MVC (Model, View, Controller) architecture for developing the console application.
2. Added the required Models, Views and Controller along with Interface implementation to achieve abstraction.
3. Added user-defined exceptions to catch anf handle the exceptions.
4. Used encapsulation to hide data and used getter and setter for getting and setting the data for the models.
5. Used "ArrayList" to store and manipulate data according to the user preferrences.
6. Used "CSV" Files for handling data.
7. Stored the file path, Scanner class other sensitive information in a separate Utility folder.
8. Used Singleton pattern to avoid creating objects.
9. Used "Date" class for handling date for orders.
10. Handled exceptions for invalid choices.

    1. Admin Home 
    * View Categories
        - Remove Category 
    * View Products 
        - Edit Product 
        - Delete Product 
