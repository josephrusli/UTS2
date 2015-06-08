import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
//import javax.sound.sampled.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


class textmessage extends JFrame implements ActionListener
{
	JButton newmessage, inbox, sent, draft, home;
	JButton add,back,back2;
	JFrame info,info2;
	JPanel jpInbox,jpSent,jpDraft;
	JPanel jpInboxTitle,jpSentTitle,jpDraftTitle;
	JPanel jpi,jps,jpd;
	JScrollPane jspInbox,jspSent,jspDraft;
	JPanel[] inb = new JPanel[100];
	JPanel[] sen = new JPanel[100];
	JPanel[] dra = new JPanel[100];
	String[] sInbox = new String[100];
	String[] sSent = new String[100];
	String[] sDraft = new String[100];
	JButton[] in = new JButton[100];
	JButton[] se = new JButton[100];
	JButton[] dr = new JButton[100];
	JLabel labName;
	status status = new status();
	//Global.countInbox = 0;
	int tempInbox,tempSent,tempCount;
	public textmessage()
	{
		super("SMS");
		setSize(480,720);
		
		setResizable(false);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		
		jpInboxTitle = new JPanel();
		
		jpInboxTitle = new JPanel()
		{
				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					ImageIcon icon = new ImageIcon ( "pic//inboxTitle.png" );
					g.drawImage(icon.getImage (), 0, 0, null);
				}
		};
		
		jpInboxTitle.setLayout(null);
		jpInboxTitle.setBounds(0,0,480,65);
		
		add = new JButton();
		add.setContentAreaFilled(false);
		add.addActionListener(this);
		add.setBounds(413,10,50,45);
		jpInboxTitle.add(add);
		
		
		jpInbox = new JPanel();
		jpInbox.setLayout(null);
		jpInbox.add(jpInboxTitle);
		jpi = new JPanel();
		jpi.setBounds(0,65,480,590);
		jspInbox = new JScrollPane(jpi);
		jspInbox.setBounds(0,65,480,590);
		jpInbox.add(jspInbox);
		
		try{
		displayInbox();
		}
		catch(IOException e){}
		
		jpSentTitle = new JPanel();
		jpSentTitle.setLayout(null);
		JLabel sentTitle = new JLabel(new ImageIcon("pic//sentTitle.png"));
		sentTitle.setBounds(-3,0,480,65);
		jpSentTitle.add(sentTitle);
		jpSentTitle.setBounds(0,0,480,65);
		
		
		jpSent = new JPanel();
		jpSent.setLayout(null);
		jpSent.add(jpSentTitle);
		jps = new JPanel();
		jps.setBounds(0,65,480,518);
		jspSent = new JScrollPane(jps);
		jspSent.setBounds(0,65,477,518);
		jpSent.add(jspSent);
		
		
		try{
		displaySent();
		}
		catch(IOException e){}
		jpDraftTitle = new JPanel();
		jpDraftTitle.setLayout(null);
		JLabel draftTitle = new JLabel(new ImageIcon("pic//draftTitle.png"));
		draftTitle.setBounds(-3,0,480,65);
		jpDraftTitle.add(draftTitle);
		jpDraftTitle.setBounds(0,0,480,65);
		
		jspDraft = new JScrollPane(jpDraft);
		jpDraft = new JPanel();
		jpDraft.setLayout(null);
		jpDraft.add(jpDraftTitle);
		
		UIManager.put("TabbedPane.selected", Color.black);  
		UIManager.put("TabbedPane.background",Color.BLACK);
		UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
		UIManager.put("TabbedPane.tabAreaInsets", new Insets(0, 115, 0, 0));
		
		JTabbedPane tabs = new JTabbedPane ();
		tabs.addTab ("",new ImageIcon("pic//keypad.png"), jpInbox);
		tabs.addTab ("",new ImageIcon("pic//recent.png"), jpSent);
		tabs.addTab ("",new ImageIcon("pic//recent.png"), jpDraft);
		tabs.setTabPlacement(JTabbedPane.BOTTOM);
		
		status.setBounds(0,0,480,30);
		add(status);
		tabs.setBounds(-1,30,480,652);
		add(tabs);
		
