package monstres;

import terrain.Case;
import Jeu.Joueur;
import Outils.Coordonnees;
import Tourelle.Tourelle;

public class Monstre extends MonstreAbstrait {
	public final static int PRIXMONSTRE = 30;
	
	private String name;
	private Integer pv;
	private Integer vitesse;
	private String image;
	private Integer attaque;
	private Integer recompense;
	private Integer cout;
	private Boolean invisible;
	private Boolean volant;
	private Case saCase;
	private Coordonnees<Integer, Integer> position;
	
	public Coordonnees<Integer, Integer> getPosition() {
		return position;
	}
	public Monstre(int x, int y){
		position = new Coordonnees<Integer,Integer>(x,y);
	}
	public Monstre(ModeleMonstre MM) {
		name = MM.getName();
		pv = MM.getPv();
		vitesse = MM.getVitesse();
		image = MM.getImage();
		attaque = MM.getAttaque();
		recompense = MM.getRecompense();
		cout = MM.getCout();
		invisible = MM.getInvisible();
		volant = MM.getVolant();
	}
	public Monstre(int x, int y, ModeleMonstre mm){
		position = new Coordonnees<Integer,Integer>(x,y);
		name = mm.getName();
		pv = mm.getPv();
		vitesse = mm.getVitesse();
		image = mm.getImage();
		attaque = mm.getAttaque();
		recompense = mm.getRecompense();
		cout = mm.getCout();
		invisible = mm.getInvisible();
		volant = mm.getVolant();
	}
	
	public void mourir(){
		try {
			finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Integer getPv() {
		return pv;
	}
	public void setPv(Integer pv) {
		this.pv = pv;
	}
	/**
	 * vérifie si la tour peut attaquer le monstre
	 * @author BlackNichols
	 * @param tour : tour attaquante
	 * @return booleen : oui/non
	 */
	public boolean attaquable(Tourelle tour){
		return checkVolant(tour) && checkInvisible(tour);
	}
	
	/**
	 * vérifie si la tour peut attaquer vis à vis du paramètre visible/invisible du monstre
	 * @author BlackNichols
	 * @param tour : tour attaquante
	 * @return booleen : oui/non
	 */
	private boolean checkInvisible(Tourelle tour) {
		return !invisible || saCase.isInvisibleAdecouvert();
	}
	/**
	 * vérifie si la tour peut attaquer vis à vis du paramètre volant/terrestre du monstre
	 * @author BlackNichols
	 * @param tour : tour attaquante
	 * @return booleen : oui/non
	 */
	private boolean checkVolant(Tourelle tour) {
		return !volant || tour.isAntiAerien();
	}

	@Override
	public void deplacer() {
		int deplacementRestant = vitesse;
		while (deplacementRestant > 0){
			Case caseSuivante = saCase.getCaseCheminSuivante();
			if(!caseSuivante.equals(null)){
				saCase.retirerMonstre(this);
				caseSuivante.ajoutMonstre(this);
				position =	caseSuivante.getpos();
			}else{
				Joueur.perdreVies(attaque);
				mourir();
			}
		}
	}

	@Override
	public void seFaireAttaquer(Tourelle tour) {
		// TODO Auto-generated method stub
		this.pv+=tour.getDegat();
		if (this.pv <= 0)
		{
			this.mourir();
		}
		
	}
}
