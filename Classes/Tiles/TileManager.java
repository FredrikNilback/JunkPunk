package Classes.Tiles;

import Classes.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Image;
import javax.swing.ImageIcon;

public class TileManager {
    
    private GamePanel game_panel;
    private Tile[] tile;
    private int map_tile_num[][];

    public TileManager(GamePanel game_panel) {

        this.game_panel = game_panel;
        tile = new Tile[2];
        setTileImage();
    }



    public void draw(Graphics2D g2d, int map_num) {

        int map_size_x = 0;
        int map_size_y = 0;
        switch (map_num) {
            case 1:
                map_size_x = 20;
                map_size_y = 20;
                break;
        
            default:
                break;
        }
        map_tile_num = new int[map_size_x][map_size_y];

        loadMap(map_num, map_size_x, map_size_y);

        int column = 0;
        int row = 0;
        while (column < map_size_x && row < map_size_y) {

            Image tile_image = tile[map_tile_num[column][row]].getImage();
            
            g2d.drawImage(tile_image, column * 32, row * 32, 32, 32, null);
            column++;

            if(column == map_size_x) {
                column = 0;
                row++;
            }
        }
    }

    private void loadMap(int map_num, int map_size_x, int map_size_y) {

        String path = ("/Maps/map" + map_num + ".txt");
        try {
            InputStream input_stream = getClass().getResourceAsStream(path);
            BufferedReader buffered_reader = new BufferedReader(new InputStreamReader(input_stream));

            int column = 0;
            int row = 0;

            while(column < map_size_x && row < map_size_y) {

                String line = buffered_reader.readLine();

                while (column < map_size_x) {

                    String string_numbers[] = line.split(" ");
                    int number = Integer.parseInt(string_numbers[column]);

                    map_tile_num[column][row] = number;
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
        ImageIcon[] tile_icons = new ImageIcon[] {
            new ImageIcon(getClass().getResource("/Images/Tiles/NoCollision/Static/air.png")),
            new ImageIcon(getClass().getResource("/Images/Tiles/Collision/Static/standard_grass.png"))
        };
        for (int i = 0; i < tile.length; i++) {
            tile[i] = new Tile();
            tile[i].setImage(toBufferedImage(tile_icons[i].getImage()));
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