		/*
		newmessage = new JButton("New Message");
		container.add(newmessage);
		inbox = new JButton("Inbox");
		container.add(inbox);
		sent = new JButton("Sent Messages");
		container.add(sent);
		draft = new JButton("Drafts");
		container.add(draft);
		home = new JButton("Home");
		container.add(home);
		
		newmessage.addActionListener(this);
		home.addActionListener(this);
		sent.addActionListener(this);
		draft.addActionListener(this);
		inbox.addActionListener(this);*/
		setVisible(true);
		validate();
	}
	
	
	public void displayInbox() throws IOException
	{
		FilenameFilter filter = new FilenameFilter() 
		{
			public boolean accept(File dir, String name)
			{
				return name.endsWith(".dat");
			}
		};

		File folder = new File("inbox");
		File[] listOfFiles = folder.listFiles(filter);
		Global.countInbox = listOfFiles.length;

		for(int i=0;i<Global.countInbox;i++)
		{
			BufferedReader br = new BufferedReader(new FileReader("inbox\\inbox_"+i+".dat"));
			String str4;
			str4 = br.readLine();
			sInbox[i]=str4;
		}	
	
		jpi.setLayout(new GridLayout(Global.countInbox,1));
		for (int i = Global.countInbox-1;i>=0;i--) 
		{
			inb[i] = new JPanel()
			{
				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					g.setColor(new Color(50, 50, 50, 50));
					g.drawLine(0,99,480,99);
					repaint();
				}
			};
			inb[i].setPreferredSize(new Dimension(455,100));
			inb[i].setBackground(Color.WHITE);
			jpi.add(inb[i]);
		}
		
		for(int i=0;i<Global.countInbox;i++)
		{
			labName = new JLabel();
			labName.setFont(new Font("Arial", Font.PLAIN,40));
			labName.setText(sInbox[i]);
			in[i] = new JButton();
			in[i].setContentAreaFilled(false);
			in[i].addActionListener(this);
			in[i].setBorderPainted(false);
			
			inb[i].setLayout(null);
			labName.setBounds(50,30,400,50);
			in[i].setBounds(0,0,455,100);
			inb[i].add(labName);
			inb[i].add(in[i]);
		}

	}

	public void displaySent() throws IOException
	{
		FilenameFilter filter = new FilenameFilter() 
		{
			public boolean accept(File dir, String name)
			{
				return name.endsWith(".dat");
			}
		};

		File folder = new File("sent");
		File[] listOfFiles = folder.listFiles(filter);
		Global.countSent = listOfFiles.length;

		for(int i=0;i<Global.countSent;i++)
		{
			BufferedReader br = new BufferedReader(new FileReader("sent\\sent_"+i+".dat"));
			String str4;
			str4 = br.readLine();
			sSent[i]=str4;
		}	
	
		jps.setLayout(new GridLayout(Global.countSent,1));
		for (int i = Global.countSent-1;i>=0;i--) 
		{
			sen[i] = new JPanel()
			{
				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					g.setColor(new Color(50, 50, 50, 50));
					g.drawLine(0,99,480,99);
					repaint();
				}
			};
			sen[i].setPreferredSize(new Dimension(455,100));
			sen[i].setBackground(Color.WHITE);
			jps.add(sen[i]);
		}
		
		for(int i=0;i<Global.countSent;i++)
		{
			labName = new JLabel();
			labName.setFont(new Font("Arial", Font.PLAIN,40));
			labName.setText(sSent[i]);
			se[i] = new JButton();
			se[i].setContentAreaFilled(false);
			se[i].addActionListener(this);
			se[i].setBorderPainted(false);
			
			sen[i].setLayout(null);
			labName.setBounds(50,30,400,50);
			se[i].setBounds(0,0,455,100);
			sen[i].add(labName);
			sen[i].add(se[i]);
		}

	}

	
	
	
	
	JTextArea s1 = new JTextArea();
	JTextArea from = new JTextArea();
	JTextArea from2 = new JTextArea();
	JTextArea s11 = new JTextArea();
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == add)
		{
			//new TextFieldTest();
			new newInbox();
			dispose();
		}
		if(source == back)
		{
			s1.setText("");
			info.dispose();
			new textmessage();
		}
		if(source == back2)
		{
			s11.setText("");
			info2.dispose();
			new textmessage();
		}
		for(int i=0;i<100;i++)
		{
			if(source == in[i])
			{
				tempInbox = i;
				info2 = new JFrame();
				info2.setTitle("");
				info2.setSize(480,720);
				info2.setLocationRelativeTo(null);
				info2.setResizable(false);
				info2.setLayout(null);

				try 
				{
                    BufferedReader br = new BufferedReader(new FileReader("inbox\\inbox_"+i+".dat"));
					Scanner scan = new Scanner(br);
					scan.nextLine();
                    while (scan.hasNext())
                    s11.append(scan.nextLine() + "\n");
                } 
				catch (Exception ex) {}
				
			
				Font f = new Font("Arial", Font.BOLD,30);
				s11.setFont(f);
				s11.setEditable(false);
				JPanel infoTitle = new JPanel()
				{
					protected void paintComponent(Graphics g)
					{
						super.paintComponent(g);
						ImageIcon icon = new ImageIcon ( "pic//infosent.png" );
						g.drawImage(icon.getImage (), -5, 0, null);
						g.drawImage((new ImageIcon ( "pic//from.png" )).getImage (), 0, 65, null);
					}
				};
				
				from2.setFont(new Font("Arial", Font.BOLD,24));
				from2.setText(sInbox[i]);
				from2.setEditable(false);
				from2.setBounds(88,74,370,30);
				
				back2 = new JButton();
				back2.setContentAreaFilled(false);
				back2.addActionListener(this);
				
				
				
				infoTitle.setLayout(null);
				back2.setBounds(10,10,70,45);
				infoTitle.add(back2);
				infoTitle.add(from2);
				
				//status.setBounds(0,0,480,30);
				infoTitle.setBounds(0,30,480,115);
				s11.setBounds(0,145,480,540);
				
				//info.add(status);
				info2.add(infoTitle);
				info2.add(s11);

				info2.setVisible(true);
				dispose();
			}
		}
		
		for(int i=0;i<100;i++)
		{
			if(source == se[i])
			{
				tempSent = i;
				info = new JFrame();
				info.setTitle("Sent");
				info.setSize(480,720);
				info.setLocationRelativeTo(null);
				info.setResizable(false);
				info.setLayout(null);

				try 
				{
                    BufferedReader br = new BufferedReader(new FileReader("sent\\sent_"+i+".dat"));
					Scanner scan = new Scanner(br);
					scan.nextLine();
                    while (scan.hasNext())
                    s1.append(scan.nextLine() + "\n");
                } 
				catch (Exception ex) {}
				
			
				Font f = new Font("Arial", Font.BOLD,30);
				s1.setFont(f);
				s1.setEditable(false);
				JPanel infoTitle = new JPanel()
				{
					protected void paintComponent(Graphics g)
					{
						super.paintComponent(g);
						ImageIcon icon = new ImageIcon ( "pic//infosent.png" );
						g.drawImage(icon.getImage (), -5, 0, null);
						g.drawImage((new ImageIcon ( "pic//to.png" )).getImage (), 0, 65, null);
					}
				};
				
				from.setFont(new Font("Arial", Font.BOLD,24));
				from.setText(sSent[i]);
				from.setEditable(false);
				from.setBounds(88,74,370,30);
				
				back = new JButton();
				back.setContentAreaFilled(false);
				back.addActionListener(this);
				
				
				
				infoTitle.setLayout(null);
				back.setBounds(10,10,70,45);
				infoTitle.add(back);
				infoTitle.add(from);
				
				//status.setBounds(0,0,480,30);
				infoTitle.setBounds(0,30,480,115);
				s1.setBounds(0,145,480,540);
				
				//info.add(status);
				info.add(infoTitle);
				info.add(s1);

				info.setVisible(true);
				dispose();
			}
		}
	}
	}

