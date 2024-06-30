package org.milestone.events.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		// dichiarazione variabili e oggetti vari
		String newTitle;
        int newSeats = 0;	
		String newDate;
		boolean error;
		Scanner sc = new Scanner(System.in);
		/* creazione oggetto formatter per poter assegnare in seguito un valore al local date,
		 * nel formato desiderato.
		 * quindi successiva istanza di un oggetto LocalDate, inizialmente con la data corrente
		 */
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate parseddDate = LocalDate.now();
		/* serie di input per la creazione del nuovo evento,
		 * con cicli e gestione delle eccezioni per l'inserimento corretto della data e del numero di posti
		 */
		System.out.println("Inserire il nome dell'evento: ");
		newTitle = sc.nextLine();
		do {
		    error = false;		
		    System.out.println("\nInserire data del nuovo evento nel formato GG/MM/AAAA: ");  
		    try {    	
		    	newDate = sc.nextLine();
		    	// assegnazione della data dalla stringa di input, dal formato determinato con formatter
			    parseddDate = LocalDate.parse(newDate, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato della data non valido!");
                error = true;
            }
		}  
		while (error);  	
		do {
			error = false;
		    System.out.println("\nInserire il numero di posti disponibili: ");
			try {
				newSeats = sc.nextInt();
			} catch (Exception e) {			
				System.out.println("Numero non valido!");
				sc.nextLine();
				error = true;
			}
		} while (error);
		sc.close();
		// istanza di un nuovo oggetto di classe Evento
		Evento newEvent = new Evento(newTitle, parseddDate, newSeats);
		System.out.println("\nCreato il seguente evento: " + newEvent.toString());
        // serie di input per prenotazione e disdetta posti dell'evento creato
		
        System.out.println("\n" + newEvent.book(5));
        
        System.out.println("\n" + newEvent.cancel(5));
		 
		
		
	}

}
