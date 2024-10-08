package skill_4;

public class ConcreteBidTemplate extends BidTemplate {
    @Override
    protected boolean validateBid(double amount) {
        return amount > 0; 
    }

    @Override
    protected void afterBid() {
        System.out.println("Bid successfully placed.");
    }
}
