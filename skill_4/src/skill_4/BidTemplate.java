package skill_4;

public abstract class BidTemplate {
    public final void bid(Auction auction, double amount, Bidder bidder) {
        if (validateBid(amount)) {
            auction.placeBid(amount, bidder);
            afterBid();
        } else {
            System.out.println("Bid of " + amount + " is invalid.");
        }
    }

    protected abstract boolean validateBid(double amount);
    protected abstract void afterBid();
}

