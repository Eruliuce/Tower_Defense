package Outils;
import java.util.List;

public class ModeleCase{
	protected int indCasePrec;
	protected int distance;
	protected boolean parcouru;
	public ModeleCase() {
		super();
		this.distance = Integer.MAX_VALUE;
		this.parcouru = false;
		indCasePrec = -1;
	}
	public ModeleCase(int i, boolean b) {
		this.distance = i;
		this.parcouru = b;
		indCasePrec = -1;
	}
}
