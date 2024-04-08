package Classes.Tiles;

import java.awt.image.BufferedImage;

public class Tile {
    
    private BufferedImage image;
    private boolean collision = false;



    //getters & setters

    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public boolean getCollision() {
        return collision;
    }
    public void setCollisionTrue() {
        this.collision = true;
    }
}
