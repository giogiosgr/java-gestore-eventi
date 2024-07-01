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

	// getters e setters
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Evento> getEventList() {
		return this.eventList;
	}
	
	/**
	 * Metodo per aggiunta di un evento alla lista
	 * @param event
	 */
	public void addEvent(Evento event) {
		this.eventList.add(event);
	}
	
	/**
	 * Metodo che restituisce la lista di tutti gli eventi con data selezionata
	 * @param date
	 */
	public ArrayList<Evento> getEventsByDate(LocalDate date) {
	    ArrayList<Evento> newList = new ArrayList<>();
	    for (Evento x : this.eventList) {
	    	if (x.getDate().isEqual(date)) {
	    		newList.add(x);
	    	}
	    }
		return newList;
	}

	public String getOrderedEvents() {
        return "ciao";
   	}
             

}
