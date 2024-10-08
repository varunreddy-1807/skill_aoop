package lab_2b;

public class main {

 public static void main(String[] args) {
     UserAuth userAuth = UserAuth.getInstance();

     userAuth.authenticateUser("user", "pass");

     if (userAuth.isAuthenticated()) {
         VehicleFactory vehicleFactory;
         vehicleFactory = new CarFactory(); // Example: Creating a car
         Vehicle vehicle = vehicleFactory.createVehicle();
         vehicle.drive();

         PaymentFactory paymentFactory;
         paymentFactory = new CreditCardFactory(); // Example: Using credit card
         PaymentMethod paymentMethod = paymentFactory.createPaymentMethod();
         paymentMethod.pay(50.0);
     } else {
         System.out.println("Please authenticate first.");
     }

     
     userAuth.logout();
 }
}

