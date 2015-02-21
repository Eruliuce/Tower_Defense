package ZoneAttaqueTourelle;
import java.util.ArrayList;

import terrain.CaseAlgo;
import Tourelle.Tourelle;

public abstract class ZoneAttaqueTourelle {
	protected float zone;
	protected Tourelle saTourelle;
	
	
	protected abstract ArrayList<CaseAlgo> getCasesZone();
	public abstract boolean caseDansLaZone(CaseAlgo caseTester);
	
}
