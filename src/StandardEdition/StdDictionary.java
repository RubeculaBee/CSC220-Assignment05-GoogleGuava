package StandardEdition;

import java.util.Scanner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

class StdDictionary
{
	public static void main(String[] args)
	{
		Multimap<String, StdEntry> dictionary = loadDict();

		displayHeader();

		while(true)
			search(dictionary);
	}

	private static Multimap<String, StdEntry> loadDict()
	{
		Multimap<String, StdEntry> dict = ArrayListMultimap.create();	
		for(StdEntry entry : StdEntry.values())
			dict.put(entry.getWord().toLowerCase(), entry);
		return dict;
	}

	private static void displayHeader()
	{
		System.out.println("- DICTIONARY 220 JAVA Standard -----");
		System.out.println("-----      powered by Google Guava -");
		System.out.println();
	}

	private static void search(Multimap<String, StdEntry> dict)
	{
		String response;
		if(dict.containsKey(getInput()))
		{
			response = "<Found>";
		}
		else response = "<Not Found>";

		System.out.printf("%4s|\n", " ");
		System.out.printf("%4s %s\n", " ", response);
		System.out.printf("%4s|\n", " ");
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
