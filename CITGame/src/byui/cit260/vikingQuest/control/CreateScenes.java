/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.vikingQuest.control;

import byui.cit260.vikingQuest.model.Game;
import byui.cit260.vikingQuest.model.Location;
import byui.cit260.vikingQuest.model.Map;
import byui.cit260.vikingQuest.model.Scene;
import vikingquest.VikingQuest;

/**
 *
 * @author Amy
 */
public class CreateScenes {
    private static Object Scene;
    private static Scene startScene;
    private static Scene finishScene;
    private static Scene startingScene;
    
    public static Scene[] createScenes() throws MapControlException{
        BufferedImage image = null;
        
        Game game = VikingQuest.getCurrentGame();
        
        Scene[] scenes = new Scene[SceneType.values().length];
        
        // Scene startingScene = new Scene(); Cant correct error
        startingScene.setType(
                "\n Your journey begins here. A ship has just dropped "
                        + "you off on an Island that, you believe, hides"
                        + "an ancient Viking treasure. This beach may contain"
                        + "some items to help you along your way."
                        + "\n Be sure to have a look around before continuing on"
                        + "to the small town ahead to gather supplies");
        startingScene.setMapSymbol(" ST ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
      
        scenes[SceneType.start.ordinal()] = startingScene;

        //Scene finishScene = new Scene();  Can't correct error
        finishingScene.setDescription(
                "\n Congratulations! You have accomplished what many have "
                        + " failed to achieve. The treasure is your reward!"
                        + " may you use it wisely!");
        finishingScene.setMapSymbol( "FN" );
        finishingScene.setBlocked(false);
        finishingScene.setTravelTime(Double.POSITIVE_INFINITY);

        scenes[SceneType.finish.ordinal()] = finishScene;    
        
        return null;
    }
    
    public enum SceneType {
        start,
        jungle,
        mountains,
        mountainPass,
        ruins,
        temple,
        ship,
        beach, 
        shop,
        town,
        finish;
    }
    
    CreateScenes(){
        
    }
    private static void assignScenesToLocations(Map map, Scene[] scenes){
        Location[][] locations = map.getLocations();
        
        // start point
        locations[0][0].setScene(scenes[SceneType.beach.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.finish.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.mountainPass.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.mountains.ordinal()]);
        locations[0][5].setScene(scenes[SceneType.ruins.ordinal()]);
        locations[0][6].setScene(scenes[SceneType.ship.ordinal()]);
        locations[0][7].setScene(scenes[SceneType.shop.ordinal()]);
        locations[0][8].setScene(scenes[SceneType.start.ordinal()]);
        locations[0][9].setScene(scenes[SceneType.temple.ordinal()]);
        locations[0][10].setScene(scenes[SceneType.town.ordinal()]);
    }
    
    private static void startingScenesetDescription(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class MapControlException extends Exception {

        public MapControlException() {
        }
    }

    private static class startingScene {

        private static void setMapSymbol(String _st_) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void setBlocked(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void setTravelTime(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void setIcon(ImageIcon startingSceneImage) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void setDescription(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void setType(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public startingScene() {
        }
    }
    
    private static class finishingScene {

        private static void setMapSymbol(String _st_) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void setBlocked(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void setTravelTime(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void setIcon(ImageIcon finishSceneImage) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void setDescription(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void setTravelTime(double POSITIVE_INFINITY) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    public static class ImageIcon {

    }

    private static class BufferedImage {

        public BufferedImage() {
        }
    }
    
}

