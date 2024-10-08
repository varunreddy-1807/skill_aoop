package lab_2b;

public class PayPal implements PaymentMethod {
 @Override
 public void pay(double amount) {
     System.out.println("Paid $" + amount + " using PayPal.");
 }
}

