package it.polito.tdp.bar.model;

public class Model {
	
	private Simulator sim;
	
	public Model() {
		this.sim = new Simulator();
	}
	
	public void run() {
		sim.run();
	}
	
	public Statistiche getStatistiche() {
		return sim.getStatistiche();
	}
	

}
