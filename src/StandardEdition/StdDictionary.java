package StandardEdition;

import java.util.Scanner;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

class StdDictionary
{
	public static void main(String[] args)
	{
		Multimap<String, String> dictionary = loadDict();

		displayHeader();

		while(true)
			search();
	}

	private static Multimap<String, String> loadDict()
	{
		Multimap<String, String> dict = ArrayListMultimap.create();	
		for(StdEntry entry : StdEntry.values())
			dict.put(entry.getWord(), entry.getDefinition());
		return dict;
	}

	private static void displayHeader()
	{
		System.out.println("- DICTIONARY 220 JAVA Standard -----");
		System.out.println("-----      powered by Google Guava -");
		System.out.println();
	}

	private static void search()
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

		System.out.printf("%4s|\n", " ");
		System.out.printf("%5s<Not Found>\n", " "); // TODO: Implement searching the dictionary
		System.out.printf("%4s|\n", " ");
	}
}
