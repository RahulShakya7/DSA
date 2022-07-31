package week8to11;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class nameVertices extends JFrame implements ActionListener {

     graphs g = new graphs();
     JLabel house = new JLabel("Current Name Index:- ");
     JTextField houseP = new JTextField();
     JLabel house0 = new JLabel("New Name:- ");
     JLabel list = new JLabel("");
     JTextField house0P = new JTextField();     
     JButton set = new JButton("SET");
     JButton back = new JButton("BACK");
     String names0[]=new String[g.getVertices()];
     nameVertices(){
          // String names[]=g.getNodeName();
          for(int i=0;i<g.getVertices();i++){
               names0[i]=g.getNodeName(i);
               System.out.println(names0[i]);
          }
          JList l = new JList(names0);     

          setTitle("Add Edge");
          setLayout(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setLocationRelativeTo(null);          
          setSize(450,310);

          set.addActionListener(this);
          back.addActionListener(this);

          back.setBounds(0,0,80,30);
          house.setBounds(10,60,150,20);
          houseP.setBounds(150,60,100,20);
          house0.setBounds(10,100,150,20);
          house0P.setBounds(150,100,100,20);
          set.setBounds(100,130,80,30);
          l.setBounds(300,10,100,1000);

          add(house);
          add(houseP);
          add(house0);
          add(house0P);
          add(set);
          add(l);
          add(back);

     }
     public static void main(String[] args) {
          new nameVertices().setVisible(true);
     }
     @Override
     public void actionPerformed(ActionEvent a) {
          if(a.getSource()==back){
               dispose();
               new week8TO11().setVisible(true);
          }
          if(a.getSource()==set){
               int from = Integer.parseInt(houseP.getText());
               String to = house0P.getText();
               g.setNodeName(from, to);
          }          
     }
     
}
