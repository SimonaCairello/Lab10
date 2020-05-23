package it.polito.tdp.bar.model;

public class Statistiche {
	
	private Integer numero_totale_clienti;
	private Integer numero_clienti_soddisfatti;
	private Integer numero_clienti_insoddisfatti;
	
	public Statistiche(Integer numero_totale_clienti, Integer numero_clienti_soddisfatti, Integer numero_clienti_insoddisfatti) {
		this.numero_totale_clienti = numero_totale_clienti;
		this.numero_clienti_soddisfatti = numero_clienti_soddisfatti;
		this.numero_clienti_insoddisfatti = numero_clienti_insoddisfatti;
	}

	public Integer getNumero_totale_clienti() {
		return numero_totale_clienti;
	}

	public void setNumero_totale_clienti(Integer numero_totale_clienti) {
		this.numero_totale_clienti = numero_totale_clienti;
	}

	public Integer getNumero_clienti_soddisfatti() {
		return numero_clienti_soddisfatti;
	}

	public void setNumero_clienti_soddisfatti(Integer numero_clienti_soddisfatti) {
		this.numero_clienti_soddisfatti = numero_clienti_soddisfatti;
	}

	public Integer getNumero_clienti_insoddisfatti() {
		return numero_clienti_insoddisfatti;
	}

	public void setNumero_clienti_insoddisfatti(Integer numero_clienti_insoddisfatti) {
		this.numero_clienti_insoddisfatti = numero_clienti_insoddisfatti;
	}
	
	public void incrementaNumTotClienti(Integer i) {
		this.numero_totale_clienti += i;
	}
	
	public void incrementaNumClSoddisfatti(Integer i) {
		this.numero_clienti_soddisfatti += i;
	}
	
	public void incrementaNumClInsoddisfatti(Integer i) {
		this.numero_clienti_insoddisfatti += i;
	}

}
