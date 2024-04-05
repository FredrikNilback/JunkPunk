package Classes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean up, left, down, right, jump;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key_code = e.getKeyCode();              //MOVEMENT/PLAYER CONTROLS
                                                    //87 W - up
        if(key_code == 87) {                        //65 A - left
            up = true;                              //83 S - down
        }                                           //68 D - right
                                                
        if(key_code == 65) {                        //32 space - jump
            left = true;                            //16 shift - walk
        }                                           
                                                    //69 E - grapple
        if(key_code == 83) {                        //70 F - interact
            down = true;                            //71 G - throw
        }                                          
                                                    //MENUS
        if(key_code == 68) {                        //27 escape - main menu
            right = true;                           //73 I - inventory
        }                                           //9 tab - inventory
                                                        
        if(key_code == 32) {                        //UNASSIGNED BUT MAY BE USEFUL
            jump = true;                            //10 enter
        }                                           //17 ctrl
                                                    //18 alt
                                                    //81 Q
   
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int key_code = e.getKeyCode();

        if(key_code == 87) {
            up = false;
        }

        if(key_code == 65) {
            left = false;
        }

        if(key_code == 83) {
            down = false;
        }

        if(key_code == 68) {
            right = false;
        }

        if(key_code == 32) {
            jump = false;
        }
    }
}
