import java.util.*;

public class People {
    String name, id;
    List<String> owedBooks;
    People(String name, String id) {
        this.name = name;
        this.id = id;
        this.owedBooks = new ArrayList<String>();
    }
    public void returnBook(String bookID) {
        this.owedBooks.remove(bookID);
    }
    public void takeBook(String bookID) {
        this.owedBooks.add(bookID);
    }
}
