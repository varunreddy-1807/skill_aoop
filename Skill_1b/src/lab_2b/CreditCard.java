package lab_2b;

public class CreditCard implements PaymentMethod {
 @Override
 public void pay(double amount) {
     System.out.println("Paid $" + amount + " using Credit Card.");
 }
}

