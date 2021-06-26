package Util;

import GA.model.Chromosome;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
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

    public static ImageIcon getScaledImage(String path) {
        return new ImageIcon(Objects.requireNonNull(Utility.class.getResource(path)));
    }

    public static ImageIcon getScaledImage(String path, int w, int h) {

        ImageIcon image = getScaledImage(path);

        if(image.getIconHeight() != h && image.getIconWidth() != w)
            image.setImage(getScaledImage(image.getImage(), w, h));

        return image;
    }

    public static int random(int from, int to) {
        return (int) (Math.random() * (to  - from) + from);
    }

    public static <T> T choiceRandom(ArrayList<T> list) {

        if(list.isEmpty()) return null;

        int random = random(0, list.size());

        return list.get(random);
    }

    public static <T> T choiceRandom(Collection<T> list) {
        return choiceRandom(new ArrayList<>(list));
    }

    public static <T> T choiceRandom(T[] list) {

        if(list == null || list.length == 0) return null;

        int random = random(0, list.length);

        return list[random];

    }

    public static <K, V extends Comparable<V>>  Map.Entry<K, V> maxFromMap(Map<K, V> map) {

        Map.Entry<K, V> maxEntry = null;

        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue()
                    .compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        return maxEntry;
    }

    public static double clamp(double value, double min, double max) {
        if(value <= min) return min;
        if(value >= max) return max;
        return value;
    }
}
