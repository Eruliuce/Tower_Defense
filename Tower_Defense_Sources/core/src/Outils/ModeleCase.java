package Outils;

public class ModeleCase{
	protected int indCasePrec;
	protected int indCase;
	protected int distance;
	protected boolean parcouru;
	public ModeleCase(int numCase) {
		super();
		this.distance = Integer.MAX_VALUE;
		this.parcouru = false;
		indCase = numCase;
		indCasePrec = -1;
	}
	public ModeleCase(int i, boolean b) {
		this.distance = i;
		this.parcouru = b;
		indCasePrec = -1;
	}
}
