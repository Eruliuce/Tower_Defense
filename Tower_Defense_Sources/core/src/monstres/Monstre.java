package monstres;
public class Monstre extends MonstreAbstrait {
	private String name;
	private Integer pv;
	private Integer vitesse;
	private String image;
	private Integer attaque;
	private Integer recompense;
	private Integer cout;
	private Boolean invisible;
	private Boolean volant;	
	
	Monstre(ModeleMonstre MM) {
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
	
	public void mourrir(){
		try {
			finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deplacer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seFaireAttaquer() {
		// TODO Auto-generated method stub
		
	}
}
