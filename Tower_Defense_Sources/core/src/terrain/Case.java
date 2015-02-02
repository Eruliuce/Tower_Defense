package terrain;
import java.util.ArrayList;
public class Case implements CaseAlgo{

private Coordonnees<Integer,Integer> position;	

boolean traversable=true;

public Case (int x,int y){
	position=new Coordonnees<Integer,Integer>(x,y);
    	
}

public Case(Coordonnees<Integer,Integer> c){
	position = c;
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