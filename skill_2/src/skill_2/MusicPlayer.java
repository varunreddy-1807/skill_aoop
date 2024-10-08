package skill_2;

public class MusicPlayer {
    private Playlist playlist;

    public MusicPlayer() {
        this.playlist = new Playlist();
    }

    public void addLocalFile(String filePath) {
        LocalFile localFile = new LocalFile(filePath);
        playlist.addSource(localFile);
    }

    public void addOnlineStream(String url) {
        OnlineStream onlineStream = new OnlineStream(url);
        playlist.addSource(onlineStream);
    }

    public void addRadioStation(String stationName) {
        RadioStation radioStation = new RadioStation(stationName);
        playlist.addSource(radioStation);
    }

    public void playMusic() {
        playlist.play();
    }
}
