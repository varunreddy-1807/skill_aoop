package lab_2b;

public class PayPalFactory implements PaymentFactory {
 @Override
 public PaymentMethod createPaymentMethod() {
     return new PayPal();
 }
}
