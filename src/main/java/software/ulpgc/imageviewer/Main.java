package software.ulpgc.imageviewer;

import software.ulpgc.imageviewer.control.NextImageCommand;
import software.ulpgc.imageviewer.control.PreviousImageCommand;
import software.ulpgc.imageviewer.interfaces.Image;
import software.ulpgc.imageviewer.presenter.FixerImageLoader;
import software.ulpgc.imageviewer.presenter.ImagePresenter;
import software.ulpgc.imageviewer.view.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        ImagePresenter presenter = new ImagePresenter(frame.getImageDisplay());
        presenter.show(image());
        frame.setVisible(true);
        frame.add("<", new PreviousImageCommand(presenter));
        frame.add(">", new NextImageCommand(presenter));
    }

    private static Image image() {
        return new FixerImageLoader().load();
    }
}
