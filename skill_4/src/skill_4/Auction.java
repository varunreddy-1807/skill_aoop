package skill_4;

import java.util.ArrayList;
import java.util.List;

public class Auction {
    private List<Bidder> bidders = new ArrayList<>();
    private String item;
    private double highestBid;

    public Auction(String item) {
        this.item = item;
        this.highestBid = 0;
    }

    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    public void unregisterBidder(Bidder bidder) {
        bidders.remove(bidder);
    }

    public void placeBid(double bidAmount, Bidder bidder) {
        if (bidAmount > highestBid) {
            highestBid = bidAmount;
            notifyBidders(new AuctionEvent(item, bidAmount, bidder));
        } else {
            System.out.println("Bid of " + bidAmount + " is too low.");
        }
    }

    private void notifyBidders(AuctionEvent event) {
        for (Bidder bidder : bidders) {
            bidder.update(event);
        }
    }
}

