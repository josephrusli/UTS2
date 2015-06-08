import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;
class Global 
{
    public static String s1 = new String();
}

public class phone extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bintang,pager,call,del,contacts;
	JLabel sb;
	JPanel jp1,jp2,jp3,jp4,jp5,jpKeypad;
	JTextArea jt;
	
	String s = new String("");
	Timer tm = new Timer(10,this);
	Color back = new Color(0, 0, 0, 0);
	public phone()
	{
		
		setTitle("Phone");
		setSize(480,720);		
		setVisible(true);
		setLocation(500,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jpKeypad = new JPanel();
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
		b5 = new JButton();
		b6 = new JButton();
		b7 = new JButton();
		b8 = new JButton();
		b9 = new JButton();
		b0 = new JButton();
		bintang = new JButton();
		pager = new JButton();
		call = new JButton();
		del = new JButton();
		contacts = new JButton();
		Insets margin = new Insets(-4,-4,-4,-4);
		b1.setIcon(new ImageIcon("pic//b1.png"));
		b1.setPressedIcon(new ImageIcon("pic//b1.jpg"));
		b1.setBorderPainted(false);
		b1.setMargin(margin);
		b2.setIcon(new ImageIcon("pic//b2.png"));
		b2.setPressedIcon(new ImageIcon("pic//b2.jpg"));
		b2.setBorderPainted(false);
		b2.setMargin(margin);
		b3.setIcon(new ImageIcon("pic//b3.png"));
		b3.setPressedIcon(new ImageIcon("pic//b3.jpg"));
		b3.setBorderPainted(false);
		b3.setMargin(margin);
		b4.setIcon(new ImageIcon("pic//b4.png"));
		b4.setPressedIcon(new ImageIcon("pic//b4.jpg"));
		b4.setBorderPainted(false);
		b4.setMargin(margin);
		b5.setIcon(new ImageIcon("pic//b5.png"));
		b5.setPressedIcon(new ImageIcon("pic//b5.jpg"));
		b5.setBorderPainted(false);
		b5.setMargin(margin);
		b6.setIcon(new ImageIcon("pic//b6.png"));
		b6.setPressedIcon(new ImageIcon("pic//b6.jpg"));
		b6.setBorderPainted(false);
		b6.setMargin(margin);
		b7.setIcon(new ImageIcon("pic//b7.png"));
		b7.setPressedIcon(new ImageIcon("pic//b7.jpg"));
		b7.setBorderPainted(false);
		b7.setMargin(margin);
		b8.setIcon(new ImageIcon("pic//b8.png"));
		b8.setPressedIcon(new ImageIcon("pic//b8.jpg"));
		b8.setBorderPainted(false);
		b8.setMargin(margin);
		b9.setIcon(new ImageIcon("pic//b9.png"));
		b9.setPressedIcon(new ImageIcon("pic//b9.jpg"));
		b9.setBorderPainted(false);
		b9.setMargin(margin);
		b0.setIcon(new ImageIcon("pic//b0.png"));
		b0.setPressedIcon(new ImageIcon("pic//b0.jpg"));
		b0.setBorderPainted(false);
		b0.setMargin(margin);
		bintang.setIcon(new ImageIcon("pic//bintang.png"));
		bintang.setPressedIcon(new ImageIcon("pic//bintang.jpg"));
		bintang.setBorderPainted(false);
		bintang.setMargin(margin);
		pager.setIcon(new ImageIcon("pic//pager.png"));
		pager.setPressedIcon(new ImageIcon("pic//pager.jpg"));
		pager.setBorderPainted(false);
		pager.setMargin(margin);
		call.setIcon(new ImageIcon("pic//call.png"));
		call.setPressedIcon(new ImageIcon("pic//call.jpg"));
		call.setBorderPainted(false);
		call.setMargin(margin);
		contacts.setIcon(new ImageIcon("pic//contacts.png"));
		contacts.setPressedIcon(new ImageIcon("pic//contacts.jpg"));
		contacts.setBorderPainted(false);
		contacts.setMargin(margin);
		del.setIcon(new ImageIcon("pic//del.png"));
		del.setPressedIcon(new ImageIcon("pic//del.jpg"));
		del.setBorderPainted(false);
		del.setMargin(margin);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		pager.addActionListener(this);
		bintang.addActionListener(this);
		call.addActionListener(this);
		del.addActionListener(this);
		contacts.addActionListener(this);
		jp1.add(b1);
		jp1.add(b2);
		jp1.add(b3);
		jp1.add(b4);
		jp1.add(b5);
		jp1.add(b6);
		jp1.add(b7);
		jp1.add(b8);
		jp1.add(b9);
		jp1.add(bintang);
		jp1.add(b0);
		jp1.add(pager);
		jp1.add(contacts);
		jp1.add(call);
		jp1.add(del);
	
		Font f = new Font("Arial", Font.BOLD,65);
		jt = new JTextArea(1,1);
		jt.setFont(f);
        jt.setEditable(false);
        jt.setText(s);
		jt.setOpaque(false);
	
		jp2.add(jt);
		add(jp2,BorderLayout.NORTH);
		jp1.setLayout(new  GridLayout(5,3));
		jpKeypad.add(jp1);
		add(jpKeypad,BorderLayout.CENTER);
		JButton aa = new JButton("aa");
		jp3.add(aa);
		add(jp3,BorderLayout.SOUTH);
		validate();
	
	}
	public void paint(Graphics g)
	{
		ImageIcon icon = new ImageIcon ( "pic//car.png" );
		g.drawImage(icon.getImage (), 0, 190, null);
	}
	
	public void actionPerformed(ActionEvent e)
	{
	  Object source = e.getSource();
	  if(source == b1)
	  {
		s +="1"; 
		try
		{
		Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("sound\\b1.wav")));
        clip.start();
		}
		catch (Exception exc){}
	  }
	  if(source == b2)
	  {
		s +="2";
		try
		{
		Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("sound\\b2.wav")));
        clip.start();
		}
		catch (Exception exc){}
	  }
	  if(source == b3)
	  { 
		s +="3";
		try
		{
		Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("sound\\b3.wav")));
        clip.start();
		}
		catch (Exception exc){}
	  }
	  if(source == b4) 
	  {
		s +="4";
		try
		{
		Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("sound\\b4.wav")));
        clip.start();
		}
		catch (Exception exc){}
	  }
	  if(source == b5)
	  {	  
		s +="5";
		try
		{
		Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("sound\\b5.wav")));
        clip.start();
		}
		catch (Exception exc){}
	  }
	  if(source == b6)
	  {
		s +="6";
		try
		{
		Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("sound\\b6.wav")));
        clip.start();
		}
		catch (Exception exc){}
	  }
	  if(source == b7)
	  {
		s +="7";
		try
		{
		Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("sound\\b7.wav")));
        clip.start();
		}
		catch (Exception exc){}
	  }
	  if(source == b8)
	  {
		s +="8";
		try
		{
		Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("sound\\b8.wav")));
        clip.start();
		}
		catch (Exception exc){}
	  }
	  if(source == b9)
	  {
		s +="9";
		try
		{
		Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("sound\\b9.wav")));
        clip.start();
		}
		catch (Exception exc){}
	  }
	  if(source == b0)
	  {
		s +="0";
		try
		{
		Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("sound\\b0.wav")));
        clip.start();
		}
		catch (Exception exc){}
	  }
	  if(source == bintang)
	  {
		s +="*";
		try
		{
		Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("sound\\b1.wav")));
        clip.start();
		}
		catch (Exception exc){}
	  }
	  if(source == pager) 
	  {
		s +="#";
		try
		{
		Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("sound\\b3.wav")));
        clip.start();
		}
		catch (Exception exc){}
	  }
	  if(source == del) 
	  {
		if(s.length() > 0)
		{
		StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(s.length() - 1);
        s = sb.toString();
	    }
	  }
	    
	  if(source == contacts) 
	  {
		//contacts b = new contacts();
	    //setVisible(false);
		
		
	  }
	  if(source == call && s.length() > 0) 
	  {
		try { Thread.sleep(500); } 
		catch ( Exception e1 ) { } 
		
		call b = new call();
		
	  }
	  jt.setText(s);
	  Global.s1 = s;
	}
	
	public static void main(String[] args) throws Exception
	{
		phone a = new phone();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

class call extends JFrame implements ActionListener
	{
		Clip clip;
		JButton back;
		JPanel jpCall,jpEnd;
		JButton end;
		JLabel jl;
		String s = "calling...";
		Font f = new Font("Arial", Font.BOLD,65);
		public call() 
		{
			setTitle("Call");
			setSize(497,737); 
			setVisible(true);
			setLocation(492,92);
			try
			{
				clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(new File("sound\\ring.wav")));
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			catch(Exception exc){}

			jpCall = new JPanel();
			jpEnd = new JPanel();
			end = new JButton();
			
			Insets margin = new Insets(-4,-4,-4,-4);
			end.setIcon(new ImageIcon("pic//end.png"));
			end.setPressedIcon(new ImageIcon("pic//end.jpg"));
			end.setBorderPainted(false);
			end.setMargin(margin);
			end.addActionListener(this);
			
			JTextArea jt = new JTextArea(1,1);
			jt.setFont(f);
			jt.setOpaque(false);
			jt.setEditable(false);
			jt.setText(Global.s1);
			
			Color back = new Color(0, 0, 0, 1);
			jpCall.setBackground(Color.lightGray);
			jpEnd.setLayout(new BorderLayout());
			jpEnd.add(end);
			jpCall.add(jt);
			add(jpCall,BorderLayout.NORTH);
			add(jpEnd, BorderLayout.SOUTH);
		}
		public void paint(Graphics g)
		{
			super.paint(g);
			ImageIcon icon = new ImageIcon ( "pic//bgCall1.jpg" );
			Font f = new Font("Corbel",Font.PLAIN,40);
			Color back = new Color(255, 255, 255, 100);
			g.drawImage(icon.getImage (), 10, 130, null);
			g.setFont(f);
			g.setColor(back);
			g.drawString(s,150,180);
		}
		public void actionPerformed(ActionEvent e)
	    {
			Object source = e.getSource();
			if(source == end) 
			{
				try 
				{ 
					Clip clip1;
					clip1 = AudioSystem.getClip();
					clip1.open(AudioSystem.getAudioInputStream(new File("sound\\b0.wav")));
					clip1.start();
					Thread.sleep(700); 
				} 
				catch ( Exception e1 ) { }
				clip.stop();
				dispose();
			}
		}
		
		
	}
	
	
	