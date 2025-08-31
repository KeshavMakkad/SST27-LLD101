public class PlayService {
    private IDecoder decoder;
    private IStore store;
    private IUIDrawer uiDrawer;

    public PlayService(IDecoder decoder, IStore store, IUIDrawer uiDrawer) {
        this.decoder = decoder;
        this.store = store;
        this.uiDrawer = uiDrawer;
    }

    public void play(byte[] fileBytes) {
        Frame frame = decoder.decode(fileBytes);
        store.save(frame);
        uiDrawer.draw(fileBytes);
    }

}
