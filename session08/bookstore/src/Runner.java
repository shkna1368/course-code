import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.setName("Jang o solh");
        b1.setAuthor("Leo tolstoy");
        b1.setIsbn("7858");
        b1.setPrice(56000);
        b1.setPublisher("Jim pub");

        Book b2 = new Book();
        b2.setName("Shahnameh");
        b2.setAuthor("Ferdosi");
        b2.setIsbn("69");
        b2.setPrice(98000);
        b2.setPublisher("Molavi");

        Book b3 = new Book();
        b3.setName("Java Complete edition");
        b3.setAuthor("Herbeld Schild");
        b3.setIsbn("96");
        b3.setPrice(69800);
        b3.setPublisher("Oracle");

        ArrayList<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);


        Library library = new Library();
        library.setName("Shahre Ketab");
        library.setBooks(books);
        System.out.println(library);

        System.out.println("-------------------");
        ArrayList<Book> bookList = library.getBooks();

        ArrayList<Book> filteredBook = new ArrayList<>();
        bookList.forEach(book -> {

            if (book.getPrice() > 69000) {
                filteredBook.add(book);

            }


        });


        System.out.println("-----------");
        System.out.println("filter books are:" + filteredBook);


    }
}
