public class Demo02 {
    public static void main(String[] args) {
        PlayService playService = new PlayService(new Decoder(), new Cache(), new UiDrawer());
        new Player(playService).play(new byte[] { 1, 2, 3, 4 });
    }
}
