package lab_2a;


public class HardItemFactory implements ItemFactory {
 @Override
 public Weapon createWeapon() {
     return new Shield(); 
 }

 @Override
 public PowerUp createPowerUp() {
     return new SpeedBoost();
 }
}

