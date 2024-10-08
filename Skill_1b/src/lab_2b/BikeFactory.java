package lab_2b;

public class BikeFactory extends VehicleFactory {
 @Override
 public Vehicle createVehicle() {
     return new Bike();
 }
}

