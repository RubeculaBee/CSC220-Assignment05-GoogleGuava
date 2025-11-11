package StandardEdition;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

class StdDictionary
{
	public static void main(String[] args)
	{
		Multimap<String, String> dictionary = loadDict();

		displayHeader();
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
}
