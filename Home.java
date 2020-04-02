import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.net.*;
import javax.swing.ImageIcon;

public class Home extends JFrame implements ActionListener{
	JButton queue,stack,bst,llist,cqueue;
	JLabel s1=new JLabel("");
	JLabel q1 =new JLabel("");
	JLabel c1 = new JLabel("");
	JLabel l1 = new JLabel("");
	JLabel b1 =new JLabel("");
	JPanel work = new JPanel();
	URL url;
	Home()
	{
		getContentPane().setBackground(Color.black);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Data Structure Simulations ");

		setBackground(Color.white);
		work = new JPanel();

		setVisible(true);
		setSize(950,700);
		setLayout(null);
		work.setBounds(10,50,800,600);
		work.setBorder(new TitledBorder(new LineBorder(Color.black, 5), "MENU"));
		add(work);
		work.setLayout(null);
        //work.setBackground(Color.white);
        
      s1.setIcon(new ImageIcon("sii.png"));
        

		/*ImageIcon ic = new ImageIcon(this.getClass().getResource("st.gif"));
		JLabel jb = new JLabel(ic);
		jb.setBounds(10,10,300,400);
		getContentPane().add(jb);*/

		//s1.setIcon(new ImageIcon("C:\\Users\\Rishi\\Desktop\\CG\\sii.png"));
		c1.setIcon(new ImageIcon("cqi.jpg"));
		q1.setIcon(new ImageIcon("qii.jpg"));
		l1.setIcon(new ImageIcon("ldi.png"));
		b1.setIcon(new ImageIcon("bsti.png"));

		queue = new JButton("QUEUE");
		stack = new JButton("STACK");
		bst = new JButton("BST TREE");
		llist = new JButton("LINK LIST");
		cqueue = new JButton("CIRCULAR QUEUE");

		//s1.setBounds(50,30,150,150);
		//work.add(s1);
		//stack.setBounds(50,190,100,30);
		

		//c1.setBounds(50,230,150,150);
		//work.add(c1);
		//cqueue.setBounds(50,390,150,30);
		


		

		setVisible(true);
		setSize(930,700);
		setLayout(null);

		queue.setBounds(50,40,100,30);
		stack.setBounds(50,90,100,30);
		bst.setBounds(50,140,100,30);
		llist.setBounds(50,190,120,30);
		cqueue.setBounds(50,240,150,30);

		work.add(queue);
		work.add(cqueue);
		work.add(bst);
		work.add(llist);
		work.add(stack);
		
		/*add(queue);
		add(stack);
		add(bst);
		add(llist);
		add(cqueue);*/

		queue.addActionListener(this);
		stack.addActionListener(this);
		bst.addActionListener(this);
		llist.addActionListener(this);
		cqueue.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent ae){

		if(ae.getSource()==queue){
			SwingUtilities.invokeLater(new Runnable()
			{
			public void run()
			{
				Queue objq = new Queue();
			}	
			});
		}
		else if(ae.getSource()==stack){
			SwingUtilities.invokeLater(new Runnable()
			{
			public void run()
			{
				Stack objs = new Stack();
			}	
			});
		}
		else if(ae.getSource()==bst)
		{
			SwingUtilities.invokeLater(new Runnable()
			{
			public void run()
			{
				Frame objb = new Frame("Project Data Structure");
			}	
			});
		}
		else if(ae.getSource()==llist){
			SwingUtilities.invokeLater(new Runnable()
			{
			public void run()
			{
				Linkedlist objl = new Linkedlist();
			}	
			});
		}
		else if(ae.getSource()==cqueue){
			SwingUtilities.invokeLater(new Runnable()
			{
			public void run()
			{
				CQueue objc=new CQueue();
			}	
			});
		}

	}

	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				/*Home h1 =*/ new Home().setVisible(true);
			}
		});
	}
}
