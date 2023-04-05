package Controller;

import View.ViewEnterPage;

public class ControllerEnterPage {
    public void enterPage(){
        ViewEnterPage viewEnterPage = new ViewEnterPage();
        int choice = 1;
        while (choice != 0 ){
            viewEnterPage.visitEnterPage();
            choice=viewEnterPage.enterChoice();
            if(choice == 1){
                AccountController accountController = new AccountController();
                accountController.signUpPurchaser();
            }
            else if(choice == 2){
                AccountController accountController = new AccountController();
                accountController.logInPurchaser();
            }
            else if(choice == 3){
               productController productController = new productController();
                productController.productsController();
            }
            else if (choice!=0){
                viewEnterPage.error();
            }
        }
    }
}
