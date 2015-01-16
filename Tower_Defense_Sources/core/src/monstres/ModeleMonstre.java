package monstres;
public class ModeleMonstre {
	private String name;
	private Integer pv;
	private Integer vitesse;
	private String image;
	private Integer attaque;
	private Integer recompense;
	private Integer cout;
	private Boolean invisible;
	private Boolean volant;	
		
	public ModeleMonstre(String name, Integer pv, Integer vitesse, String image, Integer attaque, Integer recompense, Integer cout, Boolean invisible, Boolean volant) {
		this.name = name;
		this.pv = pv;
		this.vitesse = vitesse;
		this.image = image;
		this.attaque = attaque;
		this.recompense = recompense;
		this.cout = cout;
		this.invisible = invisible;
		this.volant = volant;
	}

	public String getName() {
		return name;
	}
	public Integer getPv() {
		return pv;
	}
	public Integer getVitesse() {
		return vitesse;
	}
	public String getImage() {
		return image;
	}
	public Integer getAttaque() {
		return attaque;
	}
	public Integer getRecompense() {
		return recompense;
	}
	public Integer getCout() {
		return cout;
	}
	public Boolean getInvisible() {
		return invisible;
	}
	public Boolean getVolant() {
		return volant;
	}	
}
