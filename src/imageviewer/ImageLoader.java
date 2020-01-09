package imageviewer;

/**
 *
 * @author Fabián B.
 */

import imageviewer.model.Image;

public interface ImageLoader {

    Image next();

    Image prev();
}