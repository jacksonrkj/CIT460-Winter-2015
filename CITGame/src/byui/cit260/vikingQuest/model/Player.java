package byui.cit260.vikingQuest.model;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author Amy Jennifer, Ivy
 */
public class Player implements Serializable{
    
    // Class Instance Variables
    private String name;
    private double highestScore;
    private double currentScore;
    
    // Default Constructor
    public Player() {
    }
    
    
    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(double highestScore) {
        this.highestScore = highestScore;
    }

    public double getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(double currentScore) {
        this.currentScore = currentScore;
    }
    
    // to string equals hashCode
    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", highestScore=" + highestScore + ", currentScore=" + currentScore + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.highestScore) ^ (Double.doubleToLongBits(this.highestScore) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.currentScore) ^ (Double.doubleToLongBits(this.currentScore) >>> 32));
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.highestScore) != Double.doubleToLongBits(other.highestScore)) {
            return false;
        }
        if (Double.doubleToLongBits(this.currentScore) != Double.doubleToLongBits(other.currentScore)) {
            return false;
        }
        return true;
    }
    
    
}
