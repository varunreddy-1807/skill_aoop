package lab_2a;


public class EasyEnemyFactory extends EnemyFactory {
 @Override
 public Enemy createEnemy() {
     return new Zombie(); 
 }
}

