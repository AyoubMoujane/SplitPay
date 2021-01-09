package ui.controller.manageGroup;

import core.facade.GroupFacade;
import core.models.Group;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import main.SplitPay;
import ui.path.NormalUserNavigationPath;
import ui.path.UserNavigationPath;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class GroupController {

    @FXML
    private Button addCreditCard;

    @FXML
    private ListView listView;

    @FXML
    private Button retour;


    @FXML
    private void initialize() {
        Collection groups = GroupFacade.getInstance().getAllGroup();
        ObservableList<Group> items = FXCollections.observableArrayList();

        Iterator<Group> iterator = groups.iterator();
        while (iterator.hasNext()) {
            items.add(iterator.next());
        }
        listView.setItems(items);

    }


    /**
     * @throws IOException
     * @todo Handle the possible exceptions. (if the user click on empty field)
     */
    @FXML
    public void goToEditGroupView() throws IOException {
        if (listView.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(NormalUserNavigationPath.editGroupView));
            Parent root = loader.load();
            EditGroupController editGroupController = loader.getController();
            editGroupController.setGroup((Group) listView.getSelectionModel().getSelectedItem());
            SplitPay.window.setScene(new Scene(root));
        }

    }


    public void goToAddGroupView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(NormalUserNavigationPath.addGroupView));
        SplitPay.window.setScene(new Scene(root));

    }

    public void goToHomeView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(UserNavigationPath.homeView));
        SplitPay.window.setScene(new Scene(root));

    }
}
