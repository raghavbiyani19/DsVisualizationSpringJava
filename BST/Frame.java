/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package testabc;
/*import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;*/
import javax.swing.border.AbstractBorder;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.Border;

public class Frame extends JFrame {

    private ArrayList<Line> lines = new ArrayList<Line>();
    private BSTree tree = new BSTree();
    JButton insertBtn,deleteBtn;
    JTextField insert,delete;
    JPanel panel;
    Graphics gh;
    JLabel jl;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        gh=g;
        System.out.println("In Paint");
        for (Line l : lines) {
            g.setColor(Color.BLUE);
            g.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
        }
    }


    public Frame(String title) {
        //The Characteristics of Frame ....................................................
        setSize(1300, 500);
        setLocation(35, 100);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(title);
        JPanel top = new JPanel();
        top.setBackground(Color.orange);
        JLabel jltop = new JLabel("Binary Search Tree Animation");
        top.add(jltop);
        add(top, BorderLayout.PAGE_START);
        JPanel bottom = new JPanel();
        bottom.setBackground(Color.GREEN);
        //JLabel jlbottom = new JLabel("");
        //bottom.add(jlbottom);
        add(bottom, BorderLayout.PAGE_END);
        //...................................................................................
        //Buttons and TextField
        insertBtn = new JButton("Insert");
        insertBtn.setBounds(480, 380, 70, 25);
        insert = new JTextField(5);
        insert.setBounds(560, 380, 50, 25);
        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(680, 380, 70, 25);
        delete = new JTextField(5);
        delete.setBounds(760, 380, 50, 25);
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(insertBtn);
        panel.add(insert);
        panel.add(deleteBtn);
        panel.add(delete);
        add(panel);
        setVisible(true);
        lines.add(new Line(0, 400, 2000, 400)); //no significance

        insertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tree.insert(Integer.parseInt(insert.getText()));
                insert.setText("");
                cleanTree();
                try {
                    displayTree();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(tree.getNods().size());
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tree.delete(Integer.parseInt(delete.getText()));
                delete.setText("");
                cleanTree();
                try {
                    displayTree();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(tree.getNods().size());
            }
        });

    }

    private void displayTree() throws InterruptedException {
        System.out.println("In Display Tree");
        //Border border = BorderFactory.createLineBorder(Color.RED, 2);
        for (int i = 0; i < tree.getNods().size(); i++) {
            JLabel jl = new JLabel();
            panel.add(jl);
            int a = (tree.getNods().get(i).getData());
            jl.setText(String.valueOf(a));
            //jl.setBorder(border);
            jl.setBorder(new RoundedBorder(Color.BLUE, 10));
            int x = tree.getNods().get(i).getPostion_X();
            int y = tree.getNods().get(i).getPostion_Y();
            Thread t =new Thread(){
            @Override
            public void run(){
                for(int i=30;i<x-30;i+=20){
                    try{
                        Thread.sleep(100);
                    }catch(Exception e){  
                    }
                    jl.setBounds(i,y,25,25);
                }
            }
            };
            t.start();
            System.out.println("After thread");

            Line line = tree.getNods().get(i).getLine();
            lines.add(new Line(line.getX1(), line.getY1(), line.getX2(), line.getY2()));

        }
    }

    private void cleanTree() {
        System.out.println("In clean tree");
        panel.removeAll();
        panel.add(insertBtn);
        panel.add(insert);
        panel.add(deleteBtn);
        panel.add(delete);
        lines.removeAll(lines);
        lines.add(new Line(0, 400, 2000, 400));
        repaint();
    }

    public class RoundedBorder extends AbstractBorder {

        private final Color color;
        private final int gap;

        public RoundedBorder(Color c, int g) {
            color = c;
            gap = g;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(color);
            g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, gap, gap));
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return (getBorderInsets(c, new Insets(gap, gap, gap, gap)));
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = gap / 2;
            return insets;
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }
}

/*
cd Desktop/CG
javac Line.java
javac BSTNode.java
javac BSTree.java
javac Frame.java
javac Queue.java
javac Stack.java
javac Linkedlist.java
javac CQueue.java
javac Home.java
java Home
javac Testabc.java
java Testabc*/