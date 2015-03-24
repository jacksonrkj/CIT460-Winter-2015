
package byui.cit260.vikingQuest.model;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author Amy Jennifer Ivy
 */
public class Skills implements Serializable{
    
    // Class instance variables
    private String skillName;
    private String abilityDefinition;
    private String weaknesses;
    
    // Default Constructor
    public Skills() {
    }   
    
    // Getter and Setter
    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getAbilityDefinition() {
        return abilityDefinition;
    }

    public void setAbilityDefinition(String abilityDefinition) {
        this.abilityDefinition = abilityDefinition;
    }

    public String getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(String weaknesses) {
        this.weaknesses = weaknesses;
    }
    
    //toString equals and HashCode
    @Override
    public String toString() {
        return "Skills{" + "skillName=" + skillName + ", abilityDefinition=" + abilityDefinition + ", weaknesses=" + weaknesses + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.skillName);
        hash = 97 * hash + Objects.hashCode(this.abilityDefinition);
        hash = 97 * hash + Objects.hashCode(this.weaknesses);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Skills other = (Skills) obj;
        if (!Objects.equals(this.skillName, other.skillName)) {
            return false;
        }
        if (!Objects.equals(this.abilityDefinition, other.abilityDefinition)) {
            return false;
        }
        if (!Objects.equals(this.weaknesses, other.weaknesses)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
