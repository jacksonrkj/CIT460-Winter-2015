/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.vikingQuest.model;
import byui.cit260.vikingQuest.control.GameControl;
import java.io.Serializable;
/**
 *
 * @author Amy
 */
public class Map implements Serializable{

    private static Scene[] createScenes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Instance Class Variables
    private int noOfRows;
    private int noOfColums;
    private Location[][] locations;
    public int getNoOfColumns;
    
    public Map(){
    }
    
    public Map(int noOfRows, int noOfColumns){
        
        if (noOfRows < 1 || noOfColumns < 1){
            System.out.println("The number of rows and columns must be > zero");
            return;
        }
        
        this.noOfRows = noOfRows;
        this.noOfColums = noOfColumns;
        
        // Create 2-D array for location objects
        this.locations = new Location[noOfRows][noOfColumns];
        
        for (int row = 0; row < noOfRows; row++){
            for(int colum = 0; colum < noOfColumns; colum++){
                // Create and initalize new location object instance
                Location location = new Location();
                location.setColumn(colum);
                location.setRow(row);
                location.setVisited(false);
                
                // Assign the location to the current position in array
                locations[row][colum] = location;
            }
        }
    }
    
    private static Map createMap(){
        // Create the map
        Map map = new Map(20,20);
        
        // Create scenes for the game
        Scene[] scenes = createScenes();
        
        // Assignscenes to locations
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;
    }

    public Location[][] getLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNoOfRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
