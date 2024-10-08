package lab_2a;

public class Game {

 public static void main(String[] args) {
     GameState gameState = GameState.getInstance();
     
     gameState.setCurrentLevel(1);
     gameState.setDifficulty("Easy");

     EnemyFactory enemyFactory;
     ItemFactory itemFactory;
     
     if (gameState.getDifficulty().equals("Easy")) {
         enemyFactory = new EasyEnemyFactory();
         itemFactory = new EasyItemFactory();
     } 
      {
         enemyFactory = new HardEnemyFactory();
         itemFactory = new HardItemFactory();
     }

     Enemy enemy = enemyFactory.createEnemy();
     enemy.attack();

     Weapon weapon = itemFactory.createWeapon();
     PowerUp powerUp = itemFactory.createPowerUp();

     weapon.use();
     powerUp.apply();

     gameState.setCurrentLevel(2);
     gameState.setDifficulty("Hard");

     if (gameState.getDifficulty().equals("Easy")) {
         enemyFactory = new EasyEnemyFactory();
         itemFactory = new EasyItemFactory();
     } else {
         enemyFactory = new HardEnemyFactory();
         itemFactory = new HardItemFactory();
     }

     enemy = enemyFactory.createEnemy();
     enemy.attack();
     
     weapon = itemFactory.createWeapon();
     powerUp = itemFactory.createPowerUp();

     weapon.use();
     powerUp.apply();
 }
}

