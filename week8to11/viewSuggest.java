package week8to11;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewSuggest extends JFrame implements ActionListener {

     graphs g = new graphs();
     JLabel house = new JLabel("From:- ");
     JTextField houseP = new JTextField();
     JLabel house0 = new JLabel("To:- ");
     JTextField house0P = new JTextField();     
     JLabel length0 = new JLabel("Length:- ");
     JTextField lengthP = new JTextField();
     JButton add = new JButton("ADD/UPDATE");
     JButton back = new JButton("BACK");

     viewSuggest(){
          setTitle("Sugegstions");
          setLayout(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          // setBounds(0,0,570,310);
          

          add.addActionListener(this);
          back.addActionListener(this);

          add.setBounds(410,10,150,100);
          length0.setBounds(10,110,100,20);
          house.setBounds(10,10,100,20);
          houseP.setBounds(60,10,100,20);
          house0.setBounds(10,60,100,20);
          house0P.setBounds(60,60,100,20);
          lengthP.setBounds(60,110,100,20);
          back.setBounds(0,0,80,30);

          // add(house);
          // add(houseP);
          // add(house0);
          // add(house0P);
          // add(length0);
          // add(add);
          // add(lengthP);
          // add(back);
     }
     public static void main(String[] args) {
          new viewSuggest().setVisible(true);
     }
     @Override
     public void actionPerformed(ActionEvent a) {
          if(a.getSource()==back){
               dispose();
               new week8TO11().setVisible(true);
          }
          if(a.getSource()==add){
               int from = Integer.parseInt(houseP.getText());
               int to = Integer.parseInt(house0P.getText());
               int length = Integer.parseInt(lengthP.getText());

               g.addEdge(from,to,length);
               g.printAdjVertices();
          }          
     }
}
