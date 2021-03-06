package core.models;

import java.util.Date;

/**
 * Model of the UserToBankAccount which represents the transaction from a User's balance to a BankAccount.
 *
 * @author Julien Wiegandt
 * @version 1.0
 * @since 2021-01-05
 */
public class UserToBankAccount extends Transaction {

    private int sender_fk;
    private int receiver_fk;

    /**
     * UserToBankAccount's constructor.
     *
     * @param amount
     * @param dateCreated
     * @param sender_fk
     * @param receiver_fk
     */
    public UserToBankAccount(Float amount, Date dateCreated, int sender_fk, int receiver_fk) {
        this.name = "UserToBankAccount";
        this.amount = amount;
        this.dateCreated = dateCreated;
        this.sender_fk = sender_fk;
        this.receiver_fk = receiver_fk;
    }

    public int getSender_fk() {
        return sender_fk;
    }

    public void setSender_fk(int sender_fk) {
        this.sender_fk = sender_fk;
    }

    public int getReceiver_fk() {
        return receiver_fk;
    }

    public void setReceiver_fk(int receiver_fk) {
        this.receiver_fk = receiver_fk;
    }

    /**
     * Represents the transaction.
     *
     * @return the String representation of the transaction.
     */
    public String toString() {
        return "To BankAccount " + this.getReceiver_fk() + ": -" + this.getAmount() + "€ on " + this.getDateCreated().toString();
    }
}
