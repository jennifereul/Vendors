import java.util.HashMap;
import java.util.Map;


/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vendor {
    private static HashMap<String, Item> Stock = new HashMap<String, Item>();
    private double balance;

    Vendor(int numCandy, int numGum, double initial) {
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(.5, numGum));
        this.balance = initial;
    }

    /**
     * resets the Balance to 0
     */
    void resetBalance() {   //CORRECT
        this.balance = 0;
    }

    /**
     * returns the current balance
     */
    double getBalance() {    //CORRECT
        return this.balance;
    }

    /**
     * adds money to the machine's balance
     *
     * @param amt how much money to add
     */
    void addMoney(double amt) {    //CORRECT
        if (this.balance + amt < 0) {
            this.balance = 0;
        } else {
            this.balance = this.balance + amt;
        }
    }

    int restock(String item) {     //November 21, 2022  //THIS IS CORRECT DON'T CHANGE
        Item value = Stock.get(item);
        int currentamount = value.stock;
        int futureamount = currentamount + 10;
        Item newitem = new Item(value.price, futureamount);
        Stock.put(item, newitem);
        return newitem.stock;
    }


    int getStock(String name) {
        return 0;
    }  //CORRECT
//This method should return the stock of the name

    /**
     * attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    void select(String name) {         //DON'T CHANGE
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (balance >= item.price) {
                item.purchase(1);
                this.balance = this.balance - item.price;
            } else
                System.out.println("Gimme more money");
        } else System.out.println("Sorry, don't know that item");
    }

    //CORRECT???
    Item ChangeStockName(String oldName, String newName) {
        if (Stock.containsKey(oldName)) {
            Item item = Stock.get(oldName);
            Stock.remove(oldName);
            Stock.put(newName, item);
        } else System.out.println("Sorry, don't know that item");

        return Stock.get(newName);
    }

    //CHECK BELOW NOT DONE
    int emptyInventory(String item) {
        Item value = Stock.get(item);
        value.stock = 0;
        Stock.put(item, value);
        return value.stock;
    }

    //CHECK BELOW NOT DONE
    void printInventoryOfVendor() {
        for (Map.Entry<String, Item> entry : Stock.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }

    }
}



