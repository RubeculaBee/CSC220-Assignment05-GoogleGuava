package ProfessionalEdition;

enum ProEntry
{
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
		new String[] {"Ready to create complex data structures.", "Data Structures", "To create data structures."},
		Speech.adjective, Speech.noun, Speech.verb
	);

	private String[] definitions;
	private Speech[] speechTypeOrder;

	private ProEntry(String[] definitions,Speech... typeOrder) throws DefTypeMismatchException
	{
		if(typeOrder.length > definitions.length)
			throw new DefTypeMismatchException("Definition-Type count mismatch: More Speech Types that Definitions");
		if(typeOrder.length < definitions.length)
			throw new DefTypeMismatchException("Definition-Type count mismatch: More Definitions than Speech Types");

		this.definitions = definitions;
		this.speechTypeOrder = typeOrder;
	}

	public String getDefinition(int index) {return this.definitions[index];}
	public Speech getSpeechType(int index) {return this.speechTypeOrder[index];}
	public int getNumDefinitions() {return this.definitions.length;}

	private enum Speech
	{
		noun, verb, adjective, adverb;
	}

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
