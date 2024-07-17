package org.milestone.events.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class ProgrammaEventi {
	// variabili di istanza
	private String title;
	private ArrayList<Evento> eventList;

	/**
	 * Costruttore
	 * 
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
	 * 
	 * @param event
	 */
	public void addEvent(Evento event) {
		this.eventList.add(event);
	}

	/**
	 * Metodo che restituisce la lista di tutti gli eventi con data selezionata
	 * 
	 * @param date
	 * @return ArrayList<Evento>
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

	/**
	 * Metodo che restituisce una stringa con il titolo del programma e tutti gli eventi ordinati per data,
	 * Per l'ordinamento degli eventi, per data, è utilizzato l'algoritmo di Bubble Sort
	 * 
	 * @return String
	 */
	public String getOrderedEvents() {
		String fullProgram = (this.title);
		ArrayList<Evento> orderedList = new ArrayList<>(this.eventList);
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < orderedList.size() - 1; i++) {
				if (orderedList.get(i).getDate().isAfter(orderedList.get(i + 1).getDate())) {
					Collections.swap(orderedList, i, i + 1);
					swapped = true;
				}
			}
		} while (swapped);
		for (Evento x : orderedList) {
			fullProgram += String.format("\n%s - %s", x.getFormattedDate(), x.getTitle());
		}
		return fullProgram;
	}

	/**
	 * Metodo che restituisce il numero di eventi nella lista
	 * 
	 * @return int
	 */
	public int getEventsCount() {
		return this.eventList.size();
	}

	/**
	 * Metodo che svuota la lista
	 */
	public void clearEventList() {
		eventList.clear();
	}
}
