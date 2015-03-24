
   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.vikingQuest.view;

import byui.cit260.vikingQuest.control.GameControl;
import byui.cit260.vikingQuest.control.createInventoryList.Item;
import byui.cit260.vikingQuest.model.InventoryItem;
import vikingquest.VikingQuest;

/**
 *
 * @author Amy
 */

public class GameMenuView extends View{
    private static InventoryItem tempItem;
        
    //Game Menu
    public GameMenuView(){
        
        super ("\n"
        + "\n---------------------"
        + "\n|     Game Menu     |"
        + "\n---------------------"
        + "\nV - View Map"
        + "\nB - Backpack"
        + "\nT - Talk to someone"
        + "\nG - Give Item"
        + "\nI - Item Recieved"
        + "\nH - Help"
        + "\nQ - Quit Game Menu"
        + "\n---------------------");
    }
    
    public void doAction(char selection) {
        
        switch (selection) {
            case 'V': // View Map
                this.displayMap();
                break;
            case 'B': // Backpack
                this.viewBackpack();
                break;
            case 'T': // Talk to someone
                this.talk();
                break;
            case 'G': // Give Item
                this.giveItem();
                return;
            case 'I': // Item (Received)
                this.itemRecieved();
                return;
            case 'H': // Item (Received)
                this.displayHelpMenu();
                return;
            case 'Q': // Exit to Main Menu
                this.returnToMain();
                return;
            default:
                System.out.println("\n*** Invalid Selection *** Try Again");
                break;
        }
    }
     
    public void displayMap() {        
        //Display the game menu
        MapMenuView mapMenu = new MapMenuView();
        mapMenu.display();
        
    }
    
    private void viewBackpack() {
        // Get the sorted list of inventory items for the current game
        Item[] inventory = GameControl.getSortedInventoryList();
        
        System.out.println("\n List of inventory Items");
        System.out.println("Description" + "\t" + 
                            "Required" + "\t" +
                            "In Stock");
        
        // For each inventory item
        for (Item inventoryItem : inventory){
            // Display the description, the required amount and amount in stock
            System.out.println(InventoryItem.getType + "\t   " +
                                InventoryItem.requiredAmount + "\t   " +
                                InventoryItem.getQuantity);
        }
        
    }
    
    public static InventoryItem[] getSortedInventoryList(){
        
        // Get inventory list for the current game
        InventoryItem[] originalInventoryList = 
                        VikingQuest.getCurrentGame().getItems();
        // Clone (make a copy) origionalList
        InventoryItem[] inventoryList = originalInventoryList.clone();
    
        // Using a BubbleSort to sort the list of inventoryList by name
        Item tempInventoryItem;
        for (int i=0; i<inventoryList.length-1; i++){
            for (int j=0; j<inventoryList.length-1-i; j++){
                if (inventoryList[j].getType().
                          compareToIgnoreCase(inventoryList[j + 1].getType()) > 0){
                    tempItem = inventoryList[j];
                    inventoryList[j] = inventoryList[j+1];
                    inventoryList[j+1] = tempItem;
                }
            }
        }
        return inventoryList;   
    }
    
    private void talk() {
        
        System.out.println("*** talk() function called ***");
    }
    
    private void giveItem() {
        
        System.out.println("*** giveItem()displayHelpMenu function called ***");
    } 
    
    private void itemRecieved() {
        
        System.out.println("*** itemRecieved()displayHelpMenu function called ***");
    } 
    
    private void displayHelpMenu(){   
        GameHelpMenu gameHelpMenu = new GameHelpMenu();
        gameHelpMenu.display();
        
    } 
    
    private void returnToMain() { 
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();

    } 

    @Override
    public void doAction(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
