import java.util.*;

public class Main {
    Map<String, People> people; //Name, People object
    Map<String, String> accounts; //id, name
    BookLibrary library; //this is just to get book name by number and vice versa

    Main() {
        people = new HashMap<String, People>();
        accounts = new HashMap<String, String>();
        library = new BookLibrary();
    }
    //setters
    public void setAccounts(String id, String name) {
        accounts.put(id, name);
        people.put(name, new People(name, id));
    }
    //getters
    public People getPeopleData(String name) {
        return people.get(name);
    }
    public String getAccounts(String id) {
        return accounts.get(id);
    }
    //deleter
    public void deleteAccount(String id, String name) {
        accounts.remove(id);
        people.remove(name);
    }
    //data validation person
    public boolean isPerson(String id) {
        if (accounts.containsKey(id)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) { //dont do a Main object
        GUI guiCreater = new GUI();
        guiCreater.createLibraryGUI();
    }
}