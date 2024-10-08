package lab_2a;


public class EasyItemFactory implements ItemFactory {
 @Override
 public Weapon createWeapon() {
     return new Sword(); 
 }

 @Override
 public PowerUp createPowerUp() {
     return new HealthBoost(); 
 }
}
