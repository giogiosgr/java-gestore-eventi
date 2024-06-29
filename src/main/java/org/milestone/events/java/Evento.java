package org.milestone.events.java;

import java.time.LocalDate;

public class Evento {
    
	private String title;
	private LocalDate date;
	private final int totalSeats;
	private int bookedSeats;
	
	public Evento(String title, LocalDate date, int seats) {
		this.title = title;
		this.date = date;
		// se la data attuale è superiore alla data dell'evento, stampa avviso all'utente
		if (LocalDate.now().isAfter(this.date)) System.out.println("Attenzione, l'evento è stato creato come già passato");
		this.totalSeats = seats;
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
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public int getSeats() {
		return this.totalSeats;
	}
	
	public int getbooked() {
		return bookedSeats;
	}
	
}
