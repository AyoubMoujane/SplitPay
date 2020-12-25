package ui.controller;

import core.facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.SplitPay;
import ui.path.UserNavigationPath;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button myTransactionsButton;
    @FXML
    private Button mySplitsButton;
    @FXML
    private Button notificationsButton;
    @FXML
    private Button friendsButton;
    @FXML
    private Button groupsButton;
    @FXML
    private Button personalInformationButton;
    @FXML
    private Button creditCardsButton;
    @FXML
    private Button bankAccountButton;

    @FXML
    private Label general;
    @FXML
    private Label socialLabel;
    @FXML
    private Label myInformationLabel;




    @FXML
    private void initialize() {
        if(UserFacade.getUserFacade().isStoreOwner()){
            groupsButton.setManaged(false);
            friendsButton.setManaged(false);
            creditCardsButton.setManaged(false);

            socialLabel.setManaged(false);
            socialLabel.setManaged(false);

        }
    }

    /**
     * This method redirects to the myTransactionsView
     * @param actionEvent
     * @throws IOException
     */
    public void goToMyTransactionsView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(UserNavigationPath.myTransactionsView));
        SplitPay.window.setScene(new Scene(root));
    }

    /**
     * This method redirects to the mySplitsView
     * @param actionEvent
     * @throws IOException
     */
    public void goToMySplitsView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(UserNavigationPath.mySplitsView));
        SplitPay.window.setScene(new Scene(root));
    }

}