package skill_2;

public class LocalFile implements MusicSource {
    private String filePath;

    public LocalFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void play() {
        System.out.println("Playing local file: " + filePath);
    }
}
