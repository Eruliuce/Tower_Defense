package terrain;
import java.util.Collection;


public interface TerrainAlgo {

	public CaseAlgo getBase();

	public CaseAlgo getSpawn();
	
	public int nbCases();

	public int numCase(CaseAlgo caseQuelconque) throws CaseNonTrouveeException;

	public Collection<Integer> voisinsTraversables(int numCase);

	public CaseAlgo caseNum(int indexOfMin);
}
