package gh2;

public class Music {
    public static void main(String[] args) {
        GuitarPlayer player = new GuitarPlayer(new java.io.File("we don't talk anymore.mid"));
        player.play();
    }
}
