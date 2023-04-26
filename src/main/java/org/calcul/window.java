package org.calcul;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.*;

public class window implements ActionListener {
    
    JTextField afficheur;
    JButton [] btnumber =new JButton[10];
    JButton [] fct = new JButton[9];
    //JButton plus,diff,mult,div,virg,egal,del,clear;
    JPanel number;
    double num[] = new double [2];
        //double num[] = {0,0};   
    char op;
    double res=0;

    public window() {
        JFrame f = new JFrame("calculatrice");
        f.setSize(300,400); 
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setResizable(false);
        
        afficheur= new JTextField(20);
        afficheur.setBounds(7, 10, 270,40);
        afficheur.setFont(new Font("helvetica", Font.PLAIN, 20));
        //afficheur.setEditable(false);
        afficheur.setTransferHandler(null);//block copy/past

        afficheur.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
              char c = e.getKeyChar();
                 if(((c < '0') || (c > '9')) || (c==KeyEvent.VK_BACK_SPACE) ) {e.consume();  }// ignorer l'événement
                
                 
             }

          });

        number= new JPanel();     
        number.setBounds( 26, 110, 225, 225);      
        number.setLayout(new GridLayout(4,4,5,5));
        
              JButton  b0 = new JButton("0");
              JButton  b1 = new JButton("1");
              JButton  b2 = new JButton("2");
              JButton  b3 = new JButton("3");
              JButton  b4 = new JButton("4");
              JButton  b5 = new JButton("5");
              JButton  b6 = new JButton("6");
              JButton  b7 = new JButton("7");
              JButton  b8 = new JButton("8");
              JButton  b9 = new JButton("9");
            
              JButton virg = new JButton(",");
              JButton egal = new JButton("=");
              JButton diff = new JButton("-");
              JButton div = new JButton("/");
              JButton mult = new JButton("*");
              JButton plus = new JButton("+");
              JButton clear = new JButton("C");
              JButton del = new JButton("del");
              JButton neg = new JButton("(-)");

              btnumber[0]=b0;
              btnumber[1]=b1;
              btnumber[2]=b2;
              btnumber[3]=b3;
              btnumber[4]=b4;
              btnumber[5]=b5;
              btnumber[6]=b6;
              btnumber[7]=b7;
              btnumber[8]=b8;
              btnumber[9]=b9;

        for(int i =0;i<10;i++) {
            btnumber[i].setBounds(0,0,80, 150);
			btnumber[i].addActionListener(this);
			btnumber[i].setFocusable(false);
            btnumber[i].setFont(new Font("helvetica", Font.PLAIN, 20));
		}

              fct[0]=egal;
              fct[1]=diff;
              fct[2]=plus;
              fct[3]=div;
              fct[4]=mult;
              fct[5]=clear;
              fct[6]=del;
              fct[7]=virg;
              fct[8]=neg;
             //plus,diff,mult,div,virg,egal,del,clear;

        for(int i=0;i<9;i++) {
            
			fct[i].addActionListener(this);
			fct[i].setFocusable(false);
            fct[i].setFont(new Font("helvetica", Font.PLAIN, 20));
		}
            clear.setBounds(26,60,75,50);
            del.setBounds(102,60,75,50);
            neg.setBounds(179,60,75,50);

              number.add(b7);
              number.add(b8);
              number.add(b9);
              number.add(mult);
              number.add(b4);
              number.add(b5);
              number.add(b6);
              number.add(div);
              number.add(b1);
              number.add(b2);
              number.add(b3);
              number.add(plus);
              number.add(b0);
              number.add(virg);
              number.add(egal);
              number.add(diff);
        
        f.add(number);
        f.add(clear);
        f.add(del);
        f.add(neg);

        f.add(afficheur,BorderLayout.NORTH );              

        f.setVisible(true);




    }
int a=0,b=0; // flag//

    @Override
	public void actionPerformed(ActionEvent e) {
        Object c=e.getSource();            

        

        for(int i=0;i<10;i++) { // num
			if(c == btnumber[i]) {
                b=0;
            
			afficheur.setText(afficheur.getText().concat(String.valueOf(i)));}//afficher dans textfield le text envoyer par le composant (button)
		}
        if(c == fct[6]) { //del
            String x = afficheur.getText(); 
			afficheur.setText("");
			for(int i=0;i<x.length()-1;i++) {
				afficheur.setText(afficheur.getText()+x.charAt(i));
			}
        }
        if(c == fct[5]) { // clear
            a=0;b=0;
            num[0]=0;num[1]=0;
            afficheur.setText("");}


		if(c == fct[7]) { // virg
            //pour eviter deux .
        if(a==1){/*rien*/}
        else{afficheur.setText(afficheur.getText().concat("."));a=1;}
 
        }
        
        if(c == fct[2]) { // plus
            a=0;b=0;
            num[0] = Double.parseDouble(afficheur.getText());
           op = '+';
           afficheur.setText("");
        }
        if(c == fct[1]) { // moin
            a=0;b=0;
            num[0]=Double.parseDouble(afficheur.getText());
            op = '-';
            afficheur.setText("");
         }
         if(c == fct[3]) { // div
            a=0;b=0;
            num[0]=Double.parseDouble(afficheur.getText());
            op = '/';
            afficheur.setText("");
         }
         if(c == fct[4]) { // mult
            a=0;b=0;
            num[0]=Double.parseDouble(afficheur.getText());
            op = '*'; 
            afficheur.setText("");
         }
         if(c == fct[8]) { // neg
            double t = Double.parseDouble(afficheur.getText());
			t*=-1;
			afficheur.setText(String.valueOf(t));
         }
         if(c == fct[0]) { // egal
            a=1;
         if(b==1){/*rien*/}
         else{
             if(num[0] == 0 && num[1]==0 && op=='/'){afficheur.setText("impossible");}
            //if(num[0] == 0 &&num[1] != 0 && op=='-'){res=num[1]*-1;afficheur.setText(String.valueOf(res));}
             if(num[0] == 0 &&num[1] == 0 && op==0){res=0;afficheur.setText(String.valueOf(res));}
            
                num[1]=Double.parseDouble(afficheur.getText());
            switch (op){
                case '+':
                    res = num[0]+num[1];break;
                case '-':
                    res = num[0]-num[1];break;
                case '*':
                    res = num[0]*num[1];break;
                case '/':
                {res = num[0]/num[1]; 
                    if(num[0]== 0 && num[1]!=0){res=0;}
                    break;}
            
            }
            //if(num[1] == 0 ){res = num[0];}
            
            afficheur.setText(String.valueOf(res));b=1;
             // num
                if(c == btnumber[1]) {afficheur.setText("");}
        
        
        
        }
         }




}

}