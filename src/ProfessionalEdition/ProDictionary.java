package ProfessionalEdition;

import java.util.Scanner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

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
			dict.put(entry.getWord().toLowerCase(), entry);
		return dict;
	}

	private static void displayHeader()
	{
		System.out.println("- DICTIONARY 220 JAVA Standard -----");
		System.out.println("-----      powered by Google Guava -");
		System.out.println();
	}

	private static void search(Multimap<String, ProEntry> dict)
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
