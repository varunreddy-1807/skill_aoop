package skill_4;

public class AuctionEvent {
    private String item;
    private double bidAmount;
    private Bidder bidder;

    public AuctionEvent(String item, double bidAmount, Bidder bidder) {
        this.item = item;
        this.bidAmount = bidAmount;
        this.bidder = bidder;
    }

    public String getItem() {
        return item;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public Bidder getBidder() {
        return bidder;
    }
}
