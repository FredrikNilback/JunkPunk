package Classes.Entities;

import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Graphics2D;

public class Entity {
    private int pos_x;
    private int pos_y;
    private int speed;

    private BufferedImage base_model, facing1, facing2, left1, left2, left3, left4, left5, left6, right1, right2, right3, right4, right5, right6;
    private BufferedImage[] facing = new BufferedImage[] {facing1, facing2};
    private BufferedImage[] left = new BufferedImage[] {left1, left2, left3, left4, left5, left6};
    private BufferedImage[] right = new BufferedImage[] {right1, right2, right3, right4, right5, right6};
    private String direction;

    private int sprite_counter = 0;
    private int sprite_num = 1;
    private int run_duration = 64;


    protected BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
    
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
    
        return bimage;
    }

    //getters & setters

    public BufferedImage getBaseModel() {
        return base_model;
    }
    public void setBaseModel(BufferedImage base_model) {
        this.base_model = base_model;
    }

    public BufferedImage getFacing() {
        if(sprite_num > 2) {
            sprite_num = 1;
        }
        return facing[sprite_num - 1];
    } 

    public void setFacing(BufferedImage[] image) {
        for (int i = 0; i < image.length; i++) {
            facing[i] = image[i];
        }
    }

    public BufferedImage getLeft() {
        if(sprite_num > 6) {
            sprite_num = 1;
        }
        return left[sprite_num - 1];
    } 

    public void setLeft(BufferedImage[] image) {
        for (int i = 0; i < image.length; i++) {
            left[i] = image[i];
        }
    }

    public BufferedImage getRight() {
        if(sprite_num > 6) {
            sprite_num = 1;
        }
        return right[sprite_num - 1];
    } 

    public void setRight(BufferedImage[] image) {
        for (int i = 0; i < image.length; i++) {
            right[i] = image[i];
        }
    }

    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getSpriteCounter() {
        return sprite_counter;
    }
    public void ppSpriteCounter() {
        sprite_counter++;
    }
    public void resetSpriteCounter() {
        sprite_counter = 0;
    }

    public int getSpriteNum() {
        return sprite_num;
    }
    public void ppSpriteNum() {
        sprite_num++;
    }
    public void resetSpriteNum() {
        sprite_num = 1;
    }


    public int getRunDuration() {
        return run_duration;
    }
    public void ppRunDuration() {
        run_duration++;
    }
    public void mmRunDuration() {
        run_duration--;
    }
}
