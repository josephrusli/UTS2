import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Calendar;
import javax.sound.sampled.*;
class contacts extends JFrame implements ActionListener
{
	JPanel jpContacts,jpTitle;
	JScrollPane jsp; 
	JLabel title;
	JButton add;
	JPanel[] con = new JPanel[100];
	JLabel labName = new JLabel();
	String[] sName = new String[100];
	String[] sNumber = new String[100];
	JButton[] b = new JButton[100];
	JButton back,send,callbt;
	JFrame info;
	status status = new status();
	int count = 0;

	public contacts()
	{
		setTitle("Contacts");
		setSize(480,720);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		
		jpContacts = new JPanel();

		jpTitle = new JPanel()
		{
				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					ImageIcon icon = new ImageIcon ( "pic//title.png" );
					g.drawImage(icon.getImage (), -5, 0, null);
				}
		};
		add = new JButton();
		add.setContentAreaFilled(false);
		add.addActionListener(this);
		
		
		jpTitle.setLayout(null);
		add.setBounds(418,10,50,45);
		jpTitle.add(add);

		try{
		display();
		}
		catch(IOException e){}
		
		jsp = new JScrollPane(jpContacts);
		status.setBounds(0,0,480,30);
		jpTitle.setBounds(-2,30,480,65);
		jsp.setBounds(-5,95,480,590);
		add(status);
		add(jpTitle);
		add(jsp);
		validate();

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == back)
		{
			info.dispose();
			new contacts();
		}
		if(source == add)
		{
			dispose();
			new newContact();
		}
		for(int i=0;i<100;i++)
		{
			if(source == b[i])
			{
				info = new JFrame();
				info.setTitle("Info");
				info.setSize(480,720);
				info.setLocationRelativeTo(null);
				info.setResizable(false);
				info.setVisible(true);
				info.setLayout(null);
				final String s1 = sName[i];
				final String s2 = sNumber[i];
				JPanel infoTitle = new JPanel()
				{
					protected void paintComponent(Graphics g)
					{
						super.paintComponent(g);
						ImageIcon icon = new ImageIcon ( "pic//infoTitle.png" );
						g.drawImage(icon.getImage (), -5, 0, null);
						g.drawImage(new ImageIcon ( "pic//info.png" ).getImage (), -5, 60, null);
						g.setFont(new Font("Arial", Font.BOLD,40));
						g.drawString(s1,15,130);
						g.setFont(new Font("Arial", Font.PLAIN,35));
						g.drawString(s2,120,211);
						validate();
					}
				};
				
				back = new JButton();
				back.setContentAreaFilled(false);
				back.addActionListener(this);
				
				send = new JButton();
				send.setContentAreaFilled(false);
				send.addActionListener(this);
				
				callbt = new JButton();
				callbt.setContentAreaFilled(false);
				callbt.addActionListener(this);
	
				infoTitle.setLayout(null);
				back.setBounds(2,11,136,45);
				send.setBounds(12,273,201,62);
				callbt.setBounds(256,273,201,62);
				infoTitle.add(back);
				infoTitle.add(send);
				infoTitle.add(callbt);
				
				status.setBounds(0,0,480,30);
				infoTitle.setBounds(0,30,480,690);
				info.add(status);
				info.add(infoTitle);
				
				Global.s1 = s1;
				
				dispose();
			}
		}
		
		if(source == callbt)
		{
			try { Thread.sleep(500); } 
			catch ( Exception e1 ) { } 
			//dispose();
			new callContact();
		
			String s1,s2,s3;
			s1 = Global.s1;
			s2 = phone.dateNow();
			s3 = phone.timeNow();
			try
			{
				addto(s1,s2,s3);
			}
			catch(IOException ex){}
			}
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
	
	public void display() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("contacts.dat"));
		String str4 = br.readLine();
		while(str4!=null)
		{
			sName[count]=str4;
			str4=br.readLine();
			sNumber[count]=str4;
			str4=br.readLine();
			count++;
		}
		
		jpContacts.setLayout(new GridLayout(count,1));
		for (int i = 0;i<count;i++) 
		{
			con[i] = new JPanel()
			{
				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					g.setColor(new Color(50, 50, 50, 50));
					g.drawLine(50,99,455,99);
					repaint();
				}
			};
			con[i].setPreferredSize(new Dimension(455,100));
			con[i].setBackground(Color.WHITE);
			jpContacts.add(con[i]);
		}
		
		for(int i=0;i<count;i++)
		{
			labName = new JLabel();
			labName.setFont(new Font("Arial", Font.PLAIN,40));
			labName.setText(sName[i]);
			b[i] = new JButton();
			b[i].setContentAreaFilled(false);
			b[i].addActionListener(this);
			b[i].setBorderPainted(false);
			
			con[i].setLayout(null);
			labName.setBounds(50,30,400,50);
			b[i].setBounds(0,0,455,100);
			con[i].add(labName);
			con[i].add(b[i]);
		}

	}
	
}

