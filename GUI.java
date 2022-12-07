import javax.swing.*;
import java.awt.event.*;

public class GUI extends Main {
    BookLibrary library;
    GUI(){
        library = new BookLibrary();
        setAccounts("656255", "Jose");
    }
    public void createLibraryGUI() {
        JFrame homeFrame = new JFrame("Home");
        JPanel homePanel = new JPanel();
        JTextArea instructions = new JTextArea("Please input the student id: ");

        JTextField inputField = new JTextField(10);
        inputField.setEditable(true);
        inputField.addActionListener( new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (isPerson(input)) { //check if this is a registered person
                    inputField.setText("");
                    homeFrame.dispose();
                    createActionsGUI(getAccounts(input)); //create the other Gui that will only check for the person they input
                } else { 
                    JOptionPane.showMessageDialog(homeFrame, "Student ID not found"); //in case they put an invalid id, tell them
                }
            }
        });

        homeFrame.setSize(400,500);
        homeFrame.add(homePanel);
        homePanel.add(instructions);
        homePanel.add(inputField);

        homeFrame.setVisible(true);
    }
    public void createActionsGUI(String name) { //create the GUi that checks books in and returns them and stuff
        JFrame actionsFrame = new JFrame("Books");
        JPanel actionsPanel = new JPanel();
        JTextArea instructions = new JTextArea("Please input the book serial number or exact name: ");

        JTextField inputField = new JTextField(10);
        inputField.setEditable(true);
        inputField.addActionListener( new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                inputField.setText("");
                People person = getPeopleData(name);
                if (library.isBook(input)) { //check if valid book
                    try {
                        Integer.parseInt(input); //check if they input the serial number
                    } catch (Exception x) {
                        input = library.getBookIDByName(input); //change the input into the serial number in case they did not
                    }
                    if (person.owedBooks.contains(input)) { //check if the person has the book with them or not
                        person.returnBook(input); //if they do have it with them, they "return" it removing it from their list
                    } else if (!person.owedBooks.contains(input)) { 
                        person.takeBook(input); //if they do not have it with them, they "check the book out," adding it into their list
                    } else {
                        System.out.println("Something went wrong"); //just in case something goes wrong
                    }
                } else {
                    System.out.println("This is not a book!");
                    JOptionPane.showMessageDialog(actionsFrame, "Book not found"); //tell the user that their input is not a valid but
                }
                System.out.println(person.owedBooks);
            }
        });

        JButton goHome = new JButton("Go back");
        goHome.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionsFrame.dispose();
                createLibraryGUI();
            }
        });

        actionsFrame.setSize(400,500);
        actionsFrame.add(actionsPanel);
        actionsPanel.add(instructions);
        actionsPanel.add(inputField);
        actionsPanel.add(goHome);

        actionsFrame.setVisible(true);
    }
}
