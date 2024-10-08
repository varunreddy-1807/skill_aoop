package lab_2b;

public class CreditCardFactory implements PaymentFactory {
 @Override
 public PaymentMethod createPaymentMethod() {
     return new CreditCard();
 }
}
