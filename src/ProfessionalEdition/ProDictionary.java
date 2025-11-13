package ProfessionalEdition;

import java.util.Scanner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import ProfessionalEdition.ProEntry.Speech;

class ProDictionary
{
	public static void main(String[] args)
	{
		Multimap<String, ProEntry> dictionary = loadDict();

		displayHeader();

		while(true)
			search(dictionary);
	}

	private static Multimap<String, ProEntry> loadDict()
	{
		Multimap<String, ProEntry> dict = ArrayListMultimap.create();	
		for(ProEntry entry : ProEntry.values())
			dict.put(entry.name().toLowerCase(), entry);
		return dict;
	}

	private static void displayHeader()
	{
		System.out.println("- DICTIONARY 220 JAVA Professional -----");
		System.out.println("-----          powered by Google Guava -");
		System.out.println();
	}

	private static void search(Multimap<String, ProEntry> dict)
	{
		String[] inputParts = getInput().split(" ");
		String response = constructResponse(inputParts, dict);
		
		System.out.println("   |");
		System.out.printf("%s", response);
		System.out.println("   |");
	}

	private static String constructResponse(String[] input, Multimap<String, ProEntry> dict)
	{
		StringBuilder response = new StringBuilder();

		if(dict.containsKey(input[0]))
		{
			Speech chosenSpeechType = null;
			if(input.length > 1 && !input[1].equals("distinct"))
			{
				chosenSpeechType = getSpeechType(input[1]);
			}

			ProEntry entry = dict.get(input[0]).iterator().next();
			for(int i = 0; i < entry.getNumDefinitions(); i++)
				if(chosenSpeechType == null || chosenSpeechType.equals(entry.getSpeechType(i)))
					response.append(String.format("    %s [%s] : %s\n", entry.name(), entry.getSpeechType(i), entry.getDefinition(i)));
		}
		else response.append("    <Not Found>\n");

		return response.toString();
	}

	private static Speech getSpeechType(String input)
	{
		for(Speech type : Speech.values())
			if(type.name().equals(input))
				return type;
		
		return Speech.ERR;
	}

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
