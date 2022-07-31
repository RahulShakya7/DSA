package week8to11;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class view extends JFrame implements ActionListener {

     graphs g = new graphs();
     JLabel house = new JLabel("From:- ");
     JButton back = new JButton("BACK");

     view(){
          setTitle("Add Edge");
          setLayout(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          // setBounds(0,0,570,310);

          back.addActionListener(this);

          back.setBounds(0,0,80,30);
          house.setBounds(10,60,1000,1000);

          add(house);
          add(back);

     }
     public static void main(String[] args) {
          new view().setVisible(true);
     }
     @Override
     public void actionPerformed(ActionEvent a) {
          if(a.getSource()==back){
               dispose();
               new week8TO11().setVisible(true);
          }   
     }  
}
