package org.milestone.events.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	// variabili di istanza
	private String title;
	private LocalDate date;
	private final int totalSeats;
	private int bookedSeats;
	
	/**
	 * Costruttore
	 * 
	 * @param title
	 * @param date
	 * @param totalSeats
	 */
	public Evento(String title, LocalDate date, int totalSeats) {
		this.title = title;
		this.date = date;
		/**
		 *  Se la data attuale è più avanti della data dell'evento,
		 *  Oppure se il numero di posti è minore di 1, stampa avviso all'utente   
		 *  L'evento viene comunque istanziato con la data scelta, e i posti resettati a 0
		 *  Ma i metodi restituiranno i relativi errori quando si tenta di usarli     
		 *  A meno che i valori non vengano corretti tramite i setters                
		 * */  
		if (LocalDate.now().isAfter(this.date)) System.out.printf("\nAttenzione, l'evento '%s' è stato creato come già passato", this.title);
		if (totalSeats <= 0) {
			System.out.printf("\nAttenzione, l'evento '%s' è stato creato senza posti disponibili", this.title);
			this.totalSeats = 0;
		} else this.totalSeats = totalSeats;	
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
	
	public int getTotalSeats() {
		return this.totalSeats;
	}
	
	public int getBookedSeats() {
		return this.bookedSeats;
	}
	
	/**
	 * Metodo che restituisce la data formattata con l'ausilio di un oggetto formatter
	 * 
	 * @return String
	 */
	public String getFormattedDate () {
		return this.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));	
	}
	
	/**
	 * Metodo per l'aggiunta di un posto alla prenotazione,
	 * 
	 * @return String risultato del tentativo di prenotazione
	 */
	public String book() {
		if (LocalDate.now().isAfter(this.date)) {
			return "Attenzione, la data dell'evento è già passata";
		} else if (this.bookedSeats == this.totalSeats) {
			return "Attenzione, non ci sono più posti disponibili";
		} else {
			this.bookedSeats++;
			return "Posto prenotato con successo";
		}
	}
	
	/**
	 * Metodo per la cancellazione di una prenotazione,
	 * 
	 * @return String risultato del tentativo di cancellazione
	 */
	public String cancel() {
		if (LocalDate.now().isAfter(this.date)) {
			return "Attenzione, la data dell'evento è già passata";
		} else if (this.bookedSeats == 0) {
			return "Attenzione, non ci sono posti prenotati da disdire";
		} else {
			this.bookedSeats--;
			return "Prenotazione posto cancellata con successo";
		}
	}
	
	/**
	 * Override del metodo toString,
	 * Restituisce la data formattata tramite il metodo dedicato, più il titolo
	 * 
	 * @return String
	 */
	@Override
	public String toString() {	
		return String.format("%s - %s", getFormattedDate(), this.title);
	}
	
	//Overload per i metodi book e cancel, per prenotare/cancellare n posti
	public String book(int n) {
		if (LocalDate.now().isAfter(this.date)) {
			return "Attenzione, la data dell'evento è già passata";
		} else if (n <= 0 || (this.bookedSeats + n) > this.totalSeats) {
			return String.format("Attenzione, non è possibile prenotare %d posti, %d posti liberi rimasti",
					n, this.totalSeats - this.bookedSeats); 
		} else {
			this.bookedSeats += n;
			return String.format("Prenotati con successo %d posti, rimangono %d posti disponibili",
					n, this.totalSeats - this.bookedSeats); 
		}
	}
		
	public String cancel(int n) {
		if (LocalDate.now().isAfter(this.date)) {
			return "Attenzione, la data dell'evento è già passata";
		} else if (n <= 0 || (this.bookedSeats - n) < 0) {
			return String.format("Attenzione, non è possibile cancellare la prenotazione di %d posti, %d posti prenotati rimasti",
					n, this.bookedSeats);
		} else {
			this.bookedSeats -= n;
			return String.format("Prenotazione di %d posti cancellata con successo, rimangono %d posti disponibili",
					n, this.totalSeats - this.bookedSeats); 
		}			
	}
}
