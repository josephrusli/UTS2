import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class homeScreen extends JFrame implements ActionListener
{	
	
	JButton phoneb,message,notepad,phonebook;
	status status = new status();
	JPanel home = new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				ImageIcon background = new ImageIcon("pic//background.jpg");
				g.drawImage(background.getImage(),0,0,null);
				g.setFont(new Font("Courier New",Font.BOLD,80));
				g.setColor(new Color(255,255,255,140));
				g.drawString(homeScreen.timeNow(),120,130);
				g.setFont(new Font("Courier New",Font.BOLD,30));
				g.drawString(homeScreen.dateNow(),100,190);
				g.setFont(new Font("Arial",Font.PLAIN,20));
				g.setColor(new Color(255,255,255,200));
				g.drawString("Phone",112,389);
				g.drawString("SMS",310,389);
				g.drawString("Notes",112,570);
				g.drawString("Contacts",295,570);
			}
		};
	Timer tm = new Timer(10, this);
	public homeScreen()
	{
		tm.start();
		setTitle("PHONE");
		setSize(480,720);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBackground(Color.BLACK);
		setLayout(null);
		setVisible(true);
   
	   phoneb = new JButton();
	   message = new JButton();
	   notepad = new JButton();
	   phonebook = new JButton();
	   
	   phoneb.setIcon(new ImageIcon("pic//phone.png"));
	   message.setIcon(new ImageIcon("pic//sms.png"));
	   notepad.setIcon(new ImageIcon("pic//notes.png"));
	   phonebook.setIcon(new ImageIcon("pic//homecontacts.png"));
	   
	   phoneb.setPressedIcon(new ImageIcon("pic//phone1.png"));
	   message.setPressedIcon(new ImageIcon("pic//sms1.png"));
	   notepad.setPressedIcon(new ImageIcon("pic//notes1.png"));
	   phonebook.setPressedIcon(new ImageIcon("pic//homecontacts1.png"));
	   
	   phoneb.setContentAreaFilled(false);
	   message.setContentAreaFilled(false);
	   notepad.setContentAreaFilled(false);
	   phonebook.setContentAreaFilled(false);
	   
	   phoneb.setBorderPainted(false);
	   message.setBorderPainted(false);
	   notepad.setBorderPainted(false);
	   phonebook.setBorderPainted(false);
	 
	   phoneb.addActionListener(this);
	   message.addActionListener(this);
	   notepad.addActionListener(this);
	   phonebook.addActionListener(this);
		
	   int x = 80,y = 250;
	   phoneb.setBounds(x,y,120,120);
	   message.setBounds(x+190,y,120,120);
	   notepad.setBounds(x,y+180,120,120);
	   phonebook.setBounds(x+190,y+180,120,120);

		home.setLayout(null);
		home.add(phoneb);
		home.add(message);
		home.add(notepad);
		home.add(phonebook);
		home.setBounds(0,30,480,700);
		add(home);
		status.setBounds(0,0,480,30);
		add(status);
		repaint();
		validate();
		
	}
	public void actionPerformed(ActionEvent e)
	{
	  repaint();
	  Object source = e.getSource();
		if(source == phoneb)
		{
			new phone();
		}
		
		if(source == message)
		{
			new textmessage();
		}
		if(source == notepad)
		{
			new notes();
		}
		
		if(source == phonebook)
		{
			new contacts();
		}
	}
	
	public static String timeNow() 
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		return sdf.format(cal.getTime());
	}
	
	public static String dateNow() 
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
		return sdf.format(cal.getTime());
	}

	public static void main(String[] args)
	{ 
		homeScreen a = new homeScreen();
	}
}


class status extends JPanel implements ActionListener
{	
	Timer tm = new Timer(10, this);
	public void paintComponent(Graphics g)
	{
		tm.start();
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pic//status.png");
		g.drawImage(background.getImage(),0,0,null);
		g.setFont(new Font("Arial",Font.BOLD,18));
		g.setColor(new Color(255,255,255,200));
		g.drawString(phone.timeNow(),200,22);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
	
}