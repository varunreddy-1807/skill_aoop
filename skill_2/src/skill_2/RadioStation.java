package skill_2;

public class RadioStation implements MusicSource {
    private String stationName;

    public RadioStation(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public void play() {
        System.out.println("Playing radio station: " + stationName);
    }
}

