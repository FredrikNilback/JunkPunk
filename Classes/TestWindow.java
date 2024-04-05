package Classes;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Classes.Entities.*;

public class TestWindow {
    
    public TestWindow() {
        
        // Create a JFrame
        JFrame frame = new JFrame("Test Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400); // Set the size of the frame

        // Create a JPanel
        JPanel panel = new JPanel();

        // Create a Player instance
        Player player = new Player(100, 100, true, new GamePanel(), new KeyHandler());

        // Create a JLabel to display the player image
        //JLabel label = new JLabel(new ImageIcon(player.getPlayerImage()));

        // Add the label to the panel
        //panel.add(label);

        // Add the panel to the frame
        frame.add(panel);

        // Set the frame visible
        frame.setVisible(true);
    }
}
