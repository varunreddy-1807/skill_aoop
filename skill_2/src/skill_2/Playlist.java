package skill_2;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements MusicSource {
    private List<MusicSource> sources;

    public Playlist() {
        sources = new ArrayList<>();
    }

    public void addSource(MusicSource source) {
        sources.add(source);
    }

    @Override
    public void play() {
        for (MusicSource source : sources) {
            source.play();
        }
    }
}
