package org.milestone.events.java;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProgrammaEventi {
	// variabili di istanza
	private String title;
	private ArrayList<Evento> eventList;
	
	/**
	 * Costruttore
	 * @param title
	 */
	public ProgrammaEventi(String title) {
		this.title = title;
		eventList = new ArrayList<Evento>();
	}
	
	// metodi vari di aggiunta e restituzione
	public void addEvent(Evento event) {
		this.eventList.add(event);
	}
	
	public ArrayList<Evento> getEventsByDate(LocalDate date) {
	    ArrayList<Evento> newList = new ArrayList<>();
	    for (Evento x : this.eventList) {
	    	if (x.getDate().isEqual(date)) {
	    		newList.add(x);
	    	}
	    }
		return newList;
	}

}
