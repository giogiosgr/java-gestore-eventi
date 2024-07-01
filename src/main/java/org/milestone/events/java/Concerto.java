package org.milestone.events.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	// variabili di istanza
	private LocalTime time;
	private double price;
	
	/**
	 * Costruttore
	 * @param title
	 * @param date
	 * @param totalSeats
	 * @param time
	 * @param price
	 */
	public Concerto(String title, LocalDate date, int totalSeats, LocalTime time, double price) {
		super(title, date, totalSeats);
		this.time = time;
		this.price = price;
	}
	
	// getters e setters
	public LocalTime getTime() {
		return this.time;
	}
	
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Metodo che restituisce il prezzo formattato in Euro
	 * @return
	 */
	public String getFormattedPrice() {
		return String.format("%.2f€", this.price);
	}
	
	/**
	 * Metodo che restituisce l'ora formattata con l'ausilio di un oggetto formatter
	 * @return String
	 */
	public String getFormattedTime() {
		return this.time.format(DateTimeFormatter.ofPattern("HH:mm"));	
	}
	
	/**
	 * Override del metodo toString,
	 * Restituisce data e ora formattati, più titolo e prezzo formattati
	 * @return String
	 */
	@Override
	public String toString() {
	    return String.format("%s ore %s - %s - %s", getFormattedDate(), getFormattedTime(), getTitle(), getFormattedPrice());
	}
}
