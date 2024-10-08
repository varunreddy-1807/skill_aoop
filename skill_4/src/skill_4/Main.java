package skill_4;

public class Main {
    public static void main(String[] args) {
        Auction auction = new Auction("Vintage Clock");

        Bidder bidder1 = new ConcreteBidder("Alice");
        Bidder bidder2 = new ConcreteBidder("Bob");

        auction.registerBidder(bidder1);
        auction.registerBidder(bidder2);

        BidTemplate bidTemplate = new ConcreteBidTemplate();

        bidTemplate.bid(auction, 100, bidder1);
        bidTemplate.bid(auction, 150, bidder2);
        bidTemplate.bid(auction, 120, bidder1);
    }
}

