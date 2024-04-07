package Classes;

import javax.swing.JFrame;

public class Program {

    public Program() {

        JFrame game_window = new JFrame();
        game_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game_window.setResizable(false);
        game_window.setTitle("insert title here");

        GamePanel game_panel = new GamePanel();
        game_window.add(game_panel);
        game_window.pack();

        game_window.setLocationRelativeTo(null);
        game_window.setVisible(true);

        game_panel.startGameThread();

        game_panel.requestFocusInWindow();
    }
}