/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import static java.lang.Thread.sleep;
import java.util.*;
import javax.imageio.ImageIO;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
/**
 *
 * @author Zizo
 */
public class game extends JPanel {
    
       private int x,y;
       private int random;
       private JButton cards;
       private int cardValue; 
       private ImageIcon imageIcon;
       private JLabel points;
       private JLabel pointsno;
       private JLabel bit;
       private int sum2;
       private int sum;
       private JLabel bitno;
       private int score;
       private int bitv;
       private ArrayList<Integer>numbers;
       private JButton stop;
       private JButton bitt;
       private JButton newGame;

       
       
       game(){
           super();
            this.setOpaque( false ) ;
       score=1000;
       bitv=0;
       numbers=new ArrayList<Integer>(52);
       setLayout(null);
       this.setBounds(0,0, 700, 400);
       
       cards=new JButton();
       imageIcon = new ImageIcon(new ImageIcon("/Users/Desktop/de/cards1.png").getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT));
       cards.setIcon(imageIcon);
       cards.setBounds(590, 130, 50, 80);
       cards.addActionListener(new hitAction());
       
       points=new JLabel();
       points.setText("points:");
       points.setBounds(20, 310, 50,20);
       pointsno=new JLabel(String.valueOf(score));
       pointsno.setBounds(65, 320, 50,20);
       
       
       bit=new JLabel();
       bit.setText("bit:");
       bit.setBounds(20, 330, 50,20);
       bitno=new JLabel(String.valueOf(bitv));
       bitno.setBounds(130, 347, 50,20);
       
       stop=new JButton();
       stop.setText("stand");
       stop.setBounds(490,320, 80, 30);
       stop.addActionListener(new stopAction());
       
       bitt=new JButton();
       bitt.setText("bit");
       bitt.setBounds(575,320, 80, 30);
       bitt.addActionListener(new bitAction());
       
       newGame=new JButton();
       newGame.setText("newGame");
       newGame.setBounds(575,350,100,30);
       newGame.addActionListener(new newAction());
       
    

       x=80;
       y=0;
       sum=0;
       sum2=0;
       cardValue=0;
       
        add(bitt);
        add(stop);
       // add(bit);
        add(bitno);
        add(newGame);
      //  add(points);
        add(pointsno);
        add(cards);

       }
       
        
         class newAction implements ActionListener{

        public void actionPerformed(ActionEvent arg0) {
          table table1=new table();
          game game2=new game();
          table1.add(game2);
          table1.setVisible(true);
        }
       
       }
       class stopAction implements ActionListener{
             card c;

        public void actionPerformed(ActionEvent arg0) {
               x=80;
                y=40;
        
          while(true){
          random = ThreadLocalRandom.current().nextInt(10, 61 + 1);

          if (!numbers.contains(random)) {
          numbers.add(random);
          if(random%10==0||random>=50){
          cardValue=10;
          }else{
          cardValue=random%10;
          }
                  c=new card(x,y,"/Users/Desktop/de/cards/"+random+".png",cardValue);
                  add(c.card);
                  x=x+100;
                      
                  try {        
                  paintImmediately(0, 0, 700,400);
                  Thread.sleep(2000);
                  } catch (InterruptedException ex) {
                  }
                  
          sum2+=cardValue;
                  
          if(sum2>21){
              score=score+bitv+bitv;
              JOptionPane.showMessageDialog(null, "You Won :"+2*bitv,"won", JOptionPane.INFORMATION_MESSAGE);

              pointsno.setText(String.valueOf(score));
              bitno.setText(String.valueOf(0));
              break;
          }else if(sum2>sum){
               JOptionPane.showMessageDialog(null, "You Lost: "+bitv ,"Lost", JOptionPane.INFORMATION_MESSAGE);
               score-=bitv;
               pointsno.setText(String.valueOf(score));
               bitno.setText(String.valueOf(0));
                                              
               break;
               
          }}}}}
       
   class hitAction implements ActionListener{
             card c;

          public void actionPerformed(ActionEvent arg0) {
             y=180;
        
          while(true){
          random = ThreadLocalRandom.current().nextInt(10, 61 + 1);

          if (!numbers.contains(random)) {
          numbers.add(random);
          // small trick with % to get the value of the card ex card number 2 will be in the file like 22.png 32.png 42.png 12.png 
          //so we make % 10 to get the value of the second number which is 2 
               if(random%10==0||random>=50){
               cardValue=10;
               }else{
                   cardValue=random%10;
               }
               System.out.println(random);
                  c=new card(x,y,"/Users/Desktop/de/cards/"+random+".png",cardValue);
                  add(c.card);
                  x=x+100;
                  repaint();
                  break;        
          }
                      } 
          sum+=cardValue;
          if(sum>21){
          JOptionPane.showMessageDialog(null, "You Lost:"+bitv ,"Lost", JOptionPane.INFORMATION_MESSAGE);
          score=score-bitv;
          pointsno.setText(String.valueOf(score));
          bitno.setText(String.valueOf(0));
          }
        }
       }
       
        class bitAction implements ActionListener{

        public void actionPerformed(ActionEvent arg0) {
            if(score>0){
           score=score-20;
           pointsno.setText(String.valueOf(score));
           bitv=bitv+20;
           bitno.setText(String.valueOf(bitv));
                  }
        }
       
        
        
       

        
       }
       
       
       
       
       
    
}
