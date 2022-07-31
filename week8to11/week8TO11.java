package week8to11;
//INCOMPLETE
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// return adjNode in array of any vertex(v) like node 2==ktm
public class week8TO11 extends JFrame implements ActionListener{

     JButton setVertices = new JButton("Set Vertices");
     JButton nameVertices = new JButton("Name Vertices");
     JButton addDetails = new JButton("House Details");
     JButton view = new JButton("View Pipes");
     JButton viewSugges = new JButton("View Suggestions");
     JButton add = new JButton("ADD/UPDATE");

     week8TO11() {
          setTitle("LogIn");                           
          setLayout(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setSize(570,310);
          
          setVertices.addActionListener(this);
          nameVertices.addActionListener(this);
          addDetails.addActionListener(this);
          view.addActionListener(this);
          viewSugges.addActionListener(this);
          add.addActionListener(this);

          setVertices.setBounds(10,10,150,100);
          nameVertices.setBounds(210,10,150,100);
          addDetails.setBounds(10,150,150,100);
          view.setBounds(210,150,150,100);
          viewSugges.setBounds(410,150,150,100);
          add.setBounds(410,10,150,100);


          add(setVertices);
          add(nameVertices);
          add(addDetails);
          add(view);
          add(viewSugges);          
          add(add);


     }

     public static void main(String[] args) {
          new week8TO11().setVisible(true);
     }

     @Override
     public void actionPerformed(ActionEvent a) {
          if(a.getSource()==setVertices){
               dispose();
               new setVertices().setVisible(true);
          }
          if(a.getSource()==nameVertices){
               dispose();
               new nameVertices().setVisible(true);
          }
          if(a.getSource()==addDetails){
               dispose();
               new houseDetails().setVisible(true);
          }
          if(a.getSource()==view){
               dispose();
               new view().setVisible(true);
          }
          if(a.getSource()==viewSugges){
               dispose();
               new viewSuggest().setVisible(true);
          }
          if(a.getSource()==add){
               dispose();
               new add().setVisible(true);
          }
     }
}
