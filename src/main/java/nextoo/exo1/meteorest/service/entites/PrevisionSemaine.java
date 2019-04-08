package nextoo.exo1.meteorest.service.entites;

import java.util.ArrayList;

/**
 * @author liam
 */
public class PrevisionSemaine {

	private Ville ville;

	private PrevisionJour current;

	private PrevisionJour j0;
	
	private PrevisionJour j1;
	
	private PrevisionJour j2;
	
	private PrevisionJour j3;

	/**
	 * @return the ville
	 */
	public Ville getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(Ville ville) {
		this.ville = ville;
	}

	/**
	 * @return the current
	 */
	public PrevisionJour getCurrent() {
		return current;
	}

	/**
	 * @param current the current to set
	 */
	public void setCurrent(PrevisionJour current) {
		this.current = current;
	}

	/**
	 * @return the j0
	 */
	public ArrayList<PrevisionJour> getPrevisions() {
		ArrayList<PrevisionJour> previsions = new ArrayList<PrevisionJour>();
		previsions.add(j0);
		previsions.add(j1);
		previsions.add(j2);
		previsions.add(j3);
		return previsions;
	}

	public PrevisionJour getJ0() {
		return j0;
	}

	public void setJ0(PrevisionJour j0) {
		this.j0 = j0;
	}

	public PrevisionJour getJ1() {
		return j1;
	}

	public void setJ1(PrevisionJour j1) {
		this.j1 = j1;
	}

	public PrevisionJour getJ2() {
		return j2;
	}

	public void setJ2(PrevisionJour j2) {
		this.j2 = j2;
	}

	public PrevisionJour getJ3() {
		return j3;
	}

	public void setJ3(PrevisionJour j3) {
		this.j3 = j3;
	}
}
