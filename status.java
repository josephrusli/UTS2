import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;
import java.text.SimpleDateFormat;
import java.util.*;


class status extends JPanel 
{
	public status()
	{
		JLabel dateTime = new JLabel();
		JPanel time = new JPanel();
		dateTime.setForeground(Color.WHITE);
		dateTime.setText(phone.timeNow());
		setPreferredSize( new Dimension( 480, 30 ) );
		time.setBackground(Color.BLACK);
		time.add(dateTime);
		setLayout(new GridLayout(1,1));
		add(time);
		//add(jp2,BorderLayout.NORTH);
		validate();
	
	}
	public static String timeNow() 
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
		return sdf.format(cal.getTime());
	}
 
	public void paint(Graphics g)
	{
		ImageIcon icon = new ImageIcon ( "pic//car.png" );
		//g.drawImage(icon.getImage (), 0, 190, null);
	}
	
	
}

