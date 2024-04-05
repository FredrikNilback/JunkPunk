package Classes;

import javax.swing.JPanel;

import Classes.Entities.Player;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {
    
    final int tile_size = 32;
    final int scale = 2;
    final int true_tile_size = tile_size * scale;
    final int screen_columns = 28;
    final int screen_rows = 16;
    final int screen_width = true_tile_size * screen_columns;
    final int screen_height = true_tile_size * screen_rows;

    private Player player;
    private int frames_per_second = 60;

    KeyHandler key_handler = new KeyHandler();
    Thread thread;

    int player_speed;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screen_width, screen_height));
        this.setDoubleBuffered(true);
        this.addKeyListener(key_handler);
        this.setFocusable(true);

        player = new Player(100, 100, true, this, this.key_handler); // change to load from elsewhere later

    }

    public void startGameThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        double draw_interval = 1000000000 / frames_per_second;
        double delta = 0;
        long last_time = System.nanoTime();
        long current_time;
        long timer = 0;
        int draw_count = 0;

        while(thread != null) {

            current_time = System.nanoTime();
            delta += (current_time - last_time) / draw_interval;
            timer += current_time - last_time;
            last_time = current_time;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                draw_count++;
            }
            if(timer >= 1000000000) {
                System.out.println("FPS: " + draw_count);
                draw_count = 0;
                timer = 0;
            }

        }
    }

    public void update() {
        
        player.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        player.draw(g2d);

    }

    //getters & setters

    public int getTrue_tile_size() {
        return true_tile_size;
    }

}
