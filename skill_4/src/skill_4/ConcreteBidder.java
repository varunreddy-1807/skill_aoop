package skill_4;

public class ConcreteBidder implements Bidder {
    private String name;

    public ConcreteBidder(String name) {
        this.name = name;
    }

    @Override
    public void update(AuctionEvent event) {
        System.out.println(name + " notified: New highest bid of " + event.getBidAmount() + " on item " + event.getItem());
    }
}
