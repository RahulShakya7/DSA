package week8to11;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class setVertices extends JFrame implements ActionListener {

     graphs g = new graphs();
     JLabel ver = new JLabel("No. of Vertices:- ");
     JTextField vertices = new JTextField();
     JButton set = new JButton("SET");
     JButton back = new JButton("BACK");


     setVertices(){
          setTitle("Add Edge");
          setLayout(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setSize(300,200);

          set.addActionListener(this);
          back.addActionListener(this);

          back.setBounds(0,0,69,26);
          ver.setBounds(10,60,100,20);
          vertices.setBounds(150,60,100,20);
          set.setBounds(100,100,80,30);

          add(ver);
          add(vertices);
          add(set);
          add(back);

     }
     public static void main(String[] args) {
          new setVertices().setVisible(true);
     }
     @Override
     public void actionPerformed(ActionEvent a) {
          if(a.getSource()==back){
               dispose();
               new week8TO11().setVisible(true);
          }
          if(a.getSource()==set){
               int from = Integer.parseInt(vertices.getText());
               g.setVertices(from);
               dispose();
               new week8TO11().setVisible(true);

          }          
     }
}
