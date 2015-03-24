/*
 * Items Class Functions
 */
package byui.cit260.vikingQuest.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Amy, Jennifer, Ivey
 */
    
public class InventoryItem implements Serializable {
    public static String getType;
    public static String getQuantity;
    private static String name;
    private static String ability;
    private static Scene scene;
    public static int requiredAmount;
    private Object type;

    public InventoryItem() {
    }
      
    public Scene scene(){
        return scene;
    }

    public static String getGetType() {
        return getType;
    }

    public static void setGetType(String getType) {
        InventoryItem.getType = getType;
    }

    public static String getGetQuantity() {
        return getQuantity;
    }

    public static void setGetQuantity(String getQuantity) {
        InventoryItem.getQuantity = getQuantity;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        InventoryItem.name = name;
    }

    public static String getAbility() {
        return ability;
    }

    public static void setAbility(String ability) {
        InventoryItem.ability = ability;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        InventoryItem.scene = scene;
    }

    public static int getRequiredAmount() {
        return requiredAmount;
    }

    public static void setRequiredAmount(int requiredAmount) {
        InventoryItem.requiredAmount = requiredAmount;
    }

    public Object getType() {
 
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public void setQuantity(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
} 