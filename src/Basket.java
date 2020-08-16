import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.HashSet;

/**
 * Created by William Flageol on 2020-04-30.
 */
public class Basket {
    private int numberBooks;
    private boolean isEmpty = true;
    private Book[] Books;

    public Basket(Book[] books) {
        this.numberBooks = books.length;
        this.isEmpty = books.length == 0;
        this.Books = books;
    }

    public void printBasket() {
        if (!this.isEmpty) {
            // System.out.println("Basket lenght "+numberBooks);
            // System.out.println("Books table lenght "+Books.length);
            for (Book book : this.Books) {
                book.printBook();
            }
        } else {
            System.out.println("none");
        }
    }

    // returns how many books are equals to the specidied book
    public long howMany(Book searchedbook) {
        int counter = 0;
        for (Book book : Books) {
            if (book.equals(searchedbook)) {
                counter++;
            }
        }
        return counter;
    }

    public long howManyDifferent() {

        List<Book> listWithoutDuplicates = Arrays.asList(this.Books).stream().distinct().collect(Collectors.toList());

        return listWithoutDuplicates.size();
    }

    public int howManyBooks() {
        return this.numberBooks;
    }

    public boolean isEmpty() {
        return this.isEmpty;

    }

    public Basket removeBooks() {

        Book[] newbooks = {};

        Basket basket = new Basket(newbooks);
        return basket;
    }

    // removeDifferent retire un nombre de livres différents du panier
    public Basket removeDifferent(int quantity) {

        //copying my books inside an arraylist
        final ArrayList<Book> list = new ArrayList<>(Arrays.asList(this.Books));
        //deleting 1 instances of different books under quantity amount
        new HashSet<>(Arrays.asList(this.Books)).stream().limit(quantity).forEach(list::remove);

        // creating the new basket without already paid books
        Book[] newbooks = new Book[list.size()];
        newbooks = list.toArray(newbooks);
        Basket newbasket = new Basket(newbooks);
        return newbasket;
    }
}
