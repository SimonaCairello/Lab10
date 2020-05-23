package it.polito.tdp.bar.model;

public class Tavolo implements Comparable<Tavolo>{

	private int numPosti;

	public Tavolo(int numPosti) {
		this.numPosti = numPosti;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numPosti;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		if (numPosti != other.numPosti)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tavolo [numPosti=" + numPosti + "]";
	}
	
	public int compareTo(Tavolo t) {
		return t.getNumPosti()-this.numPosti;
	}
	
}
