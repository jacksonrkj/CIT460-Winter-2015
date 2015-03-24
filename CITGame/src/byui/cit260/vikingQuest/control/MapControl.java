/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.vikingQuest.control;

import byui.cit260.vikingQuest.exceptions.MapControlException;
import byui.cit260.vikingQuest.model.Map;
import java.awt.Point;
import vikingquest.VikingQuest;

/**
 *
 * @author Amy
 */
public class MapControl {

    public static Map createMap() throws MapControlException {
       System.out.println("*** called createMap() function ***");
       return null;
    }

    public static void moveActorsToStartingLocation(Map map) {
        System.out.println("*** moveActorsToStartingLocation() called***");
    }

    
    public static int moveActorToLocation(Character character, Point coordinates) throws MapControlException{
        
        Map map = VikingQuest.getCurrentGame().getMap();
         int newRow = coordinates.x-1;
         int newColumn = coordinates.y-1;
        
        if(newRow < 0 || newRow >= map.getNoOfRows() ||
                newColumn < 0 || newColumn >= map.getNoOfColumns) {
            throw new MapControlException("Cannot move actor to location."
                    + coordinates.x + "," + coordinates.y
                    + "Because that location is outside"
                    + "the bounds of the map.");
     
        }
        return 0;
        
    }

    double calcLevelPoints(int questionLevel, int ansCorrectly) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
