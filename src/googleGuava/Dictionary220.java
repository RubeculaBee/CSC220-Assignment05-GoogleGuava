package googleGuava;
/**
 * Google Guava Search
 */

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Dictionary220 {

    private enum Entry {

        BOOK("book", "A set of pages.");

        private String key;
        private String value;

        private Entry() {
        }

        private Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {

        Multimap<String, String> dictionaryGG = ArrayListMultimap.create();

        // Adding some key/value
        dictionaryGG.put(Entry.BOOK.getKey(), Entry.BOOK.getValue());

        // Search
        String searchKey = "book";
        if (dictionaryGG.containsKey(searchKey)) {
            System.out.println(searchKey + "\t <Found>");
        } else {
            System.out.println(searchKey + "\t <Not found>");
        }
    }
}

