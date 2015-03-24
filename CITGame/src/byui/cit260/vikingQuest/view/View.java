
 package byui.cit260.vikingQuest.view;

import java.util.Scanner;

/**
 *
 * @author Amy
 */
public abstract class View implements ViewInterface {
    
    private String promptMessage;
    
    public View(String promptMessage){
        this.promptMessage = promptMessage;
    }
    
    @Override
    public void display() {
        String value;

        do {
            System.out.println(this.promptMessage); //Display the main menu  
            value = this.getInput(); // Get user selection
            this.doAction(value);  //Do action selected
        
        } while (!value.equals("E")); // A selection is not Exit
        
    }
    
    @Override
    public String getInput() {
        
        Scanner keyboard = new Scanner(System.in);// keyboard input stream
        boolean valid = false;
        String selection = null;
        
        // While a valid name has not been retrieved
        while(!valid){
                
            //prompt user for input
            System.out.println("\t\nEnter your selection: \n");
            
            //get the name from the keyboard trim off blank spaces
            selection = keyboard.nextLine();
            selection = selection.trim();
                
            //if the input is invalid send out error message
            if(selection.length() < 1){  // blank value entered
                System.out.println("Invalid entry - Try again.");
                continue; // and repeat again       
            }
            
            break; // out of the (exit) the repitition.  
        }
      
        return selection; // Return the input
    }
    
    public String getPromptMessage(){
        return promptMessage;
    }

    public void setPromptMessage(String message) {
        this.promptMessage = message;
    }
    
}

