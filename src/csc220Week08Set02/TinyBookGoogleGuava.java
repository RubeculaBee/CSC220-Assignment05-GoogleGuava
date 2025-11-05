package csc220Week08Set02;

import java.util.Collection;
// Google Guava, Interface Multimap: https://bit.ly/2qWXeyW
// Google Guava, Download https://bit.ly/2Hpo2PA
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Duc Ta PLUS
 */
public class TinyBookGoogleGuava {

    public static void main(String[] args) {
        Multimap<String, String> tinyBook = ArrayListMultimap.create();

        // Adding some key/value
        System.out.println("\nAdding----------------------------------------");
        tinyBook.put("book", "A set of pages.");
        tinyBook.put("book", "To arrange something on a particular date.");
        tinyBook.put("bookable", "Can be ordered.");
        tinyBook.put("bookbinder", "A person who fastens the pages of books.");
        tinyBook.put("bookcase", "A piece of furniture with shelves.");

        // Getting the size
        System.out.println("\nSize------------------------------------------");
        System.out.println(tinyBook.size());  // 5

        // Getting values
        System.out.println("\nValues----------------------------------------");
        Collection<String> book = tinyBook.get("book");
        System.out.println(book);
        // [A set of pages., To arrange something on a particular date.]

        Collection<String> bookcase = tinyBook.get("bookcase");
        System.out.println(bookcase);
        // [A piece of furniture with shelves.]

        // Iterating over entire Mutlimap
        System.out.println("\nIterate---------------------------------------");
        tinyBook.values().forEach((value) -> {
            System.out.println(value);
        });

        // Getting hash codes
        System.out.println("\nHash Codes-------------------------------------");
        tinyBook.entries().forEach((entry) -> {
            System.out.println(entry.hashCode() + "\t"
                    + System.identityHashCode(entry));
        });

        System.out.println("\nHash Code--------------------------------------");
        System.out.print(tinyBook.hashCode() + "\t");
        System.out.println(System.identityHashCode(tinyBook));

        // Removing a single value
        System.out.println("\nRemove----------------------------------------");
        tinyBook.remove("bookcase", "A piece of furniture with shelves.");
        System.out.println(tinyBook.get("bookcase")); // []

        // Remove all values for a key
        System.out.println("\nRemove All------------------------------------");
        tinyBook.removeAll("book");
        System.out.println(tinyBook.get("book")); // [] 
    }
}
/* OUTPUT
Adding----------------------------------------

Size------------------------------------------
5

Values----------------------------------------
[A set of pages., To arrange something on a particular date.]
[A piece of furniture with shelves.]

Iterate---------------------------------------
Can be ordered.
A set of pages.
To arrange something on a particular date.
A person who fastens the pages of books.
A piece of furniture with shelves.

Hash Codes-------------------------------------
-920681491	625576447
1244648863	1560911714
-148441025	939047783
-323823247	1237514926
-238541373	548246552

Hash Code--------------------------------------
-1794801272	401625763

Remove----------------------------------------
[]

Remove All------------------------------------
[]
*/