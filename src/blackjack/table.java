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
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author Zizo
 */
public class table extends JFrame{
  
  
 
       
       table(){
   
      setLayout(null);
   try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("/Users/Desktop/de/table1.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
      setSize(700,400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
       }
         


}