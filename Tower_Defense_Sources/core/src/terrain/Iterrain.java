package terrain;

import terrain.Coordonnees;


public interface Iterrain {


	public boolean ameliorerTour(/* amelioration ModeleTourelle,*/ Coordonnees<Float,Float> position  );
	
	public boolean creerTour(/*tour ModeleTourelle,*/ Coordonnees<Float,Float> position);
	
	public boolean vendreTour( Coordonnees<Float,Float> position);
}