class newInbox extends JFrame implements ActionListener
{
	JPanel jpTitle;
	JButton send,cancel;
	JTextArea sNote;
	JScrollPane jsp;
	JTextArea to = new JTextArea();
	status status = new status();
	public newInbox()
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
					ImageIcon icon = new ImageIcon ( "pic//newTitle1.png" );
					g.drawImage(icon.getImage (), 0, 0, null);
					g.drawImage((new ImageIcon ( "pic//to.png" )).getImage (), 0, 65, null);
					validate();
				}
		};
		send = new JButton();
		cancel = new JButton();
		send.setContentAreaFilled(false);
		send.addActionListener(this);
		cancel.setContentAreaFilled(false);
		cancel.addActionListener(this);
		
		to.setFont(new Font("Arial", Font.BOLD,24));
		to.setBounds(88,74,370,30);
		
		jpTitle.setLayout(null);
		send.setBounds(392,10,74,44);
		cancel.setBounds(10,10,84,44);
		
		jpTitle.add(send);
		jpTitle.add(cancel);
		jpTitle.add(to);
		
		Font f = new Font("Arial", Font.BOLD,30);
		sNote = new JTextArea();
		sNote.setFont(f);
		//sNote.setBounds(0,95,480,590);
		jsp = new JScrollPane(sNote);
		
		status.setBounds(0,0,480,30);
		jpTitle.setBounds(-2,30,480,115);
		jsp.setBounds(0,145,477,534);

		add(status);
		add(jpTitle);
		add(jsp);
		//add(sNote);
		validate();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
		if(source == cancel)
		{
			
			new textmessage();
			dispose();
		}
		if(source == send && sNote.getText().length() > 0)
		{
			String s1,s2;
			s2 = sNote.getText();
			s1 = to.getText();
			try
			{
				addto(s1,s2);
				random();
			}
			catch(IOException ex){}
	
			
			new textmessage();
			dispose();
		}
	}
	
	public void addto(String s1,String s2) throws IOException
	{
		BufferedWriter in = new BufferedWriter(new FileWriter("sent\\sent_"+Global.countSent+".dat",true));
		in.write(s1);
		in.newLine();
		in.write(s2);
		in.close();
	}
	
	
	public void random() throws IOException
	{
		int d = (int)(Math.random()*6) + 1;
		String ss1;
		JTextArea ss2 = new JTextArea();
		ss1 = to.getText();
		
			
		
			if(d == 1)
			{
				BufferedWriter in = new BufferedWriter(new FileWriter("inbox\\inbox_"+Global.countInbox+".dat",true));
				in.write(ss1);
				in.newLine();
				in.write("Who are you ??");
				in.close();
				BufferedReader br = new BufferedReader(new FileReader("inbox\\inbox_"+Global.countInbox+".dat"));
				Scanner scan = new Scanner(br);
				scan.nextLine();
				while (scan.hasNext())
				ss2.append(scan.nextLine() + "\n");
				br.close();
			
			}
			else if(d==2)
			{
				BufferedWriter in = new BufferedWriter(new FileWriter("inbox\\inbox_"+Global.countInbox+".dat",true));
				in.write(ss1);
				in.newLine();
				in.write("hello??");
				in.close();
				BufferedReader br = new BufferedReader(new FileReader("inbox\\inbox_"+Global.countInbox+".dat"));
				Scanner scan = new Scanner(br);
				scan.nextLine();
				while (scan.hasNext())
				ss2.append(scan.nextLine() + "\n");
				br.close();
			}
			else if(d==3)
			{
				BufferedWriter in = new BufferedWriter(new FileWriter("inbox\\inbox_"+Global.countInbox+".dat",true));
				in.write(ss1);
				in.newLine();
				in.write("Stop texting me!!");
				in.close();
				BufferedReader br = new BufferedReader(new FileReader("inbox\\inbox_"+Global.countInbox+".dat"));
				Scanner scan = new Scanner(br);
				scan.nextLine();
				while (scan.hasNext())
				ss2.append(scan.nextLine() + "\n");
				br.close();
			}
			else if(d==4)
			{
				BufferedWriter in = new BufferedWriter(new FileWriter("inbox\\inbox_"+Global.countInbox+".dat",true));
				in.write(ss1);
				in.newLine();
				in.write("Do i know you ??");
				in.close();
				BufferedReader br = new BufferedReader(new FileReader("inbox\\inbox_"+Global.countInbox+".dat"));
				Scanner scan = new Scanner(br);
				scan.nextLine();
				while (scan.hasNext())
				ss2.append(scan.nextLine() + "\n");
				br.close();
			}
			else if(d==5)
			{
				BufferedWriter in = new BufferedWriter(new FileWriter("inbox\\inbox_"+Global.countInbox+".dat",true));
				in.write(ss1);
				in.newLine();
				in.write("Hi!!");
				in.close();
				BufferedReader br = new BufferedReader(new FileReader("inbox\\inbox_"+Global.countInbox+".dat"));
				Scanner scan = new Scanner(br);
				scan.nextLine();
				while (scan.hasNext())
				ss2.append(scan.nextLine() + "\n");
				br.close();
			}
			else if(d==6)
			{
				BufferedWriter in = new BufferedWriter(new FileWriter("inbox\\inbox_"+Global.countInbox+".dat",true));
				in.write(ss1);
				in.newLine();
				in.write("Hi...");
				in.close();
				BufferedReader br = new BufferedReader(new FileReader("inbox\\inbox_"+Global.countInbox+".dat"));
				Scanner scan = new Scanner(br);
				scan.nextLine();
				while (scan.hasNext())
				ss2.append(scan.nextLine() + "\n");
				br.close();
			}
			
				//try{
				//addtoInbox(ss1,ss2.getText());
			//}
			//catch(IOException e){}
	}
	}