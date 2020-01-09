package imageviewer.model;

/**
 *
 * @author Fabián B.
 */

import java.io.*;

public class Image {

    private File file;

    public Image(File file) {
        this.file = file;
    }

    public String name() {
        return file.getName();
    }

    public InputStream stream() {
        try {
            return new BufferedInputStream(new FileInputStream(this.file));
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo. Exception: " + e );
            return null;
        }
    }
}