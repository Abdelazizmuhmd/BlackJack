/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Zizo
 */
public class card {
    public int x,y;
    public int value;
    public int speedx;
    public JLabel card;
    ImageIcon imageIcon;

    
    public card(int x,int y,String path,int value)
    {
        this.value=value;
        this.x=x;
        this.y=y;
        this.speedx=10;
        card=new JLabel();
        imageIcon = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(80, 100, Image.SCALE_DEFAULT));
        card.setIcon(imageIcon);
        card.setBounds(x, y,80,100);
       
    }
    public card()
    {
        x=0;
        y=0;
        speedx=10;
        
    }
}
