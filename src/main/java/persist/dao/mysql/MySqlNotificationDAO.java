package persist.dao.mysql;

import core.facade.UserFacade;
import core.models.Notification;
import persist.dao.NotificationDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySqlNotificationDAO extends NotificationDAO {

    /**
    * Creates a notification and add it to the database
    * @param notification
     */

    public void addNotification(Notification notification) {
        Statement stmt = null;
        try {
            stmt = ConnectionMySql.connection.createStatement();
            System.out.println("INSERT INTO Notification (`label`, `message`, `normal_user_fk`, `dateCreated`) VALUES ('"+notification.getLabel()+"', '"+notification.getMessage()+"', '" + UserFacade.getUserFacade().getLoggedUser().getId()+"', '" +"2020-12-24 17:19:43"+"')");

            Integer rs = stmt.executeUpdate("INSERT INTO Notification (`label`, `message`, `normal_user_fk`, `dateCreated`) VALUES ('"+notification.getLabel()+"', '"+notification.getMessage()+"', '" + UserFacade.getUserFacade().getLoggedUser().getId()+"', '" +"2020-12-24 17:19:43"+"')");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }



    public ArrayList<Notification> getNotifications(String id) {
        Statement stmt = null;
        ArrayList<Notification> notifications = new ArrayList<Notification>();


        try {
            stmt = ConnectionMySql.connection.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From Notification WHERE normal_user_fk ="+"'"+ id +"'");
            while(rs.next()) {
                Notification notification = new Notification(rs.getString("normal_user_fk"),rs.getString("label"),rs.getString("message"));

                System.out.println(notification);
                notifications.add(notification);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return notifications;
    }

    /**
     * delete from the database
     * @param id
     */
    public void deleteNotificationById(String id) {
        Statement stmt = null;
        PreparedStatement preparedStmt = null;
        try {
            stmt = ConnectionMySql.connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            System.out.println("DELETE FROM Notification WHERE notification_pk='" + id +"'");
            preparedStmt = ConnectionMySql.connection.prepareStatement("DELETE FROM Notification WHERE notification_pk='" + id +"'");
            preparedStmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
