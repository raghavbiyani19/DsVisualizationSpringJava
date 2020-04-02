import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Linkedlist extends JFrame implements ActionListener {
    JPanel side = new JPanel();
    int SIZE = 6;
    int p=710;
    int top = -1;
    JPanel work = new JPanel();
    TextField element;
    JButton insert,delete;
    Button new1[] = new Button[SIZE];
    String ele;
    int stk[] = new int[SIZE];
    int last = 500, e;
    int stop=10;
    Button red = new Button("  ");
    Button green = new Button("  ");
    JLabel front = new JLabel("last element");
    JLabel other = new JLabel("element");
    Button x1[]=new Button[SIZE]; 
    Button new2[] = new Button[SIZE];
    JLabel pointer=new JLabel("");
    Linkedlist(){
        
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        for (int i = 0; i < SIZE; i++) {
            stk[i] = 0;
        }
        setBackground(Color.white);
        work = new JPanel();
        element = new TextField();
        insert = new JButton("Insert");
        delete= new JButton("Delete");
        setVisible(true);
        setSize(950, 700);
        setLayout(null);
        element.setBounds(10, 10, 100, 30);
        insert.setBounds(120, 15, 100, 30);
        delete.setBounds(230, 15, 100, 30);
        work.setBounds(10, 50, 800, 600);
        add(insert);
        add(delete);
        add(element);
        insert.addActionListener(this);
        delete.addActionListener(this);
        work.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Animation Area"));
        add(work);
        work.setBackground(Color.white);
        work.setLayout(null);
        side.setBounds(810, 50, 100, 600);
        side.setBackground(Color.white);
        side.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "Info"));
        add(side);
        front.setBounds(810, 50, 30, 50);
        other.setBounds(810, 150, 30, 50);
        side.add(front);
        side.add(red);
        side.add(other);
        side.add(green);
        red.setBackground(Color.red);
        green.setBackground(Color.green);
        red.setBounds(850, 50, 20, 50);
        green.setBounds(850, 150, 20, 50);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == insert) {
            ele = element.getText();
            if (ele.equals("")) {

                JOptionPane.showMessageDialog(this, "ENTER A VALUE", "Error", 1);

                try {
                    Thread.sleep(2000);

                } catch (Exception e1) {
                }

                return;
            }

            e = Integer.parseInt(ele);
            if (top == (SIZE - 1)) {

                JOptionPane.showMessageDialog(this, "OVERFLOW OCCURED", "Error", 1);
                try {
                    Thread.sleep(2000);

                } catch (Exception e1) {
                }

            } else {

                Thread t;
                t = new Thread() {
                    @Override
                    public void run() {
                        pointer.setIcon(new ImageIcon("C:\\Users\\Rishi\\Desktop\\\\CG\\arrow.png"));
                        top=top+1;
                        new1[top] = new Button("" + e);
                        x1[top]=new Button("");
                        new2[top] = new Button("");
                        int x = 0, y = 0;
                        new1[top].setBounds(10, 100, 100, 30);
                        x1[top].setBounds(-20, 100,30,30);
                        
                        work.add(new1[top]);
                        work.add(x1[top]);
                        for (x = 650, y = 200; x > stop; x--) {
                            try {
                                Thread.sleep(2);
                            } catch (Exception ex) {
                            }
                            new1[top].setBounds(x, y, 100, 30);
                        }
                      
                        for (x=750; x >stop+100; x--) {
                        try {
                        Thread.sleep(1);
                        } catch (Exception ex) {
                        }
                        x1[top].setBounds(x, y, 30, 30);
                        }
                        if(top>0){
                            new2[top].setBounds(x-130, 210,33,5);
                            new2[top].setBackground(Color.BLACK);
                            work.add(new2[top]);
                        }
                        pointer.setBounds(x,y-75,34,61);
                        work.add(pointer);
                        stop=stop+160;
                        System.out.println(stop);
                        last -= 30;
                        stk[top] = e;
                        for (int i = 0; i < top; i++) {
                            new1[i].setBackground(Color.green);
                        }
                        new1[top].setBackground(Color.red);
                        element.setText("");
                        p=stop;
                    }

                };
                t.start();
               // work.add(n[top]);
            }

        } else {
            if (top == -1) {

                JOptionPane.showMessageDialog(this, "UNDERFLOW OCCURED", "Error", 1);

                try {
                    Thread.sleep(2000);

                } catch (Exception e1) {
                }

            } else {
                p=p-220;
                pointer.setBounds(p,125,34,61);
                work.add(pointer);
                work.remove(new1[top]);
                work.remove(new2[top]);
                work.remove(x1[top]);
                last += 30;
                int e = stk[top];
                top--;
                if(top!=-1)
                new1[top].setBackground(Color.red);
                
                
            }

        }
        for (int i = 0; i <= top; i++) {
            System.out.println("\n" + stk[i]);
    }
    
    }
    
}
