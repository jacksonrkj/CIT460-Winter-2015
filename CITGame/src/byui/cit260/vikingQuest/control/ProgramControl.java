
package byui.cit260.vikingQuest.control;

import byui.cit260.vikingQuest.model.Player;
import vikingquest.VikingQuest;

/**
 *
 * @author Jenny
 */
public class ProgramControl {

    public static Player createPlayer(String name){
        
        // Placeholder
        System.out.println("\n*** createPlayer function called ***");
        
        // Function
        if (name == null){
            return null;
        }
        
        Player player = new Player();
        player.setName(name);
        
        VikingQuest.setPlayer(player); // save the player
        
        return player;
    }
}
