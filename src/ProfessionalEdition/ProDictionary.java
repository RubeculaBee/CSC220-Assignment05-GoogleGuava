package ProfessionalEdition;

import java.util.Scanner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import ProfessionalEdition.ProEntry.Speech;

/*
 * File: ProDictionary.java
 * Date: 11-13-25
 * By: Robin Lane
 * 
 * Description: Loads enums into a multimap dictionary, and allows the user
 * 				to search through it by word and by part of speech
 */

class ProDictionary
{
	public static void main(String[] args)
	{
		Multimap<String, ProEntry> dictionary = loadDict();

		displayHeader();

		while(true)
			search(dictionary);
	}

	/**
	 * Loads the dictionary with the enums. Unfortunately does not utilise the multimap very well
	 * Each key only has one value. Whoops!
	 * @return The multimap in question
	 */
	private static Multimap<String, ProEntry> loadDict()
	{
		Multimap<String, ProEntry> dict = ArrayListMultimap.create();	
		for(ProEntry entry : ProEntry.values())
			dict.put(entry.name().toLowerCase(), entry);
		return dict;
	}

	/**
	 * Displays the *Proffesional* Header
	 */
	private static void displayHeader()
	{
		System.out.println("- DICTIONARY 220 JAVA Professional -----");
		System.out.println("-----          powered by Google Guava -");
		System.out.println();
	}

	/**
	 * Searchs the dictinoary and pritns the response
	 * @param dict The multimap to be searched
	 */
	private static void search(Multimap<String, ProEntry> dict)
	{
		String[] inputParts = getInput().split(" ");
		String response = constructResponse(inputParts, dict);
		
		System.out.println("   |");
		System.out.printf("%s", response);
		System.out.println("   |");
	}

	/**
	 * Interprets the users input and constructs a response
	 * @param input An array of words the user typed
	 * @param dict The dictionary to be searched
	 * @return The response. Either a 'not found' message, or the word the user is lookng for.
	 */
	private static String constructResponse(String[] input, Multimap<String, ProEntry> dict)
	{
		StringBuilder response = new StringBuilder();

		if(dict.containsKey(input[0]))
		{
			Speech chosenSpeechType = null;
			if(input.length > 1 && !input[1].equals("distinct"))
			{
				chosenSpeechType = chooseSpeechType(input[1]);
			}
			if(chosenSpeechType != Speech.ERR)
			{
				ProEntry entry = dict.get(input[0]).iterator().next();
				for(int i = 0; i < entry.getNumDefinitions(); i++)
					if(chosenSpeechType == null || chosenSpeechType.equals(entry.getSpeechType(i)))
						response.append(String.format("    %s [%s] : %s\n", entry.name(), entry.getSpeechType(i), entry.getDefinition(i)));
				
				if(response.length() == 0)
					response.append("    <Not Found>\n");
			}
			else response.append("    <2nd argument must be a part of speech or \"distinct\">\n");
		}
		else response.append("    <Not Found>\n");

		return response.toString();
	}

	/**
	 * Checks to see if the user input a valid part of speech. If not, return the error key
	 * @param input the part of speech the user entered
	 * @return The Speech enum corresponding to the user's input, or ERR if none match
	 */
	private static Speech chooseSpeechType(String input)
	{
		for(Speech type : Speech.values())
			if(type.name().equals(input))
				return type;
		
		return Speech.ERR;
	}

	/**
	 * Get input from the user, quits if they type !q
	 * @return What the user typed
	 */
	private static String getInput()
	{
		Scanner input = new Scanner(System.in);
		String query;

		System.out.print("Search: ");
		query = input.nextLine().toLowerCase();

		if(query.equals("!q"))
		{
			System.out.println("\n-----THANK YOU-----");
			input.close();
			System.exit(0);
		}

		return query;
	}
}
