package ui.controller;

import core.facade.UserFacade;
import core.models.NormalUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import main.SplitPay;
import ui.path.NormalUserNavigationPath;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/**
 * Controller of the chooseFriendView called when the current user have to choose
 * a friend to send him money.
 *
 * @author Julien Wiegandt
 * @version 1.0
 * @since 2020-12-28
 */
public class ChooseFriendController {

    /**
     * Contains all the current user's friends.
     */
    @FXML
    ListView friendsList;

    /**
     * This method transfers the selected friend in the ChooseAmountController and load the chooseAmountView.
     * It is called by a button.
     * @throws IOException
     * @todo Handle the possible exceptions.
     */
    public void goToChooseAmountView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(NormalUserNavigationPath.chooseAmountView));
        Parent root = loader.load();
        ChooseAmountController chooseAmountController = loader.getController();
        chooseAmountController.setFriend((NormalUser) friendsList.getSelectionModel().getSelectedItem());
        SplitPay.window.setScene(new Scene(root));
    }

    /**
     * This method fill the listView with all the current user's friends.
     * It is called at the view's load.
     */
    @FXML
    private void initialize() {
        Collection friends = UserFacade.getUserFacade().getFriends(Integer.valueOf(UserFacade.getUserFacade().getLoggedNormalUser().getId()));
        ObservableList<NormalUser> items = FXCollections.observableArrayList ();
        Iterator<NormalUser> iterator = friends.iterator();
        while (iterator.hasNext()) {
            items.add(iterator.next());
        }
        friendsList.setItems(items);
    }
}
