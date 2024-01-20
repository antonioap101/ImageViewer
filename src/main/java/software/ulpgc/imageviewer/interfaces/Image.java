package software.ulpgc.imageviewer.interfaces;

public interface Image {
    String id();
    Image next();
    Image prev();

}
