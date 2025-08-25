public class Player {
    private PlayService playService;

    public Player(PlayService playService) {
        this.playService = playService;
    }

    public void play(byte[] fileBytes) {
        playService.play(fileBytes);
    }
}