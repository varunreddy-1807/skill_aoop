package lab_2a;


public class GameState {

 private static GameState instance;

 private int currentLevel;
 private String difficulty;

 private GameState() {
     this.currentLevel = 1; 
     this.difficulty = "Easy"; 
 }

 public static synchronized GameState getInstance() {
     if (instance == null) {
         instance = new GameState();
     }
     return instance;
 }

 public int getCurrentLevel() {
     return currentLevel;
 }

 public void setCurrentLevel(int currentLevel) {
     this.currentLevel = currentLevel;
 }

 public String getDifficulty() {
     return difficulty;
 }

 public void setDifficulty(String difficulty) {
     this.difficulty = difficulty;
 }
}
