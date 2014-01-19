package ua.zhubulskij.controler;


import ua.zhubulskij.model.model;
import ua.zhubulskij.model.point;

public class controler {
	
	private model my_model;
	
	public controler(model my_model) {
		super();
		this.my_model = my_model;
	}
	
	public void click(int xx,int yy){
		
	
		
		
		
			if (Math.abs(my_model.getFocus().getX()-xx)<15){
				if (Math.abs(my_model.getFocus().getY()-yy)<15){					
				  	my_model.setCurrentpoint(my_model.getFocus());				  	
				  	return;				  	
				}				
			}
			
			if (Math.abs(my_model.getMy_Object().getPointObject().getX()-xx)<15){
				if (Math.abs(my_model.getMy_Object().getPointObject().getY()-yy)<15){					
				  	my_model.setCurrentpoint(my_model.getMy_Object().getPointObject());
				  	System.out.println("target");
				  	return;				  	
				}				
			}
			
			
		
		my_model.setCurrentpoint(null);		
	}	
	
	public void move(int xx,int yy){		
	    my_model.changepoint(xx, yy);		
	}
	
	
	
}
