package terrain;

import Tourelle.ModeleTourelle;
import Outils.Coordonnees;


public interface Iterrain {


	public boolean ameliorerTour(/* amelioration ModeleTourelle,*/ Coordonnees<Integer,Integer> position  );
	
	public void creerTour(ModeleTourelle tour ,  Coordonnees<Integer,Integer> position);
	
	public boolean vendreTour( Coordonnees<Integer,Integer> position);
}
