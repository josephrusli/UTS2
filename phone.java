import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class Global 
{
    public static int countInbox = 0;
	public static int countSent = 0;
	public static int countDraft = 0;
	public static String s1 = new String();
}

class phone extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bintang,pager,callb,del,contactsb,aa;
	JButton home, back,bb;
	JLabel sb;
	int count = 0;
	JLabel log = new JLabel();
	JPanel[] rec = new JPanel[100];
	String[] sName = new String[100];
	String[] sDate = new String[100];
	String[] sTime = new String[100];
	JPanel jp1,jp2,jpKeypad;
	JTextArea jt;
	String s = new String("");
	JPanel jpRecent;
	JScrollPane jsp;
	status status = new status();
	public phone()
	{
		setTitle("Phone");
		setSize(480,720);		
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		jp1 = new JPanel();
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
		callb = new JButton();
		del = new JButton();
		contactsb = new JButton();
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
		callb.setIcon(new ImageIcon("pic//call.png"));
		callb.setPressedIcon(new ImageIcon("pic//call.jpg"));
		callb.setBorderPainted(false);
		callb.setMargin(margin);
		contactsb.setIcon(new ImageIcon("pic//contacts.png"));
		contactsb.setPressedIcon(new ImageIcon("pic//contacts.jpg"));
		contactsb.setBorderPainted(false);
		contactsb.setMargin(margin);
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
		callb.addActionListener(this);
		del.addActionListener(this);
		contactsb.addActionListener(this);
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
		jp1.add(contactsb);
		jp1.add(callb);
		jp1.add(del);
	
		Font f = new Font("Arial", Font.BOLD,70);
		jt = new JTextArea(1,1);
		jt.setFont(f);
        jt.setEditable(false);
        jt.setText(s);
		jt.setOpaque(false);
		jpKeypad.add(jt);
		jp1.setLayout(new GridLayout(5,3));
		jpKeypad.add(jp1);

		jpRecent = new JPanel();	
		//jpRecent.setLayout(new GridLayout(20,1));
		
		try{
		display();
		}
		catch(IOException e){}

		jp2 = new JPanel();
		jp2.setLayout(null);
		JLabel recTitle = new JLabel(new ImageIcon("pic//recTitle.png"));
		recTitle.setBounds(0,0,480,60);
		jp2.add(recTitle);
		
		
		jsp = new JScrollPane(jpRecent);
		jsp.setBounds(-5,60,480,520);
		jp2.add(jsp);
		UIManager.put("TabbedPane.selected", Color.black);  
		//UIManager.put("TabbedPane.contentAreaColor ",Color.GREEN);
		UIManager.put("TabbedPane.background",Color.BLACK);
		UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
		UIManager.put("TabbedPane.tabAreaInsets", new Insets(0, 150, 0, 0));
		
		JTabbedPane tabs = new JTabbedPane ();
		tabs.addTab ("",new ImageIcon("pic//keypad.png"), jpKeypad,"BEGO");
		tabs.addTab ("",new ImageIcon("pic//recent.png"), jp2);
		tabs.setTabPlacement(JTabbedPane.BOTTOM);
		
		status.setBounds(0,0,480,30);
		tabs.setBounds(-1,30,480,652);
		add(tabs);
		add(status);
		validate();
		setVisible(true);
	}
	
	public void display() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("recents.dat"));
		String str4 = br.readLine();
		while(str4!=null)
		{
			sName[count]=str4;
			str4=br.readLine();
			sDate[count]=str4;
			str4=br.readLine();
			sTime[count]=str4;
			str4=br.readLine();
			count++;
		}
		
		jpRecent.setLayout(new GridLayout(count,1));
		for (int i = count-1;i>=0;i--) 
		{
			rec[i] = new JPanel()
			{
				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					g.setColor(new Color(50, 50, 50, 50));
					g.drawLine(50,99,455,99);
					repaint();
				}
			};
			rec[i].setPreferredSize(new Dimension(455,100));
			rec[i].setBackground(Color.WHITE);
			jpRecent.add(rec[i]);
		
		}
		
		for(int i=0;i<count;i++)
		{
			log = new JLabel();
			log.setFont(new Font("Arial", Font.PLAIN,40));
			log.setText(sName[i]);
			log.setBounds(60,10,300,60);
			
			JLabel iconrec = new JLabel();
			ImageIcon icon2 = new ImageIcon ( "pic//rec.png" );
			iconrec.setIcon(icon2);
			iconrec.setBounds(0,0,50,100);
			
			JLabel stime = new JLabel();
			stime.setFont(new Font("Arial", Font.PLAIN,20));
			stime.setForeground(new Color(50, 50, 50, 50));
			stime.setText(sTime[i]);
			stime.setBounds(360,0,120,100);
			
			JLabel sdate = new JLabel();
			sdate.setFont(new Font("Arial", Font.PLAIN,14));
			sdate.setForeground(new Color(50, 50, 50, 50));
			sdate.setText(sDate[i]);
			sdate.setBounds(60,60,200,40);
			
			rec[i].setLayout(null);
			rec[i].add(log);
			rec[i].add(iconrec);
			rec[i].add(stime);
			rec[i].add(sdate);
			//con[i].add(b[i]);
		}
		
	}
	
	public static String timeNow() 
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
		return sdf.format(cal.getTime());
	}
	
	public static String dateNow() 
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
		return sdf.format(cal.getTime());
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
	    
	  if(source == contactsb) 
	  {
		//contacts b = new contacts();
	    //setVisible(false);
		
		
	  }
	  if(source == callb && s.length() > 0) 
	  {
		
		
		try { Thread.sleep(500); } 
		catch ( Exception e1 ) { } 
		
		
		new call();
		
		String s1,s2,s3;
		s1 = s;
		s2 = phone.dateNow();
		s3 = phone.timeNow();
		try
		{
			addto(s1,s2,s3);
		}
		catch(IOException ex){}

		dispose();
		
	  }
	 
	  jt.setText(s);
	  Global.s1 = s;
	}
	
	public void addto(String s1,String s2,String s3) throws IOException
	{
		BufferedWriter in=new BufferedWriter(new FileWriter("recents.dat",true));
		in.write(s1);
		in.newLine();
		in.write(s2);
		in.newLine();
		in.write(s3);
		in.newLine();
		in.close();
	}
	
}

