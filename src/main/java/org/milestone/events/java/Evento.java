package org.milestone.events.java;

import java.time.LocalDate;

public class Evento {

	private String title;
	private LocalDate date;
	private int seats;
	private int bookedSeats;
	
	public Evento(String title, LocalDate date, int seats) {
		this.title = title;
		this.date = date;
		// se la data attuale è superiore alla data dell'evento, stampa avviso all'utente
		if (LocalDate.now().isAfter(this.date)) System.out.println("Attenzione, l'evento è stato creato come già passato");
		this.seats = seats;
		// se il numero di posti istanziato è minore di 1, stampa avviso all'utente
		if (seats <= 0) System.out.println("Attenzione, l'evento è stato creato senza posti disponibili");
		this.bookedSeats = 0;
	}
	
	// getters e setters
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
}