class newContact extends JFrame implements ActionListener
{
	JPanel jpTitle;
	JButton done,cancel;
	JTextArea name,number;
	status status = new status();
	public newContact()
	{
		setSize(480,720);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setVisible(true);
		
		jpTitle = new JPanel()
		{
				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					ImageIcon icon = new ImageIcon ( "pic//newTitle.png" );
					g.drawImage(icon.getImage (), 0, 0, null);
					validate();
				}
		};
		done = new JButton();
		cancel = new JButton();
		done.setContentAreaFilled(false);
		done.addActionListener(this);
		cancel.setContentAreaFilled(false);
		cancel.addActionListener(this);
		
		jpTitle.setLayout(null);
		done.setBounds(395,12,78,43);
		cancel.setBounds(7,12,91,43);
		jpTitle.add(done);
		jpTitle.add(cancel);
		
		Font f = new Font("Arial", Font.BOLD,30);
		name = new JTextArea(1,20);
		number = new JTextArea(1,20);
		name.setFont(f);
		number.setFont(f);
		
		status.setBounds(0,0,480,30);
		jpTitle.setBounds(-2,30,480,65);
		name.setBounds(125,168,310,50);
		number.setBounds(125,260,310,50);
		
		add(status);
		add(jpTitle);
		add(name);
		add(number);
		validate();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		ImageIcon icon = new ImageIcon ( "pic//newContact.png" );
		g.drawImage(icon.getImage (), 0, 130, null);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
		if(source == cancel)
		{
			dispose();
			new contacts();
		}
		if(source == done && name.getText().length() > 0)
		{
			String sName,sNumber;
			sName = name.getText();
			sNumber = number.getText();
			try
			{
				addto(sName,sNumber);
			}
			catch(IOException ex){}
	
			dispose();
			new contacts();
		}
		
		
	}
	
	public void addto(String s1,String s2) throws IOException
	{
		BufferedWriter in=new BufferedWriter(new FileWriter("contacts.dat",true));
		in.write(s1);
		in.newLine();
		in.write(s2);
		in.newLine();
		in.close();
	}
	
}


class callContact extends JFrame implements ActionListener
	{
		Clip clip;
		JButton back;
		JPanel jpCall,jpEnd;
		JButton end;
		JLabel jl;
	
		Font f = new Font("Arial", Font.BOLD,65);
		public callContact() 
		{
			setTitle("Call");
			setSize(497,737); 
			setVisible(true);
			setLocationRelativeTo(null);
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
			end.addActionListener(this);
			end.setMargin(margin);
			
			JTextArea jt = new JTextArea(1,1);
			jt.setFont(f);
			jt.setOpaque(false);
			jt.setEditable(false);
			jt.setText(Global.s1);
			
			jpEnd.add(end);
			
		//	status status = new status();
			//add(status,BorderLayout.NORTH);
			add(end,BorderLayout.SOUTH);
			
			validate();
		}
		
		public void paint(Graphics g)
		{
			super.paint(g);
			ImageIcon icon = new ImageIcon ( "pic//tes.jpg" );
			g.drawImage(icon.getImage (), 10, 20, null);
			FontMetrics fm = g.getFontMetrics(f);
			int x = 0;
			x += fm.stringWidth(Global.s1);
			Color back = new Color(255, 255, 255, 100);
			g.setFont(f);
			g.setColor(back);
			g.drawString(Global.s1,240-(x/2),125);
			
			String s1 = "calling...";
			Font f1 = new Font("Corbel",Font.PLAIN,35);
			Color back1 = new Color(255, 255, 255, 100);
			g.setFont(f1);
			g.setColor(back1);
			g.drawString(s1,190,185);
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
