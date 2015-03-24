
/*
 * Scene
 */
package byui.cit260.vikingQuest.model;

//Directories
import byui.cit260.vikingQuest.control.CreateScenes;
import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Amy, Jennifer, Ivey
 */
public enum Scene implements Serializable{
    
    Temple("Ancient temple ruins deep in the jungle"),
    Ruins("Ancient city capital ruins near the river"),
    VikingMound("Haunted burial-ground for the vikings"),
    Mountains("Jagad peaks that stand between the beach and jungle."),
    Start("Where your quest Begins! The bay where the boat dropps you off."),
    Town("A small town near the beach. A good place to gather supplies."),
    Hut("Trade for an dbuy supplies here."),
    Jungle("The thick jungle covering most of the island.");
    
    private final String description;
    private final Point coordinates;
    private InventoryItem[] item;
    private Location location;
    
    Scene(String description){
        this.description = description;
        coordinates = new Point(1,1);
    }
   
    public String getDescription(){
        return description;
    }
    
    public Point getCoordinates(){
        return coordinates;
    }
    
    public InventoryItem[] items(){
        return item;
    }
    
    public Location location(){
        return location;
    }

    public void setMapSymbol(String _st_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIcon(CreateScenes.ImageIcon startingSceneImage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTravelTime(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setBlocked(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDescription(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTravelTime(double POSITIVE_INFINITY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setType(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
