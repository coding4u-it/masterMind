/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterMind;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 * @author fra
 */
public enum Colori {
    col1 (0,"c0.png"), col2 (1,"c1.png"), col3 (2,"c2.png"), col4 (3,"c3.png"),
    col5 (4,"c4.png"), col6 (5,"c5.png"), col7 (6,"c6.png"), col8 (7,"c7.png");

    private ImageIcon name;       

    private Colori(int i,String name) {
        this.name = new ImageIcon(Main.class.getResource("/Img/"+name));
    }
    
 /**
  * estrae un colore casuale.
  * @return 
  */
    public ImageIcon getRandomColor() {
        Random rnd = new Random();
        Colori c=values()[rnd.nextInt(values().length)];
        return c.name;
    }
    
    public ImageIcon[] getAllColor(){
        ImageIcon []c=new ImageIcon[8];
        for(int i=0;i<8;i++)
            c[i] = getColor(i);
        return c;
    }
    
     public ImageIcon getColor(int i){   
         Colori c=values()[i];
        return c.name;
    }
    
}