package org.milestone.events.java;

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

}
