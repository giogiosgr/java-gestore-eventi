package org.milestone.events.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		// dichiarazione variabili e oggetti per la successiva istanza e utilizzo della classe Evento
		String newTitle;
        int newSeats = 0;	
		String newDate;
		int modifiedSeats = 0;
		Scanner sc = new Scanner(System.in);
		/* creazione oggetto formatter per poter assegnare in seguito un valore al local date,
		 * nel formato desiderato.
		 * quindi successiva istanza di un oggetto LocalDate, inizialmente con la data corrente
		 */
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate parseddDate = LocalDate.now();
		/* serie di input per la creazione del nuovo evento,
		 * con cicli per gestione delle eccezioni per l'inserimento corretto della data e del numero di posti
		 */
		System.out.println("Inserire il nome dell'evento: ");
		newTitle = sc.nextLine();
		boolean error;
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
				System.out.println("Formato del numero non valido!");
				error = true;
			}
			sc.nextLine();
		} while (error);
		// istanza di un nuovo oggetto di classe Evento
		Evento newEvent = new Evento(newTitle, parseddDate, newSeats);
		System.out.println("\nCreato il seguente evento: " + newEvent.toString()); // stampa informazioni evento
        /* serie di richieste di input per prenotazione e cancellazione, 
         * con serie di cicli per controllo delle scelte dell'utente e validità dell'input
         */
		String answer;			
		do {
			System.out.println("\nPrenotare nuovi posti? (s per confermare, altro tasto per continuare): ");
			answer = sc.nextLine().toLowerCase();
	   	    if (answer.equals("s")) {
	   	    	do {
		            error = false;
		            System.out.println("\nInserire il numero di posti da prenotare: ");
		     	    try {
				        modifiedSeats = sc.nextInt();
			        } catch (Exception e) {			
				        System.out.println("Formato del numero non valido!");
				        error = true;
			        }
	   	    	} while (error);
			    sc.nextLine();
			    System.out.println("\n" + newEvent.book(modifiedSeats)); // stampa del risultato della prenotazione
		    }	    
		} while(answer.equals("s"));
		do {
			System.out.println("\nCancellare posti prenotati? (s per confermare, altro tasto per continuare): ");
			answer = sc.nextLine().toLowerCase();
	   	    if (answer.equals("s")) {
	   	    	do {
		            error = false;
		            System.out.println("\nInserire il numero di posti da cancellare dalla prenotazione: ");
		     	    try {
				        modifiedSeats = sc.nextInt();
			        } catch (Exception e) {			
				        System.out.println("Formato del numero non valido!");
				        error = true;
			        }
	   	    	} while (error);
			    sc.nextLine();
			    System.out.println("\n" + newEvent.cancel(modifiedSeats)); // stampa del risultato della cancellazione
		    }	    
		} while(answer.equals("s"));
        sc.close();    		
        // test su altri metodi
        System.out.println("\n" + newEvent.book());
        System.out.println("\n" + newEvent.cancel());
	}	
}
