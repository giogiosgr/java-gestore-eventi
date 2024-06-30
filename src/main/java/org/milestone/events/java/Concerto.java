package org.milestone.events.java;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento{
	
	private LocalTime time;
	private double price;
	
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

}
