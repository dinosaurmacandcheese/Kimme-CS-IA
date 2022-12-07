import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

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
                inputField.setText("");
                homeFrame.dispose();
                createActionsGUI(getAccounts(input));
            }
        });

        homeFrame.setSize(400,500);
        homeFrame.add(homePanel);
        homePanel.add(instructions);
        homePanel.add(inputField);

        homeFrame.setVisible(true);
    }
    public void createActionsGUI(String name) {
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
                if (library.isBook(input)) {
                    if (person.owedBooks.contains(input)) {
                        person.returnBook(input);
                    } else if (!person.owedBooks.contains(input)) {
                        person.takeBook(input);
                    } else {
                        System.out.println("Something went wrong");
                    }
                } else {
                    System.out.println("This is not a book!");
                }
                System.out.println(person.owedBooks);
            }
        });

        actionsFrame.setSize(400,500);
        actionsFrame.add(actionsPanel);
        actionsPanel.add(instructions);
        actionsPanel.add(inputField);

        actionsFrame.setVisible(true);
    }
}
