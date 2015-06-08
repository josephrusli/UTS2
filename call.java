import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;
import java.text.SimpleDateFormat;
import java.util.*;

class call extends JFrame implements ActionListener
	{
		Clip clip;
		JButton back;
		JPanel jpCall,jpEnd;
		JButton end;
		JLabel jl;
	
		Font f = new Font("Arial", Font.BOLD,65);
		public call() 
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
				
				new phone();
			}
		}
		
		
	}
	
	
	