package org.milestone.events.java;

import java.time.LocalDate;
import java.time.LocalTime;
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
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate parsedDate = LocalDate.now();
		
		
		// ----- WIP PROVE PROGRAMMAEVENTI -----
		
		ProgrammaEventi newProgram = new ProgrammaEventi("programmone");
		
		newProgram.addEvent(new Evento("evento1", LocalDate.parse("2028-12-11"), 100));
		newProgram.addEvent(new Evento("evento2", LocalDate.parse("2025-12-12"), 100));
		newProgram.addEvent(new Evento("evento3", LocalDate.parse("2027-01-02"), 100));
		newProgram.addEvent(new Evento("evento4", LocalDate.parse("2025-12-12"), 100));
		
		System.out.println(newProgram.getEventsByDate(LocalDate.parse("2025-12-12")));
		
		
		
		
		
		// -------------------------------------
		
		
		
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
			    parsedDate = LocalDate.parse(newDate, dateFormatter);
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
		Evento newEvent = new Evento(newTitle, parsedDate, newSeats);
		System.out.println("\nCreato il seguente evento: " + newEvent); // stampa informazioni evento
        /* richieste di input per prenotazione o cancellazione, 
         * con serie di cicli, con controllo delle scelte dell'utente e validità dell'input
         */
		String answer;			
		do {
			System.out.println("\nPrenotare o cancellare posti? (p per prenotare, c per cancellare, altro tasto per continuare): ");
			answer = sc.nextLine().toLowerCase();
	   	    if (answer.equals("p") || answer.equals("c")) {
	   	    	do {
		            error = false;
		            if (answer.equals("p")) System.out.println("\nInserire il numero di posti da prenotare: ");
		            if (answer.equals("c")) System.out.println("\nInserire il numero di posti da cancellare dalla prenotazione: ");
		     	    try {
				        modifiedSeats = sc.nextInt();
			        } catch (Exception e) {
				        System.out.println("Formato del numero non valido!");
				        error = true;
			        }
				    sc.nextLine();
	   	    	} while (error);
			    // stampa del risultato della prenotazione
			    if (answer.equals("p")) System.out.println("\n" + newEvent.book(modifiedSeats)); 
			    // stampa del risultato della cancellazione
			    if (answer.equals("c")) System.out.println("\n" + newEvent.cancel(modifiedSeats)); 
		    }	    
		} while(answer.equals("p") || answer.equals("c"));
        sc.close();    		
        // test su altri metodi di Evento
        System.out.println("\n" + newEvent.book());
        System.out.println("\n" + newEvent.cancel());
   	    // assegnazione variabili per successiva istanza e utilizzo della classe Concerto
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime parsedTime = LocalTime.parse("20:30", timeFormatter);
        Concerto newConcert = new Concerto("Concertone", parsedDate, 100, parsedTime, 39.90);
        System.out.println("\nRiepilogo concerto: \n" + newConcert.toString());    
	}	
}
