package org.milestone.events.java;

import java.util.Date;

public class Evento {

	private String title;
	private Date date;
	private int seats;
	private int bookedSeats;
	
	public Evento(String title, Date date, int seats) {
		this.title = title;
		this.date = date;
		// se la data attuale è maggiore o uguale alla data dell'evento,
		if (new Date().compareTo(this.date) >= 0) System.out.println("Attenzione, l'evento è stato creato come già passato");
		this.seats = seats;
		if (seats <= 0) System.out.println("Attenzione, l'evento è stato creato senza posti disponibili");
		this.bookedSeats = 0;
	}
	
}
