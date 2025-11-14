package ProfessionalEdition;

/*
 * File: ProEntry.java
 * Date: 11-13-25
 * By: Robin Lane
 * 
 * Description: Overcomplicated enum to store the definitions of various words.
 * 				The enum name is the word, and it contains all of that words 
 * 				definitions, as well what parts of speech those definitions
 * 				describe
 */

enum ProEntry
{
	// Enums are defined in multiple lines to keep it easy to read
	Book(
		new String[] {"A Written work published in printed or electronic form.", "To arrange for someone to have a seat on a plane."},
		Speech.noun, Speech.verb
	),
	Bookable(
		new String[] {"Can be ordered in advance."},
		Speech.adjective
	),
	Bookcase(
		new String[] {"A piece of furniture with shelves."},
		Speech.noun
	),
	Bookbinder(
		new String[] {"A person who fastens the pages of books."},
		Speech.noun
	),
	CSC220(
		new String[] {"Ready to create complex data structures.", "Data Structures.", "To create data structures."},
		Speech.adjective, Speech.noun, Speech.verb
	);

	private String[] definitions;
	private Speech[] speechTypeOrder;

	/**
	 * ProEntry Constructor
	 * @param definitions a string array of all the words definitions
	 * @param typeOrder Speech enums, each corresponding to the definitions in order.
	 * @throws DefTypeMismatchException If the amount of definitions and speech types don't match.
	 */
	private ProEntry(String[] definitions,Speech... typeOrder) throws DefTypeMismatchException
	{
		if(typeOrder.length > definitions.length)
			throw new DefTypeMismatchException("Definition-Type count mismatch: More Speech Types than Definitions");
		if(typeOrder.length < definitions.length)
			throw new DefTypeMismatchException("Definition-Type count mismatch: More Definitions than Speech Types");

		this.definitions = definitions;
		this.speechTypeOrder = typeOrder;
	}

	public String getDefinition(int index) {return this.definitions[index];}
	public Speech getSpeechType(int index) {return this.speechTypeOrder[index];}
	public int getNumDefinitions() {return this.definitions.length;}

	/**
	 * defines the allowed parts of speech, as well as an error value
	 */
	enum Speech
	{
		noun, verb, adjective, adverb, ERR;
	}

	/**
	 * Error to be thrown by the constructor
	 */
	private class DefTypeMismatchException extends RuntimeException
	{
		private String message;

		private DefTypeMismatchException() {}
		private DefTypeMismatchException(String message) {this.message = message;}

		@Override
		public String getMessage()
		{
			return message;
		}
	}
}
