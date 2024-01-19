package software.ulpgc;

import software.ulpgc.imageviewer.interfaces.Image;
import software.ulpgc.imageviewer.mocks.MockImageLoader;
import software.ulpgc.imageviewer.view.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        ImagePresenter presenter = new ImagePresenter(frame.getImageDisplay());
        presenter.show(image());
        frame.setVisible(true);
    }

    private static Image image() {
        return new MockImageLoader().load();
    }
}
