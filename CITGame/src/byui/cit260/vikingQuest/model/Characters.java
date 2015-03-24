/*
 * Characters Class Functions
 */
package byui.cit260.vikingQuest.model;

//Directories
import java.io.Serializable;

/**
 *
 * @author Amy, Jennifer, Ivey
 */

public enum Characters implements Serializable{
    
    Elf("Elf Description Here"),
    Dwarf("Dwarf description here"),
    Vampire("Vampire description here"),
    Warewolf("Warewolf Description here"),
    Wizzard("Wizzard Description here"),
    Hawk("Hawk description here"),
    Giant("Giant description here"),
    BabyDraggon("Baby draggon description here");
    
    //Class instance variables
    private final String description;

    Characters(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return description;
    }

}


