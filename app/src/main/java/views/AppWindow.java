package views;

import model.ContextNode;

import javax.swing.*;
import java.awt.*;

public abstract class AppWindow extends JFrame {

    protected ContextNode contextNode;
    private final JLayeredPane layeredPane;

    public AppWindow(ContextNode contextNode, String title, Dimension dimension) {
        super(title);
        this.contextNode = contextNode;
        setSize(dimension);
        setLocationRelativeTo(null); // center window
        setLayout(null);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, dimension.width, dimension.height);
        getContentPane().add(layeredPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        initComponents();
    }

    /**
     * all the components of the window shall be initialized here
     * */
    public abstract void initComponents();

    protected void addComponent(Component component, int layer) {
        layeredPane.add(component, 0, layer); // constraints = BorderLayout.NORTH, BorderLayout.SOUTH etc...
    }

    public void showWindow() {
        setVisible(true);
    }

    public void setBackgroundColor(Color color) {
        layeredPane.setBackground(color);
        layeredPane.setOpaque(true);
    }

}
