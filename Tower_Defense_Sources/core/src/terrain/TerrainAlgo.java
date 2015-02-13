package terrain;
import java.util.Collection;


public interface TerrainAlgo {

	public int getNumBase();

	public int getNumSpawn();
	
	public int nbCases();

	//public int numCase(CaseAlgo caseQuelconque) throws CaseNonTrouveeException;

	public Collection<Integer> voisinsTraversables(int numCase);

	public int coutCaseNum(int indexOfMin);
}
