


package byui.cit260.vikingQuest.view;

import byui.cit260.vikingQuest.control.ProgramControl;
import byui.cit260.vikingQuest.model.Player;
import java.util.Scanner;


/**
 *
 * @author Jenny, Ivy, Amy
 */

public class StartProgramView {
    
    public StartProgramView() {
    }
    
    public void startProgram(){
            //Display Banner
            this.displayBanner();
            
            //Prompt player for name and save it
            String playersName = this.getPlayersName();
            
            //Create and save player object
            Player player = ProgramControl.createPlayer(playersName);
            
            //Display a personalized welcome message
            this.displayWelcomeMessage(player);
            
            //Display the Main Menu
            MainMenuView mainMenuView= new MainMenuView();
            mainMenuView.display();
    }
    private void displayBanner(){
        
        System.out.println(" " + "\n***  Viking Quest ***");
    }
    public String getPlayersName(){
            boolean valid = false;// indicates whether name has been retrived.
            String playersName = null;
            Scanner keyboard = new Scanner(System.in);// keyboard input stream
            
            while(!valid){// while invalid name has not been retrived.
                
                //prompt for player's name
                System.out.println("Enter the your name below: \n");
                
                //get the name from the keyboard trim off blank spaces
                playersName = keyboard.nextLine();
                playersName = playersName.trim();
                
                //if the name is invalid (less than 2 char in length)
                if(playersName.length()<2){
                    System.out.println("Invalid name - The name must not be blank.");
                    continue; // and repeat again
                   
                }
                break; // out of the (exit) the repitition.     
            }
            return playersName; //return the name                
            }

    private void displayWelcomeMessage(Player player) {
        
        System.out.println("\n=================================================");
        System.out.println("\n");
        System.out.println("\t  Welcome To Viking Quest " + player.getName() + "!");
        System.out.println("\n");
        System.out.println("\t  Enjoy And Good Luck!");
        System.out.println("\n================================================="); 
        System.out.println("\n");
    }
    
}  
