package imageviewer;

/**
 *
 * @author Fabián B.
 */

import imageviewer.model.Image;

import java.io.*;

public class FileImageLoader implements ImageLoader {
    private final File[] files;
    private final static String[] imageExtensions = new String[]{"jpg", "png", "jpeg"};
    private int i = -1;

    public FileImageLoader(String folder) {
        this.files = new File(folder).listFiles(withImageExtension());
    }

    @Override
    public Image next() {
        i++;
        if (i == files.length) {
            i = 0;
        }
        return new Image(files[i]);
    }

    @Override
    public Image prev() {
        i--;
        if (i < 0) {
            i = files.length - 1;
        }
        return new Image(files[i]);
    }

    private FilenameFilter withImageExtension() {

        return (dir, name) -> {
            for (String extension : imageExtensions) {
                if (name.endsWith(extension)) return true;
            }
            return false;
        };
    }
}