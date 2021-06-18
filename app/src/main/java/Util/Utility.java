package Util;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Utility {

    public static Dimension stringDimensions(String s, Font font) {

        FontMetrics fontMetrics = new JLabel().getFontMetrics(font);
        return new Dimension(fontMetrics.stringWidth(s), fontMetrics.getHeight());

    }

    public static Image getScaledImage(Image image, int w, int h) {

        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public static ImageIcon getScaledImage(String path, int w, int h) {

        ImageIcon image = new ImageIcon(Objects.requireNonNull(Utility.class.getResource(path)));

        if(image.getIconHeight() != h && image.getIconWidth() != w)
            image.setImage(getScaledImage(image.getImage(), w, h));

        return image;
    }

}
