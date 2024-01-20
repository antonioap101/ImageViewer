package software.ulpgc.imageviewer.control;

import software.ulpgc.imageviewer.interfaces.Command;
import software.ulpgc.imageviewer.presenter.ImagePresenter;

public class PreviousImageCommand implements Command {
    private final ImagePresenter imagePresenter;

    public PreviousImageCommand(ImagePresenter imagePresenter) {
        this.imagePresenter = imagePresenter;
    }

    @Override
    public void execute() {
        imagePresenter.prev();
    }
}
