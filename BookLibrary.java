import java.util.*;

public class BookLibrary { 
    Dictionary<String, String> bookDictionary = new Hashtable<String, String>();//bookID, book name
    BookLibrary() {
        bookDictionary.put("1012390123", "The Handsmaid Tale");
    }
    //no setters here it'll be like "admin" can only change the library basically anyone who knows how to code
    //getters
    public String getBookNameByID(String id) {
        try {
            return bookDictionary.get(id);
        } catch (Exception e) {
            return null;
        }
    }
    public String getBookIDByName(String name) {
        List<String> booksIDList = new ArrayList<String>(((Hashtable<String, String>) bookDictionary).keySet());
        for (int i = 0; i < booksIDList.size(); i++) {
            if (booksIDList.get(i).equals(name)) {
                return booksIDList.get(i);
            }
        }
        return null;
    }
}
