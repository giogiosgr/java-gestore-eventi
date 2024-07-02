package org.milestone.events.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		// dichiarazione variabili per la successiva istanza e utilizzo della classe Evento
		String newTitle;
		int newSeats;
		int modifiedSeats;
		/* creazione oggetto formatter per poter assegnare un valore al local date nel formato personalizzato,
		 * quindi successiva dichiarazione di un oggetto LocalDate
		 */
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate newDate;
		// serie di input, con richiamo dei metodi dedicati all'input della data e dei numeri interi
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserire il titolo dell'evento");
		newTitle = sc.nextLine();
		newDate = checkDateInput("Inserire la data nel formato gg/mm/aaaa", sc, dateFormatter);
		newSeats = checkIntInput("Inserire il numero di posti disponibili", sc);
		// istanza di un nuovo oggetto di classe Evento
		Evento newEvent = new Evento(newTitle, newDate, newSeats);
		System.out.println("\nCreato il seguente evento: " + newEvent); // stampa informazioni evento
        // ciclo per l'input delle prenotazioni/disdette, con richiamo del metodo dedicato all'input di interi
		String answer;			
		do {
			System.out.println("\nPrenotare o cancellare posti? (p per prenotare, c per cancellare, altro tasto per continuare)");
			answer = sc.nextLine().toLowerCase(); 
			if (answer.equals("p") || answer.equals("c")) {
				String message = "";
				if (answer.equals("p")) message = "Inserire il numero di posti da prenotare";
				if (answer.equals("c")) message = "Inserire il numero di prenotazioni da cancellare";
				modifiedSeats = checkIntInput(message, sc);
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
		// istanza e test della classe Concerto
		System.out.println("\nCLASSE CONCERTO\n");    
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime parsedTime = LocalTime.parse("20:30", timeFormatter); 
		Concerto newConcert = new Concerto("Concertone", newDate, 100, parsedTime, 39.90);
		System.out.println("\nRiepilogo concerto\n" + newConcert);
		// istanta e test della classe ProgrammaEventi
		System.out.println("\nCLASSE PROGRAMMAEVENTI\n");
		ProgrammaEventi newProgram = new ProgrammaEventi("Programmone");
		newProgram.addEvent(new Evento("evento1", LocalDate.parse("2028-12-11"), 100));
		newProgram.addEvent(new Evento("evento2", LocalDate.parse("2025-12-12"), 100));
		newProgram.addEvent(new Evento("evento3", LocalDate.parse("2027-01-02"), 100));
		newProgram.addEvent(new Evento("evento4", LocalDate.parse("2025-12-12"), 100));
		newProgram.addEvent(new Evento("evento5", LocalDate.parse("2026-06-11"), 100));		
		System.out.println("\nEventi in data 12/12/2025\n" + newProgram.getEventsByDate(LocalDate.parse("2025-12-12")));		
		System.out.println("\nLista eventi ordinata per data\n" + newProgram.getOrderedEvents());		
		System.out.println("\nNumero di eventi\n" + newProgram.getEventsCount());		
		newProgram.clearEventList();		
		System.out.println("\nNumero di eventi\n" + newProgram.getEventsCount());		
		System.out.println("\nLista eventi ordinata per data\n" + newProgram.getOrderedEvents()); 
	}	

	/**
	 * Metodo per l'acquisizione di un oggetto LocalDate, passando la stringa della richiesta,
	 * Poi un oggetto scanner, quindi un oggetto formatter per l'acquisizione della data nella forma richiesta,
	 * Comprende il controllo del formato della data inserita tramite costrutto try/catch
	 * 
	 * @param question
	 * @param input
	 * @param customFormatter
	 * @return LocalDate
	 */
	public static LocalDate checkDateInput(String question, Scanner input, DateTimeFormatter customFormatter) {
		LocalDate inputDate = LocalDate.now();
		boolean error;
		do {
			error = false;		
			System.out.println("\n" + question); 
			try {  
				inputDate = LocalDate.parse(input.nextLine(), customFormatter);
			} catch (DateTimeParseException e) {
				System.out.println("Formato della data non valido!");       
				error = true;
			}
		}  
		while (error);  	
		return inputDate;
	}
    
	/**
	 * Metodo per l'acquisizione di un intero, passando la stringa della richiesta e un oggetto scanner,
	 * Comprende il controllo della validità dell'input
	 * 
	 * @param question
	 * @param input
	 * @return int
	 */
    public static int checkIntInput(String question, Scanner input) {
		int inputNumber = 0;
		boolean error;
		do {
			error = false;
			System.out.println("\n" + question);
			if (input.hasNextInt()) {
				inputNumber = input.nextInt();
			} else {
				System.out.println("Formato del numero non valido!");
				error = true;    
			}
			input.nextLine();	    
			} while (error);
		return inputNumber;
	}
}