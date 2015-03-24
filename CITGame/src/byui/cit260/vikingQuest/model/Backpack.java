
   package byui.cit260.vikingQuest.model;
import java.io.Serializable;

/**
 *
 * @author Amy Jennifer Ivy
 */


public class Backpack implements Serializable{

    private String type;
    private long quantity;
    private double requiredAmount;
    
    public Backpack() {
        this.type = "\n This backpack you carry throughout"
                + "\n your journy to collect items needed to reach"
                + "\n the treasure. There is a limit. Be careful"
                + "\n and only add what you need.";
        this.quantity = 0;
        this.requiredAmount = 10;
    }
}
