package imageviewer;

/**
 *
 * @author Fabián B.
 */

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import imageviewer.view.SwingImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;
    private ImageLoader loader;

    MainFrame(ImageLoader loader) {
        this.loader = loader;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        this.getContentPane().add(toolBar(), BorderLayout.SOUTH);
        this.setVisible(true);

        Image image = loader.next();
        this.setTitle(image.name());
        this.getImageDisplay().show(image);
    }

    private JPanel toolBar() {
        JPanel panel = new JPanel();

        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }

    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }

    private ActionListener prevImage() {
        return e -> {
            Image image = loader.prev();
            this.setTitle(image.name());
            this.getImageDisplay().show(image);
        };
    }

    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }

    private ActionListener nextImage() {
        return e -> {
            Image image = loader.next();
            this.setTitle(image.name());
            this.getImageDisplay().show(image);
        };
    }

    private JPanel imageDisplay() {
        SwingImageDisplay sid = new SwingImageDisplay();
        this.imageDisplay = sid;
        return sid;
    }

    ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
}