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
	
	public String getFormattedTime() {
		return this.time.format(DateTimeFormatter.ofPattern("HH:mm"));	
	}
	
	@Override
	public String toString() {
		String formattedPrice = String.format("%.2f€", this.price);
		
		return formattedPrice;
	}

}
