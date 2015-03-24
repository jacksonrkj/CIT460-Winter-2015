/*
 *This is the main function of VikingQuest
 */
package vikingquest;

//!!!!! Working on Main Menu View. I need it to
//!!!!! call the other classes using team assignment 
//!!!!! eight instructions. 

//Import class statements

import byui.cit260.vikingQuest.view.StartProgramView;
import byui.cit260.vikingQuest.model.Backpack;
import byui.cit260.vikingQuest.model.Characters;
import byui.cit260.vikingQuest.model.Game;
import byui.cit260.vikingQuest.model.InventoryItem;
import byui.cit260.vikingQuest.model.Location;
import byui.cit260.vikingQuest.model.Map;
import byui.cit260.vikingQuest.model.Player;
import byui.cit260.vikingQuest.model.Scene;
import byui.cit260.vikingQuest.model.Skills;


/**
 * @author Amy, Jennifer and Ivy
 */
public class VikingQuest {

    /**
     * @param args the command line arguments
     */
    
    //Class instance Variables
    private static Game currentGame = null;
    private static Player player = null;
    
    //Getter and Setter functions
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        VikingQuest.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        VikingQuest.player = player;
    }
    
    
    
    public static void main(String[] args) {
         
        // Start program view layer
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.startProgram();
        
    } 
    
}
/************************
 * I edited these out for now
 * Page 6 of the Lesson 6 Team Assignment doc 
 * says to "Delete any existing code currently in this function
 * before adding this weeks code here.
 * 
 *        //Game class functions
 8        
 *      //Player functions
 *      Player playerOne = new Player();
 *       
 *       //Map class functions
 *       Map mapOne = new Map();
 *       
 *       //Backpack Class Functions
 *       Backpack backpackOne = new Backpack();
 *       
 *       //Skills Class Functions
 *       Skills skillsOne = new Skills();
 *       
 *       //Characters Functions
 *       Characters charactersOne = new Characters();
 *       
 *       //Items Functions
 *       Items itemsOne = new Items();
 *       
 *       //Location Functions
 *       Location locationOne = new Location();
 *       
 *       //Scene Functions
 *       Scene sceneOne = new Scene();
 *       
 *   }
 *   
 ******************/
