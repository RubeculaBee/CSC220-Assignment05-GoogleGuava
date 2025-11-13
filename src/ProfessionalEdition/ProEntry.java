package ProfessionalEdition;

enum ProEntry
{
	Book(
		new String[] {"A Written work published in printed or electronic form.", "To arrange for someone to have a seat on a plane."},
		Speech.NOUN, Speech.VERB
	),
	Bookable(
		new String[] {"Can be ordered in advance."},
		Speech.ADJECTIVE
	),
	Bookcase(
		new String[] {"A piece of furniture with shelves."},
		Speech.NOUN
	),
	Bookbinder(
		new String[] {"A person who fastens the pages of books."},
		Speech.NOUN
	),
	CSC220(
		new String[] {"Ready to create complex data structures.", "Data Structures", "To create data structures."},
		Speech.ADJECTIVE, Speech.NOUN, Speech.VERB
	);

	private String[] definitions;
	private Speech[] speechTypeOrder;

	private ProEntry(String[] definitions,Speech... typeOrder)
	{
		this.definitions = definitions;
		this.speechTypeOrder = typeOrder;
	}

	public String getDefinition(int index) {return this.definitions[index];}
	public Speech getSpeechType(int index) {return this.speechTypeOrder[index];}

	private enum Speech
	{
		NOUN, VERB, ADJECTIVE, ADVERB;
	}
}
