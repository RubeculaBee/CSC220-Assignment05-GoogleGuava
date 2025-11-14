package StandardEdition;

/*
 * File Name: StdEntry.Java
 * Date: 11-10-25
 * By: Robin Lane
 * 
 * Description: a very simple enum to store all the words and definitions that should be in the dictionary
 */

enum StdEntry
{
	// Each word is stored in a seperate enum, even if they are homonyms
	BOOK_NOUN("Book", "A Written work published in printed or electronic form."),
	BOOK_VERB("Book", "To arrange for someone to have a seat on a plane."),
	BOOKABLE("Bookable", "Can be ordered in advance."),
	BOOKCASE("Bookcase", "A piece of furniture with shelves."),
	BOOKBINDER("Bookbinder", "A person who fastens the pages of books."),
	CSC220_NOUN("CSC220", "Data Structures."),
	CSC220_ADJ("CSC220", "Ready to create complex data structures."),
	CSC220_VERB("CSC220", "To create data structures.");

	private String word;
	private String definition;

	private StdEntry(String word, String definition)
	{
		this.word = word;
		this.definition = definition;
	}

	public String getWord() {return this.word;}
	public String getDefinition() {return this.definition;}
}
