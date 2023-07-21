package lab1.ques5;


import javax.swing.*;
import java.awt.*;

public class Fonts {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] fontFamilies = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        JPanel panel = new JPanel(new GridLayout(fontFamilies.length, 1));
        for (String fontFamily : fontFamilies) {
            JLabel label = new JLabel(fontFamily);
            panel.add(label);
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}

