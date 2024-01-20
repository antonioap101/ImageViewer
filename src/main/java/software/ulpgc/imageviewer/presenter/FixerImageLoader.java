package software.ulpgc.imageviewer.presenter;

import software.ulpgc.imageviewer.interfaces.Image;
import software.ulpgc.imageviewer.interfaces.ImageLoader;

public class FixerImageLoader implements ImageLoader {
    private final String[] imageFileNames = new String[]{
            "/torrente1.jpg", "/torrente2.jpg", "/torrente3.jpg",
            "/torrente4.jpg", "/torrente5.jpg"
    };

    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
        return new Image() {
            @Override
            public String id() {
                return String.valueOf(imageFileNames[i]);
            }

            @Override
            public Image next() {
                return imageAt((i + 1) % imageFileNames.length);
            }

            @Override
            public Image prev() {
                return imageAt(i > 0 ? i - 1 : imageFileNames.length - 1);
            }
        };
    }
}



