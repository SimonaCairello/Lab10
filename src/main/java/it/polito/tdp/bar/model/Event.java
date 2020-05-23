package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;

class Event implements Comparable<Event>{
	
	public enum EventType {
		ARRIVO_GRUPPO_CLIENTI, TAVOLO_LIBERATO
	}
	
	private EventType type;
	private LocalTime time;
	private Integer num_persone;
	private Duration durata;
	private Integer tolleranza;
	private Tavolo tavolo;
	
	public Event(EventType type, LocalTime time, Integer num_persone, Duration durata, Integer tolleranza) {
		this.type = type;
		this.time = time;
		this.num_persone = num_persone;
		this.durata = durata;
		this.tolleranza = tolleranza;
	}
	
	public Event(EventType type, LocalTime time, Tavolo tavolo) {
		this.type = type;
		this.time = time;
		this.tavolo = tavolo;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Integer getNum_persone() {
		return num_persone;
	}

	public void setNum_persone(Integer num_persone) {
		this.num_persone = num_persone;
	}

	public Duration getDurata() {
		return durata;
	}

	public void setDurata(Duration durata) {
		this.durata = durata;
	}

	public Integer getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(Integer tolleranza) {
		this.tolleranza = tolleranza;
	}
	
	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public EventType getType() {
		return type;
	}
	
	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public int compareTo(Event o) {
		return this.time.compareTo(o.time);
	}

}
