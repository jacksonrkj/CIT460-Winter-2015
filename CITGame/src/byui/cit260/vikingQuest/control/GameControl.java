/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.vikingQuest.control;

import byui.cit260.vikingQuest.model.Backpack;
import byui.cit260.vikingQuest.model.Game;
import byui.cit260.vikingQuest.model.Map;
import byui.cit260.vikingQuest.model.Player;
import byui.cit260.vikingQuest.model.Scene;
import byui.cit260.vikingQuest.model.InventoryItem;
import vikingquest.VikingQuest;


/**
 *
 * @author Amy
 */

    
/**
*
* @param player
*/

public class GameControl {
    
    public static void createNewGame(Player player) throws MapControl.MapControlException {
        
        Game game = new Game(); // Create new game
        VikingQuest.setCurrentGame(game); // Save in Viking Quest
        
        game.setPlayer(player); // save player in game
        
        // Create the inventory list and save in game
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        game.setItems(inventoryList);
        
        Backpack backpack = new Backpack(); // Create new backpack
        game.setBackpack(backpack); // Save Backpack in game
        
        Map map = MapControl.createMap(); // create new map
        game.setMap(map);  // Save map in game
        
        // Move characters to starting position on Map
        MapControl.moveActorsToStartingLocation(map);
    }

    
    public static InventoryItem[] createInventoryList(){
        System.out.println("*** called create inventory list() in Game Control ***");
        return null;
    }
    
    public static void moveActorsToStartingLocation(Map map){
        System.out.println("*** called moveActorsToStartingLocation***");
    }

    public static void assignScenesToLocations(Map map, Scene[] scenes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static createInventoryList.Item[] getSortedInventoryList() {
        System.out.println("Write inventory item list here according to lesson 9 team instructions - Brother Jackson");
        return null;
    }

}