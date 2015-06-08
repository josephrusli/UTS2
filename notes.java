import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Calendar;
import javax.sound.sampled.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
class notes extends JFrame implements ActionListener
{
	JPanel jpNotes,jpTitle;
	JTextArea s1 = new JTextArea();
	JScrollPane jsp; 
	JFrame info;
	JButton add,back,save;
	JLabel labName = new JLabel();
	String[] sNotes = new String[100];
	JPanel[] not = new JPanel[100];
	JButton[] b = new JButton[100];
	status status = new status();
	public static int count = 0;
	int temp;
	public notes()
	{
		setTitle("Notes");
		setSize(480,720);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);	
		jpNotes = new JPanel();

		jpTitle = new JPanel()
		{
				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					ImageIcon icon = new ImageIcon ( "pic//notesTitle.png" );
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
		
		jsp = new JScrollPane(jpNotes);
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
		if(source == add)
		{
			dispose();	
			new newNote();
		}
		if(source == back)
		{
			s1.setText("");
			info.dispose();
			new notes();
		}
		if(source == save)
		{
			try
			{
				clear(temp);
				addto(s1.getText(),temp);
			}
			catch(IOException ex){}
			
			s1.setText("");
			info.dispose();
			new notes();
		}
		for(int i=0;i<100;i++)
		{
			if(source == b[i])
			{
				temp = i;
				info = new JFrame();
				info.setTitle("Notes");
				info.setSize(480,720);
				info.setLocationRelativeTo(null);
				info.setResizable(false);
				info.setLayout(null);

				try 
				{
                    BufferedReader br = new BufferedReader(new FileReader("notes\\notes_"+i+".dat"));
					Scanner scan = new Scanner(br);
                    while (scan.hasNext())
                    s1.append(scan.nextLine() + "\n");
                } 
				catch (Exception ex) {}
				
			
				Font f = new Font("Arial", Font.BOLD,30);
				s1.setFont(f);
				
				JPanel infoTitle = new JPanel()
				{
					protected void paintComponent(Graphics g)
					{
						super.paintComponent(g);
						ImageIcon icon = new ImageIcon ( "pic//infonote.png" );
						g.drawImage(icon.getImage (), -5, 0, null);
					}
				};
				
				back = new JButton();
				back.setContentAreaFilled(false);
				back.addActionListener(this);
				
				save = new JButton();
				save.setContentAreaFilled(false);
				save.addActionListener(this);
				
				infoTitle.setLayout(null);
				back.setBounds(2,10,80,45);
				save.setBounds(397,10,72,45);
				infoTitle.add(back);
				infoTitle.add(save);
				
				status.setBounds(0,0,480,30);
				infoTitle.setBounds(0,30,480,65);
				s1.setBounds(0,95,480,590);
				
				info.add(status);
				info.add(infoTitle);
				info.add(s1);

				info.setVisible(true);
				dispose();
			}
		}
	}
	
	
	public void addto(String s1,int i) throws IOException
	{
		BufferedWriter in=new BufferedWriter(new FileWriter("notes\\notes_"+i+".dat",true));
		in.write(s1);
		in.close();
	}
	
	
	public void clear(int i) throws IOException
	{
		FileOutputStream writer = new FileOutputStream("notes\\notes_"+i+".dat");
	}
	
	
	public void display() throws IOException
	{
		FilenameFilter filter = new FilenameFilter() 
		{
			public boolean accept(File dir, String name)
			{
				return name.endsWith(".dat");
			}
		};

		File folder = new File("notes");
		File[] listOfFiles = folder.listFiles(filter);
		count = listOfFiles.length;

		for(int i=0;i<count;i++)
		{
			BufferedReader br = new BufferedReader(new FileReader("notes\\notes_"+i+".dat"));
			String str4;
			str4 = br.readLine();
			sNotes[i]=str4;
		}	
	
	jpNotes.setLayout(new GridLayout(count,1));
		for (int i = count-1;i>=0;i--) 
		{
			not[i] = new JPanel()
			{
				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					g.setColor(new Color(50, 50, 50, 50));
					g.drawLine(0,99,480,99);
					repaint();
				}
			};
			not[i].setPreferredSize(new Dimension(455,100));
			not[i].setBackground(Color.WHITE);
			jpNotes.add(not[i]);
		}
		
		for(int i=0;i<count;i++)
		{
			labName = new JLabel();
			labName.setFont(new Font("Arial", Font.PLAIN,40));
			labName.setText(sNotes[i]);
			b[i] = new JButton();
			b[i].setContentAreaFilled(false);
			b[i].addActionListener(this);
			b[i].setBorderPainted(false);
			
			not[i].setLayout(null);
			labName.setBounds(50,30,400,50);
			b[i].setBounds(0,0,455,100);
			not[i].add(labName);
			not[i].add(b[i]);
		}

	}
}

class newNote extends JFrame implements ActionListener
{
	JPanel jpTitle;
	JButton done,cancel;
	JTextArea sNote;
	JScrollPane jsp;
	status status = new status();
	public newNote()
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
					ImageIcon icon = new ImageIcon ( "pic//newnoteTitle.png" );
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
		done.setBounds(398,10,77,43);
		cancel.setBounds(5,10,83,43);
		jpTitle.add(done);
		jpTitle.add(cancel);
		
		Font f = new Font("Arial", Font.BOLD,30);
		sNote = new JTextArea();
		sNote.setFont(f);
		//sNote.setBounds(0,95,480,590);
		jsp = new JScrollPane(sNote);
		
		status.setBounds(0,0,480,30);
		jpTitle.setBounds(-2,30,480,65);
		jsp.setBounds(0,95,480,590);

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
			dispose();
			new notes();
		}
		if(source == done && sNote.getText().length() > 0)
		{
			String s1;
			s1 = sNote.getText();
			try
			{
				addto(s1);
			}
			catch(IOException ex){}
	
			dispose();
			new notes();
		}
	}
	
	public void addto(String s1) throws IOException
	{
		BufferedWriter in=new BufferedWriter(new FileWriter("notes\\notes_"+notes.count+".dat",true));
		in.write(s1);
		in.close();
	}
	
}

