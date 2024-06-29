package org.milestone.events.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	
	/**
	 * Metodo che aggiunge un posto tra quelli prenotati, a condizione che:
	 * I posti non siano finiti (con re),
	 * La data non sia passata (con stampa di messaggio dedicato)
	 */
	
	/**
	 * Metodo per l'aggiunta di un posto alla prenotazione,
	 * @return String risultato del tentativo di prenotazione
	 */
	public String book() {
		if (this.bookedSeats == this.totalSeats) {
			return "Attenzione, non ci sono più posti disponibili";
		} else if (LocalDate.now().isAfter(this.date)) {
			return "Attenzione, la data dell'evento è già passata";
		} else {
			this.bookedSeats++;
			return "Posto prenotato con successo";
		}
	}
	
	/**
	 * Metodo per la cancellazione di una prenotazione,
	 * @return String risultato del tentativo di cancellazione
	 */
	public String cancel() {
		if (this.bookedSeats == 0) {
			return "Attenzione, non ci sono prenotazioni da disdire";
		} else if (LocalDate.now().isAfter(this.date)) {
			return "Attenzione, la data dell'evento è già passata";
		} else {
			this.bookedSeats++;
			return "Prenotazione cancellata con successo";
		}
	}
	
	/**
	 * Oveddire del metodo toString,
	 * Restituisce la data formattata tramite un oggetto formatter, più il titolo
	 */
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = this.date.format(formatter);		
		return String.format("%s - %s", formattedDate, this.title);
	}
}
