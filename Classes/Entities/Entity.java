package Classes.Entities;

import java.awt.image.BufferedImage;

public class Entity {
    private int pos_x;
    private int pos_y;
    private int speed;

    public BufferedImage base_model, facing1, facing2, left1, left2, left3, left4, left5, left6, right1, right2, right3, right4, right5, right6;
    public String direction;

    public int sprite_counter = 0;
    public int sprite_num = 1;
    public int run_duration = 64;
}
