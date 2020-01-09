package imageviewer;

/**
 *
 * @author Fabián B.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Image Viewer working...");
        FileImageLoader imageLoader = new FileImageLoader("Images");
        new MainFrame(imageLoader);
    }
}
