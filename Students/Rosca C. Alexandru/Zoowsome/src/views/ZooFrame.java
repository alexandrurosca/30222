package views;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import services.factories.Constants;
import views.utilities.FrameStack;

public abstract class ZooFrame extends JFrame implements ZooFrame_I {
	
	public void goBack(){
	}
	
	protected JPanel contentPanel; 
	 
	 
 	public ZooFrame(String title) {  	 	
 		FrameStack.getInstance().push(this);  	 	
 		setTitle(title); 
 	 	setSize(Constants.FRAMES.WIDTH, Constants.FRAMES.HEIGHT);  	 	
 	 	setLayout(new BorderLayout());  	 	
 	 	setLocationRelativeTo(null); 
 	 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  	 	
 	 	contentPanel = new JPanel(); 
 	 	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));  	 	
 	 	contentPanel.setBackground(Color.red);  	 	
 	 	add(contentPanel, BorderLayout.CENTER); 
 	} 
 
 	public void setBackButtonActionListener(ActionListener a) {  	 	
 		JPanel buttonPanel = new JPanel(); 
 	 	buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  	 	
 	 	JButton backButton = new JButton("Back");  	 	
 	 	buttonPanel.add(backButton);  	 	
 	 	this.add(buttonPanel, BorderLayout.NORTH); 
 	 	backButton.addActionListener(a); 
 	} 
} 


