package terrain;
import java.util.ArrayList;
public class Case implements CaseAlgo{

private Coordonnees<Float,Float> position;	

boolean traversable=true;

public Case (float x,float y){
	position=new Coordonnees<Float,Float>(x,y);
    	
}
public Coordonnees getpos(){
	
	return position;
}



public boolean gettraversable(){
	return traversable;
	 
}
 public void settraversable(boolean t){
	traversable=t; 
	 
 }

public int cout() {
	return 1;
}	

	
	
	
}