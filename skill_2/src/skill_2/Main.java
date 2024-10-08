package skill_2;

public class Main {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        
        // Adding different sources
        musicPlayer.addLocalFile("song1.mp3");
        musicPlayer.addOnlineStream("http://streaming.example.com/song");
        musicPlayer.addRadioStation("Cool FM");

        // Playing music
        musicPlayer.playMusic();
    }
}
