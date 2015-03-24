/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.vikingQuest.model;

import byui.cit260.vikingQuest.control.GameControl;
import byui.cit260.vikingQuest.control.createInventoryList;
import java.io.Serializable;

/**
 *
 * @author Amy
 */
public class Game implements Serializable {

    public static void createNewGame(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Class instance variables
    private double totalTime;
    private double bestTime;
    private Player player;
    private InventoryItem[] items;
    private String[] characters;
    private Backpack backpack;
    private Map map;
    
    public Game() {
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getBestTime() {
        return bestTime;
    }

    public void setBestTime(double bestTime) {
        this.bestTime = bestTime;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public InventoryItem[] getItems() {
        return items;
    }

    public void setItems(InventoryItem[] items) {
        this.items = items;
    }

    public String[] getCharacters() {
        return characters;
    }

    public void setCharacters(String[] characters) {
        this.characters = characters;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    

}
