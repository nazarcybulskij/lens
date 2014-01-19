package ua.zhubulskij.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class model {
	
	private JPanel my_view;
	private point currentpoint=null;
	private point focus=null;
	private point antifocus=null;
	
	
	public point getAntifocus() {
		return antifocus;
	}

	public void setAntifocus(point antifocus) {
		this.antifocus = antifocus;
	}



	private Object my_Object=null;
	private Lins my_lins;
	
	
	public point getFocus() {
		return focus;
	}

	public void setFocus(point focus) {
		this.focus = focus;
	}

	public Object getMy_Object() {
		return my_Object;
	}

	public void setMy_Object(Object my_Object) {
		this.my_Object = my_Object;
	}



	public point getCurrentpoint() {
		return currentpoint;
	}

	public void setCurrentpoint(point currentpoint) {
		this.currentpoint = currentpoint;
	}

	public JPanel getMy_view() {
		return my_view;
	}

	public void setMy_view(JPanel my_view) {
		this.my_view = my_view;
		
		
		
	
	}


	public  model() {
		super();
	}


	
	public  void changepoint(int x,int y){
		if (currentpoint!=null){
			
				if (x<this.my_view.getWidth()/2){
					currentpoint.setX(x);
					my_view.repaint();
					return;
				}
			
			my_view.repaint();
		}	
		
	}

}
