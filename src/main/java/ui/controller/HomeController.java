package ui.controller;

import core.facade.UserFacade;
import core.models.NormalUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import main.SplitPay;
import ui.path.AuthPath;
import ui.path.NormalUserNavigationPath;
import ui.path.UserNavigationPath;

import javax.swing.*;
import java.io.IOException;

public class HomeController {

    @FXML
    private Label balance;

    @FXML
    private Button sendMoneyToFriendButton;


    @FXML
    private void initialize() {
        balance.setText(UserFacade.getUserFacade().getLoggedUser().getBalance().toString()+"€");
        if(UserFacade.getUserFacade().isStoreOwner()){
            sendMoneyToFriendButton.setVisible(false);
        }
    }

    public void goToChooseFriendView(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(NormalUserNavigationPath.chooseFriendView));
        SplitPay.window.setScene(new Scene(root));
    }

    public void goToManageBalanceView(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(UserNavigationPath.manageBalanceView));
        SplitPay.window.setScene(new Scene(root));
    }

    /**
     * This method redirects to the myTransactionsView
     * @param actionEvent
     * @throws IOException
     */
    public void goToHomeView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(UserNavigationPath.homeView));
        SplitPay.window.setScene(new Scene(root));
    }
}
