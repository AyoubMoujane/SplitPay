package server.models.split;

import java.io.Serializable;

public class Item implements Serializable {

    private final String label;
    private final double price;
    private boolean isPicked = false;

    public Item(String label, double price){
        this.label=label;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public String getLabel(){
        return label;
    }

    public boolean isPicked() {
        return isPicked;
    }

    public void setPicked(boolean picked) {
        isPicked = picked;
    }

    @Override
    public String toString() {
        String str = label + " : " + price;
        if(isPicked()){
            str += "\u270A";
        }else{
            str += "\u270B";
        }
        return str;
    }
}
