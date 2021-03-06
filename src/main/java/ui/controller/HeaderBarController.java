package ui.controller;

import core.facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import main.SplitPay;
import ui.path.AuthPath;
import ui.path.UserNavigationPath;

import java.io.IOException;

public class HeaderBarController {

    @FXML
    private Label nickName;

    /**
     * This method redirects to the myTransactionsView
     *
     * @param actionEvent
     * @throws IOException
     */
    public void goToHomeView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(UserNavigationPath.homeView));
        SplitPay.window.setScene(new Scene(root));
    }

    /**
     * This method logs the current user out and redirects him to the login page
     *
     * @param actionEvent
     * @throws IOException
     */
    public void logout(ActionEvent actionEvent) throws IOException {
        UserFacade.getUserFacade().logout();
        Parent root = FXMLLoader.load(getClass().getResource(AuthPath.logInView));
        SplitPay.window.setScene(new Scene(root));
    }

    @FXML
    private void initialize() {
        String display;
        if (UserFacade.getUserFacade().isStoreOwner()) {
            display = "Store owner : ";
        } else {
            display = "User : ";
        }
        nickName.setText(display + UserFacade.getUserFacade().getLoggedUser().getNickname());
    }
}
