package software.ulpgc.imageviewer.presenter;

import software.ulpgc.imageviewer.interfaces.Image;
import software.ulpgc.imageviewer.interfaces.ImageDisplay;
import software.ulpgc.imageviewer.interfaces.Presenter;

public class ImagePresenter implements Presenter {
    private final ImageDisplay display;
    private Image image;

    public ImagePresenter(ImageDisplay display) {
        this.display = display;
        this.display.on((ImageDisplay.Shift) this::shift);
        this.display.on((ImageDisplay.Released) this::released);
    }

    private void shift(int offset) {
        display.clear();
        display.paint(image.id(), offset);
        if (offset > 0)
            display.paint(image.prev().id(), offset - display.getWidth());
        else
            display.paint(image.next().id(), display.getWidth() + offset);

    }

    @Override
    public void next(){
        show(image.next());
    }

    @Override
    public void prev(){
        show(image.prev());
    }

    private void released(int offset) {
        if (Math.abs(offset) >= display.getWidth() / 2)
            image = offset > 0 ? image.prev() : image.next();
        repaint();
    }

    public void show(Image image) {
        this.image = image;
        repaint();
    }


    private void repaint() {
        this.display.clear();
        this.display.paint(image.id(), 0);
    }
}
