package terrain;

import terrain2.CaseAlgo;
import terrain2.Coordonnees;


public class Case implements CaseAlgo{

public Coordonnees<Float,Float> position;	


public Case (float x,float y){
	position=new Coordonnees<Float,Float>(x,y);
	
	//Casevoisine[][]=
	
}


@Override
public int cout() {
	return 1;
}	

	
	
	
}
