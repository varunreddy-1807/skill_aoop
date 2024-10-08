package skill_2;

public class OnlineStream implements MusicSource {
    private String url;

    public OnlineStream(String url) {
        this.url = url;
    }

    @Override
    public void play() {
        System.out.println("Streaming online from: " + url);
    }
}
