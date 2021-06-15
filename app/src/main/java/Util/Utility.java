package Util;

import javax.swing.*;
import java.awt.*;

public class Utility {

    public static Dimension stringDimensions(String s, Font font) {
        FontMetrics fontMetrics = new JLabel().getFontMetrics(font);
        return new Dimension(fontMetrics.stringWidth(s), fontMetrics.getHeight());
    }

}
