package ua.zhubulskij.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import ua.zhubulskij.controler.controler;
import ua.zhubulskij.model.model;
import ua.zhubulskij.view.View;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main_form {
	private JPanel my_panel;
	private model my_model;//=new model(my_panel);

	private JFrame frame;
	private controler my_controler;//=new controler(my_model);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_form window = new main_form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main_form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				my_panel.repaint();
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);		
		my_model=new model();
		my_panel = new View(my_model);		
		my_model.setMy_view(my_panel);
		my_controler=new controler(my_model);	
		my_panel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				my_controler.click(arg0.getX(),arg0.getY());
		
				
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("clicked"+arg0.getX()+":"+arg0.getY());
				
			}
		});
		my_panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
				
			}
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				my_controler.move(arg0.getX(), arg0.getY()); 
				
				// rotare function 
				float deltaX=arg0.getX()-100;
				float deltaY=arg0.getY()-100;
				int result=(int)(360+Math.toDegrees(Math.atan2(deltaY,deltaX)))%360;
				
				// Warning !!!!
				
				
			}
		});
		
	
		frame.getContentPane().add(my_panel, BorderLayout.CENTER);
	}

}
