package week8to11;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class houseDetails extends JFrame implements ActionListener {

     graphs g = new graphs();
     JLabel house0 = new JLabel("House Index:- ");
     JTextField house0P = new JTextField();
     JLabel house = new JLabel("detail:- ");
     JTextField houseP = new JTextField();
     JButton done = new JButton("DOne");
     JButton back = new JButton("BACK");
     String details[] = new String[g.getVertices()];

     houseDetails(){
          setTitle("Add Edge");
          setLayout(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setSize(500,500);

          done.addActionListener(this);
          back.addActionListener(this);

          house0.setBounds(10,60,150,20);
          house0P.setBounds(150,60,100,20);
          house.setBounds(10,100,150,20);
          houseP.setBounds(150,100,100,20);
          done.setBounds(100,130,80,30);
          back.setBounds(0,0,80,30);

          add(house);
          add(house0);
          add(house0P);
          add(houseP);
          add(done);
          add(back);

     }
     void setDetails(int i, String detail){
          details[i]=detail;
     }
     public static void main(String[] args) {
          new houseDetails().setVisible(true);
     }
     @Override
     public void actionPerformed(ActionEvent a) {
          if(a.getSource()==back){
               dispose();
               new week8TO11().setVisible(true);
          }
          if(a.getSource()==done){
               int inte = Integer.parseInt(house0P.getText());
               String from = houseP.getText();
               setDetails(inte, from);
          }          
     }
     
}
