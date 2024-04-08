package Classes.Entities;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

import Classes.GamePanel;
import Classes.KeyHandler;


public class Player extends Entity {

    private int player_width = 64;
    private int player_heigt = 128;

    private GamePanel game_panel;
    private KeyHandler key_handler;

    public Player(int player_x_start, int player_y_start, String gender, GamePanel game_panel, KeyHandler key_handler) {

        speed = 5;
        pos_x = player_x_start;
        pos_y = player_y_start;
        getPlayerImage(gender);

        this.game_panel = game_panel;
        this.key_handler = key_handler;
        setDirection("facing");
    }


    public void update() {

        if(key_handler.right == true || key_handler.left == true) {
            if(key_handler.left == true) {

                setDirection("left");
                pos_x -= speed;
                if(getRunDuration() > 12) {
                    mmRunDuration();
                }
            }

            if(key_handler.right == true) {

                setDirection("right");
                pos_x += speed;
                if(getRunDuration() > 12) {
                    mmRunDuration();
                }
            } 
    
            ppSpriteCounter();
            if(getSpriteCounter() > 12) {

                ppSpriteNum();
                if(getSpriteNum() > 6) {
                    resetSpriteNum();
                }
                resetSpriteCounter();
            }
        }

        if(!key_handler.right && !key_handler.left) {
            setDirection("facing");
            ppSpriteCounter();
            if(getSpriteCounter() > getRunDuration()) {
                ppSpriteNum();

                if(getSpriteNum() > 2) {
                    resetSpriteNum();
                }

                resetSpriteCounter();

                if(getRunDuration() < 64) {
                    ppRunDuration();

                    if(getRunDuration()> 32 && getRunDuration() < 64) {
                        ppRunDuration();
                    }
                } 
            }
        }
        

        if(key_handler.up == true) {
            setDirection("facing");
        }
        
        if(key_handler.down == true) {
            
        }

        
    }

    public void draw(Graphics2D g2d) {
        BufferedImage image = null;

        switch (getDirection()) {
            case "facing":
                image = getFacing();
                break;

            case "left":
                image = getLeft();
                break;

            case "right":
                image = getRight();
                break;

            default:
                break;
        }

        g2d.drawImage(image, pos_x, pos_y, player_width, player_heigt, null);
    }

    
    
    //getters & setters

    public void getPlayerImage(String gender) {

        String path = ("/Images/MainCharacter/" + gender + "/" + gender.toLowerCase() + "_");
        try {
            ImageIcon base_model_Icon = new ImageIcon(getClass().getResource(path + "base_model.png"));

            ImageIcon facing1_icon = new ImageIcon(getClass().getResource(path + "facing_1.png"));
            ImageIcon facing2_icon = new ImageIcon(getClass().getResource(path + "facing_2.png"));

            ImageIcon left1_icon = new ImageIcon(getClass().getResource(path + "running_left_1.png"));
            ImageIcon left2_icon = new ImageIcon(getClass().getResource(path + "running_left_2.png"));
            ImageIcon left3_icon = new ImageIcon(getClass().getResource(path + "running_left_3.png"));
            ImageIcon left4_icon = new ImageIcon(getClass().getResource(path + "running_left_4.png"));
            ImageIcon left5_icon = new ImageIcon(getClass().getResource(path + "running_left_5.png"));
            ImageIcon left6_icon = new ImageIcon(getClass().getResource(path + "running_left_6.png"));


            ImageIcon right1_icon = new ImageIcon(getClass().getResource(path + "running_right_1.png"));
            ImageIcon right2_icon = new ImageIcon(getClass().getResource(path + "running_right_2.png"));
            ImageIcon right3_icon = new ImageIcon(getClass().getResource(path + "running_right_3.png"));
            ImageIcon right4_icon = new ImageIcon(getClass().getResource(path + "running_right_4.png"));
            ImageIcon right5_icon = new ImageIcon(getClass().getResource(path + "running_right_5.png"));
            ImageIcon right6_icon = new ImageIcon(getClass().getResource(path + "running_right_6.png"));

            setBaseModel(toBufferedImage(base_model_Icon.getImage()));


            BufferedImage[] facing = new BufferedImage[] {
                toBufferedImage(facing1_icon.getImage()),
                toBufferedImage(facing2_icon.getImage())
            };
            setFacing(facing);

            BufferedImage[] right = new BufferedImage[] {
                toBufferedImage(right1_icon.getImage()),
                toBufferedImage(right2_icon.getImage()),
                toBufferedImage(right3_icon.getImage()),
                toBufferedImage(right4_icon.getImage()),
                toBufferedImage(right5_icon.getImage()),
                toBufferedImage(right6_icon.getImage())
            };
            setRight(right);
            
            BufferedImage[] left = new BufferedImage[] {
                toBufferedImage(left1_icon.getImage()),
                toBufferedImage(left2_icon.getImage()),
                toBufferedImage(left3_icon.getImage()),
                toBufferedImage(left4_icon.getImage()),
                toBufferedImage(left5_icon.getImage()),
                toBufferedImage(left6_icon.getImage())
            };
            setLeft(left);
            
            
        } 
        catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    public int getPosX() {
        return pos_x;
    }
    public void setPosX(int player_x) {
        this.pos_x = player_x;
    }

    public int getPlayerY() {
        return pos_y;
    }
    public void setPlayerY(int player_y) {
        this.pos_y = player_y;
    }

}
