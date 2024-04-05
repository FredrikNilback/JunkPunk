package Classes.Entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

import Classes.GamePanel;
import Classes.KeyHandler;


public class Player extends Entity {
    private int player_x;
    private int player_y;

    private int player_width = 32;
    private int player_heigt = 64;

    private int player_speed = 5;

    private Image player_image;

    GamePanel game_panel;
    KeyHandler key_handler;

    public Player(int player_x_start, int player_y_start, boolean gender, GamePanel game_panel, KeyHandler key_handler) {
        player_x = player_x_start;
        player_y = player_y_start;
        if(gender) {
            getPlayerImageFemale();
        }
        else {
            //getPlayerImageMale();
        }

        this.game_panel = game_panel;
        this.key_handler = key_handler;
        this.direction = "facing";
    }


    public void update() {

        if(key_handler.right == true || key_handler.left == true) {
            if(key_handler.left == true) {
                direction = "left";
                setPlayerX(player_x - player_speed);
                if(run_duration > 12) {
                    run_duration--;
                }
            }

            if(key_handler.right == true) {
                direction = "right";
                setPlayerX(player_x + player_speed);
                if(run_duration > 12) {
                    run_duration--;
                }
            } 
    
            sprite_counter++;
            if(sprite_counter > 12) {
                sprite_num++;
                if(sprite_num > 6) {
                    sprite_num = 1;
                }
                sprite_counter = 0;
            }
        }

        if(!key_handler.right && !key_handler.left) {
            direction = "facing";
            sprite_counter++;
            if(sprite_counter > run_duration) {
                sprite_num++;

                if(sprite_num > 2) {
                    sprite_num = 1;
                }

                sprite_counter = 0;

                if(run_duration < 64) {
                    run_duration++;

                    if(run_duration > 32 && run_duration < 64) {
                        run_duration++;
                    }
                } 
            }
        }
        

        if(key_handler.up == true) {
            direction = "facing";
        }
        
        if(key_handler.down == true) {
            
        }

        
    }

    public void draw(Graphics2D g2d) {
        BufferedImage image = null;

        switch (direction) {
            case "facing":
                image = facing1;
                if(sprite_num == 1) {
                    image = facing1;
                }
                if(sprite_num == 2) {
                    image = facing2;
                    }
                break;

            case "left":

                switch(sprite_num) {
                    case 1:
                        image = left1;
                        break;
                    case 2:
                        image = left2;
                        break;
                    case 3:
                        image = left3;
                        break;
                    case 4:
                        image = left4;
                        break;
                    case 5: 
                        image = left5;
                        break;
                    case 6:
                        image = left6;
                        break;
                    default:
                        break;
                }
                
                break;

            case "right":

                switch(sprite_num) {
                    case 1:
                        image = right1;
                        break;
                    case 2:
                        image = right2;
                        break;
                    case 3:
                        image = right3;
                        break;
                    case 4:
                        image = right4;
                        break;
                    case 5: 
                        image = right5;
                        break;
                    case 6:
                        image = right6;
                        break;
                    default:
                        break;
                }

                break;

            default:
                break;
        }

        g2d.drawImage(image, player_x, player_y, game_panel.getTrue_tile_size(), game_panel.getTrue_tile_size(), null);
    }

    
    
    //getters & setters

    public int getPlayerX() {
        return player_x;
    }
    public void setPlayerX(int player_x) {
        this.player_x = player_x;
    }

    public int getPlayerY() {
        return player_y;
    }
    public void setPlayerY(int player_y) {
        this.player_y = player_y;
    }

    public int getPlayerSpeed() {
        return player_speed;
    }

    public void getPlayerImageFemale() {

        try {
            ImageIcon base_model_Icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_base_model.png"));

            ImageIcon facing1_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_facing_1.png"));
            ImageIcon facing2_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_facing_2.png"));

            ImageIcon left1_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_running_left_1.png"));
            ImageIcon left2_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_running_left_2.png"));
            ImageIcon left3_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_running_left_3.png"));
            ImageIcon left4_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_running_left_4.png"));
            ImageIcon left5_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_running_left_5.png"));
            ImageIcon left6_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_running_left_6.png"));


            ImageIcon right1_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_running_right_1.png"));
            ImageIcon right2_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_running_right_2.png"));
            ImageIcon right3_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_running_right_3.png"));
            ImageIcon right4_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_running_right_4.png"));
            ImageIcon right5_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_running_right_5.png"));
            ImageIcon right6_icon = new ImageIcon(getClass().getResource("/Images/MainCharacter/Female/female_running_right_6.png"));

            base_model = toBufferedImage(base_model_Icon.getImage());
    
            facing1 = toBufferedImage(facing1_icon.getImage());
            facing2 = toBufferedImage(facing2_icon.getImage());

            right1 = toBufferedImage(right1_icon.getImage());
            right2 = toBufferedImage(right2_icon.getImage());
            right3 = toBufferedImage(right3_icon.getImage());
            right4 = toBufferedImage(right4_icon.getImage());
            right5 = toBufferedImage(right5_icon.getImage());
            right6 = toBufferedImage(right6_icon.getImage());
            
            left1 = toBufferedImage(left1_icon.getImage());
            left2 = toBufferedImage(left2_icon.getImage());
            left3 = toBufferedImage(left3_icon.getImage());
            left4 = toBufferedImage(left4_icon.getImage());
            left5 = toBufferedImage(left5_icon.getImage());
            left6 = toBufferedImage(left6_icon.getImage());
            
        } 
        catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    private BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
    
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
    
        return bimage;
    }
}
