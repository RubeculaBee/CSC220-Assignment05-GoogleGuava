package StandardEdition;

import java.util.Scanner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/*
 * File: StdDictionary.java
 * Date: 11-10-25
 * By: Robin Lane
 * 
 * Description: Loads a list of enums into a Google Guava multimap, and then
 * 				allows the user to search through it like a dictionary.
 */

class StdDictionary
{
	public static void main(String[] args)
	{
		Multimap<String, StdEntry> dictionary = loadDict();

		displayHeader();

		while(true)
			search(dictionary);
	}

	/**
	 * Loads a multimap dictionary with the values of the StdEntry enums
	 * @return The multimap in question
	 */
	private static Multimap<String, StdEntry> loadDict()
	{
		Multimap<String, StdEntry> dict = ArrayListMultimap.create();	
		for(StdEntry entry : StdEntry.values())
			dict.put(entry.getWord().toLowerCase(), entry);
		return dict;
	}

	/**
	 * Prints the header
	 */
	private static void displayHeader()
	{
		System.out.println("- DICTIONARY 220 JAVA Standard -----");
		System.out.println("-----      powered by Google Guava -");
		System.out.println();
	}

	/**
	 * Searches the multimap for a given word, and prints a response message
	 * @param dict The multimap dictionary to be searched through
	 */
	private static void search(Multimap<String, StdEntry> dict)
	{
		StringBuilder response = new StringBuilder();
		String input = getInput();
		if(dict.containsKey(input))
		{
			dict.get(input).forEach(entry -> 
			{
				response.append("    ");
				response.append(entry.getWord());
				response.append(": ");
				response.append(entry.getDefinition());
				response.append("\n");
			});
		}
		else response.append("    <Not Found>\n");

		System.out.println("   |");
		System.out.printf("%s", response);
		System.out.println("   |");
	}

	/**
	 * Gets input from the user. Will quit if the user types !q
	 * @return The input from the user
	 */
	private static String getInput()
	{
		Scanner input = new Scanner(System.in);
		String query;

		System.out.print("Search: ");
		query = input.nextLine();

		if(query.equals("!q"))
		{
			System.out.println("\n-----THANK YOU-----");
			input.close();
			System.exit(0);
		}

		return query.toLowerCase();
	}
}
