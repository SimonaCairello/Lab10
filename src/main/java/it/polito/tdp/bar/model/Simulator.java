package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import it.polito.tdp.bar.model.Event.EventType;

public class Simulator {

	private PriorityQueue<Event> queue;
	
	private Statistiche statistiche;
	
	private List<Tavolo> tavoliLiberi;
	
	public Simulator() {
		this.tavoliLiberi = new ArrayList<>();
		
		for(int i=0; i<5; i++)
			tavoliLiberi.add(new Tavolo(4));
		
		for(int i=0; i<4; i++)
			tavoliLiberi.add(new Tavolo(6));
		
		for(int i=0; i<4; i++)
			tavoliLiberi.add(new Tavolo(8));
		
		tavoliLiberi.add(new Tavolo(10));
		tavoliLiberi.add(new Tavolo(10));
		
		statistiche = new Statistiche(0, 0, 0);
	}
	
	public void generaEventi() {
		LocalTime ora = LocalTime.of(00, 00);
		
		for(int i=0; i<2000; i++) {
			Random random = new Random();
			
			Integer time = random.nextInt(10)+1;
			Integer num_persone = random.nextInt(10)+1;
			Integer durata = random.nextInt((120-60)+1)+1;
			Integer tolleranza = random.nextInt(100)+1;
			
			Event e = new Event(EventType.ARRIVO_GRUPPO_CLIENTI, ora, num_persone, Duration.of(durata, ChronoUnit.MINUTES), tolleranza);
			
			ora = ora.plus(time, ChronoUnit.MINUTES);
			
			this.queue.add(e);
		}
	}

	public void run() {
		this.queue = new PriorityQueue<>();
		this.generaEventi();
		
		while(!queue.isEmpty()) {
			Event e = this.queue.poll();
			processEvent(e);
		}
	}
	
	private void processEvent(Event e) {
		switch(e.getType()) {
		
		case ARRIVO_GRUPPO_CLIENTI:
			
			statistiche.incrementaNumTotClienti(e.getNum_persone());
			boolean aggiunto = false;
			
			if(tavoliLiberi.size()>0) {
				Collections.sort(tavoliLiberi);
				
				for(Tavolo t : tavoliLiberi) {
					if(t.getNumPosti() >= e.getNum_persone() && e.getNum_persone() >= t.getNumPosti()/2) {
						tavoliLiberi.remove(t);
							
						Event nuovo = new Event(EventType.TAVOLO_LIBERATO, e.getTime().plus(e.getDurata()), t);
						this.queue.add(nuovo);
						aggiunto = true;
							
						statistiche.incrementaNumClSoddisfatti(e.getNum_persone());
						
						break;
					}
				}
				
				if(aggiunto==false) {
					Random random = new Random();
					Integer tol = random.nextInt(100)+1;
					
					if(tol <= e.getTolleranza())
						statistiche.incrementaNumClSoddisfatti(e.getNum_persone());
					else statistiche.incrementaNumClInsoddisfatti(e.getNum_persone());
				}	
			}
			
			else {
				Random random = new Random();
				Integer tol = random.nextInt(100)+1;
				
				if(tol <= e.getTolleranza())
					statistiche.incrementaNumClSoddisfatti(e.getNum_persone());
				else statistiche.incrementaNumClInsoddisfatti(e.getNum_persone());
			}
			break;
			
		case TAVOLO_LIBERATO:
			
			tavoliLiberi.add(e.getTavolo());
			
			break;
		}

	}
	
	public Statistiche getStatistiche() {
		return this.statistiche;
	}
}
