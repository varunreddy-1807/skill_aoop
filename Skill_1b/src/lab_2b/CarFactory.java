package lab_2b;

public class CarFactory extends VehicleFactory {
 @Override
 public Vehicle createVehicle() {
     return new Car();
 }
}
