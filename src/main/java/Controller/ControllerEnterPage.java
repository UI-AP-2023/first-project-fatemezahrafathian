package Controller;

import Model.Exception.InvalidEmail;
import Model.Exception.InvalidPhone;
import View.ViewEnterPage;

public class ControllerEnterPage {
    public void enterPage(){
        ViewEnterPage viewEnterPage = new ViewEnterPage();
        AccountController accountController = new AccountController();
        int choice = 1;
        while (choice != 0 ){
            viewEnterPage.visitEnterPage();
            choice=viewEnterPage.enterChoice();
            if(choice == 1){
//                try {
//                    accountController.signUpPurchaser();
//                } catch (InvalidEmail e) {
//                    e.getMessage();
//                } catch (InvalidPhone e) {
//                    e.getMessage();
//                }
            }
            else if(choice == 2){
                //accountController.logInPurchaser();
            }
            else if(choice == 3){
               ProductController productController = new ProductController();
                productController.productsController();
            }
            else if (choice!=0){
                viewEnterPage.error();
            }
        }
    }
}
