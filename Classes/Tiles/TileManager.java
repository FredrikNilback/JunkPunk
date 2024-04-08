package Classes.Tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.Arrays;

import Classes.GamePanel;
import Classes.Entities.Player;

public class TileManager {
    
    private GamePanel game_panel;
    private Tile[] tile;
    private int map_tile_num[][];
    private int map_tile_num_layer2[][];

    int map_size_x = 0;
    int map_size_y = 0;

    public TileManager(GamePanel game_panel, int map_num) {

        this.game_panel = game_panel;
        setTileImage();
        switch (map_num) {
            case 1:
                map_size_x = 64;
                map_size_y = 20;
                
                break;
        
            default:
                break;
        }

        map_tile_num = new int[map_size_x][map_size_y];
        map_tile_num_layer2 = new int[map_size_x][map_size_y];
        for (int i = 0; i < map_size_x; i++) {
            Arrays.fill(map_tile_num_layer2[i], 0);
        }
        loadMap(map_num);
        
    }



    public void draw(Graphics2D g2d) {

        int column = 0;
        int row = 0;
        while (column < map_size_x && row < map_size_y) {

            if(map_tile_num[column][row] != 0) {

                Player player = game_panel.getPlayer();

                int world_x = column * 32;
                int world_y = row * 32;
                int screen_x = world_x - player.getPosX() + player.getScreenX();
                int screen_y = world_y - player.getPosY() + player.getScreenY();

                if(world_x + 32 > player.getPosX() - player.getScreenX() && 
                   world_x - 32 < player.getPosX() + player.getScreenX() &&
                   world_y + 32 > player.getPosY() - player.getScreenY() &&  
                   world_y - 32 < player.getPosX() + player.getScreenY()) {

                        Image tile_image = tile[map_tile_num[column][row]].getImage();
                        g2d.drawImage(tile_image, screen_x, screen_y, 32, 32, null);
                    }
                
            }
            
            if(map_tile_num_layer2[column][row] != 0) {

                Player player = game_panel.getPlayer();

                int world_x = column * 32;
                int world_y = row * 32;
                int screen_x = world_x - player.getPosX() + player.getScreenX();
                int screen_y = world_y - player.getPosY() + player.getScreenY();

                if(world_x + 32 > player.getPosX() - player.getScreenX() && 
                   world_x - 32< player.getPosX() + player.getScreenX() &&
                   world_y + 32> player.getPosY() - player.getScreenY() && 
                   world_y - 32< player.getPosX() + player.getScreenY()) {

                        Image tile_image = tile[map_tile_num_layer2[column][row]].getImage();
                        g2d.drawImage(tile_image, screen_x, screen_y, 32, 32, null);
                    }
            }
            column++;

            if(column == map_size_x) {
                column = 0;
                row++;
            }
        }
    }

    private void loadMap(int map_num) {

        String path = ("/Maps/map" + map_num + ".txt");
        try {
            InputStream input_stream = getClass().getResourceAsStream(path);
            BufferedReader buffered_reader = new BufferedReader(new InputStreamReader(input_stream));

            int column = 0;
            int row = 0;

            while(column < map_size_x && row < map_size_y) {

                String line = buffered_reader.readLine();
                while (column < map_size_x) {

                    String string_numbers[] = line.split("\\s+");
                    int number;
                    try {
                        number = Integer.parseInt(string_numbers[column]);
                        map_tile_num[column][row] = number;
                    }
                    catch (Exception e) {
                        switch (string_numbers[column]) {
                            case "TO1":
                                treeMaker("Oak", "Small", column, row);
                                break;
            
                            default:
                                break;
                        }
                    }
                    
                    column++;
                }

                column = 0;
                row++;
            }
            buffered_reader.close();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void setTileImage() {
        
        int[] tiles_with_collision_index = new int[] {
            1, 28, 29
        };

        ImageIcon[] tile_icons = new ImageIcon[] {

            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/air.png")),
            
            new ImageIcon(getClass().getResource("/Images/Tiles/Collision/Static/standard_grass.png")),

            //start of oak tree
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/trunk.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/trunk_base.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/root_left.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/root_right.png")),                  //5
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/branch_left1.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/branch_left2.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/branch_right1.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/branch_right2.png")),          
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_left2_top.png")),             //10
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_left1_top.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_center_top.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_right1_top.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_right2_top.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_left2_center.png")),          //15
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_left1_center_up.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_center_center_up.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_right1_center_up.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_right2_center.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_left2_bottom.png")),          //20
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_left1_center_down.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_center_center_down.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_right1_center_down.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_right2_bottom.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_left1_bottom.png")),          //25
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_center_bottom.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/Tree/Oak/crown_right1_bottom.png")),
            //end of oak tree

            new ImageIcon(getClass().getResource("/Images/Tiles/Collision/Static/dirt_layer1.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/Collision/Static/dirt_layer2.png"))
        };

        tile = new Tile[tile_icons.length];
        for (int i = 0; i < tile.length; i++) {
            tile[i] = new Tile();
            tile[i].setImage(toBufferedImage(tile_icons[i].getImage()));
        }

        for (int collision_int : tiles_with_collision_index) {
            tile[collision_int].setCollisionTrue();
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

    private void treeMaker(String type, String size, int column, int row) {

        switch (size) {
            case "Small":
                map_tile_num[column][row] = 3;
                map_tile_num_layer2[column - 1][row] = 4;
                map_tile_num_layer2[column + 1][row] = 5;

                for(int i = 1; i < 7; i++) {
                    if(row - i >= 0) {
                        map_tile_num[column][row - i] = 2;
                        if(i == 4) {
                            map_tile_num_layer2[column - 1][row - i] = 6;
                            map_tile_num_layer2[column - 2][row - i] = 7;
                        }
                        else if(i == 5) {
                            map_tile_num_layer2[column + 1][row - i] = 8;
                            map_tile_num_layer2[column + 2][row - i] = 9;
                        }
                    }
                    else {
                        break;
                    }
                }

                if(row - 10 >= 0) {
                    int crown_int = 10; 
                    if(column - 2 >= 0 && column + 2 <= map_size_x) {
                        for (int r = 10; r > 6; r--) {
                            for (int c = 2; c > -3; c--) {
                                if(r == 7 && (c == 2 || c == -2)) {
                                    continue;
                                }
                                if(crown_int <= 15 || (crown_int > 18 && crown_int <= 20) ||
                                   (crown_int > 23 && crown_int <= 25) || crown_int == 27) {
                                    map_tile_num_layer2[column - c][row - r] = crown_int;
                                }
                                else {
                                    map_tile_num[column - c][row - r] = crown_int;
                                }
                                
                                crown_int++;
                            }
                        }
                    }
                    
                } 
        
            default:
                break;
        }
        
    }
}
