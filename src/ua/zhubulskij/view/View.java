package ua.zhubulskij.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import ua.zhubulskij.model.Object;
import ua.zhubulskij.model.model;
import ua.zhubulskij.model.point;

public class View extends JPanel {
	
	private model my_Model;

	public View(model my_Model) {
		super();
		this.my_Model = my_Model;
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D  d=(Graphics2D)(arg0);
		d.setColor(new Color(0,124,125,125));
		
		
		if (my_Model.getFocus()==null){
			my_Model.setFocus(new point(this.getWidth()/3,this.getHeight()/2));
			my_Model.setAntifocus(new point(this.getWidth()-this.getWidth()/3,this.getHeight()/2));
			
		}
		else{
			
			my_Model.getFocus().setY(this.getHeight()/2);
		}
			
		
		
		
		
		
	
		

	
		int h=15;
		
	   
	    if (my_Model.getMy_Object()==null){
	    	my_Model.setMy_Object(new Object(new point(this.getWidth()/10,this.getHeight()/2-this.getHeight()/2/20*h)));
	    	System.out.println("null");
	    	
	    }else{
	    	//my_Model.getMy_Object().getPointObject().setX(this.getWidth()/10);
	    	my_Model.getMy_Object().getPointObject().setY(this.getHeight()/2-this.getHeight()/2/20*h);
	    }

		
		
	    d.setStroke(new BasicStroke(5));
		d.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
		
		d.setStroke(new BasicStroke(30));
		
		d.drawLine(my_Model.getMy_Object().getPointObject().getX(), my_Model.getMy_Object().getPointObject().getY(), 
				   my_Model.getMy_Object().getPointObject().getX(), this.getHeight()/2-h/Math.abs(h)*15);
		
		d.drawLine(this.getWidth()/2,0, 
				   this.getWidth()/2,this.getHeight());
		
		
		Ellipse2D.Double circle;
		circle=new Ellipse2D.Double(my_Model.getFocus().getX()-15,my_Model.getFocus().getY()-15,30,30);
		d.fill(circle);
		circle=new Ellipse2D.Double(my_Model.getMy_Object().getPointObject().getX()-15,
				                    my_Model.getMy_Object().getPointObject().getY()-15,30,30);
		d.fill(circle);
		
		circle=new Ellipse2D.Double(this.getWidth()-my_Model.getFocus().getX()-15,my_Model.getFocus().getY()-15,30,30);
		d.fill(circle);
		my_Model.getAntifocus().setX(this.getWidth()-my_Model.getFocus().getX());
		my_Model.getAntifocus().setY(my_Model.getFocus().getY());
		
		
		d.setStroke(new BasicStroke(2));
		
		
		
		int x1=my_Model.getFocus().getX();
		int y1= my_Model.getFocus().getY();
		int x0=my_Model.getMy_Object().getPointObject().getX();
		int y0=my_Model.getMy_Object().getPointObject().getY();
		
		int dx=Math.abs(x1-x0);
		int dy=y1-y0;
		int i=1;
		while (x1<this.getWidth()/2){
			
		i++;
		if (i>1e+6)
			break;
		x1=(int) (x0+i*0.005*dx);
		y1=(int) (y0+i*0.005*dy);
		
		}
		d.drawLine(x0,y0, x1,y1);
		d.drawLine(x0,y0,(int) (x1+0.05*dx),(int)(y1+0.05*dy));
		
		d.drawLine(x1, y1, 10000, y1);
			
		
		
	
		
		
		
		
		
		
		d.drawLine(this.getWidth()/2, my_Model.getMy_Object().getPointObject().getY(), 
				   my_Model.getMy_Object().getPointObject().getX(),my_Model.getMy_Object().getPointObject().getY());
		
		
		 x1=this.getWidth()/2;
		 y1= this.getHeight()/2;
		 x0=my_Model.getMy_Object().getPointObject().getX();
		 y0=my_Model.getMy_Object().getPointObject().getY();
		
		 d.drawLine(x0,y0, x1+100*(x1-x0),y1+100*(y1-y0));
		 
		 x1=my_Model.getAntifocus().getX();
		 y1= my_Model.getAntifocus().getY();
		 x0=this.getWidth()/2;
		 y0=my_Model.getMy_Object().getPointObject().getY();
		 

		 dx=Math.abs(x1-x0);
		 dy=y1-y0;
		
	     i=1;
			while (x1<this.getWidth()){
				
			i++;
			x1=(int) (x0+i*0.05*dx);
			y1=(int) (y0+i*0.05*dy);
			
			}
			d.drawLine(x0,y0, x1,y1);
			d.drawLine(x0,y0,(int) (x1+0.05*dx),(int)(y1+0.05*dy));
			
			d.drawLine(x1, y1, 10000, y1);
		
		
	    
		
		
		
	}
	
}
