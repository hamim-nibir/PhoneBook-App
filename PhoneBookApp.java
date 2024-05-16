import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

class Person{
    String name, address, phone_number;

    public Person(String name, String address, String phone_number) {
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return  '<' + name + "> " +
                "<" + address + "> " +
                "<" + phone_number + "> ";
    }
}

class Homepage implements WindowListener, ActionListener {

    ArrayList<Person> list = new ArrayList<>();
    Frame fr;
    Button Add, Show, Clear,searchButton;
    TextField searchT, nameT, phoneT, addressT;
    TextArea ta;
    Label name, address, phone;
    Homepage(){
        fr = new Frame("Phone Book");
        fr.setResizable(false);
        fr.setBackground(Color.CYAN);
        fr.setSize(650, 500);
        fr.setLayout(null);
        fr.addWindowListener(this);
        fr.setVisible(true);

        name = new Label("Name :");
        name.setBounds(10, 30, 50, 50);
        fr.add(name);

        nameT = new TextField("");
        nameT.setBounds(200, 40, 180, 50);
        fr.add(nameT);

        phone = new Label("Phone :");
        phone.setBounds(10, 160, 50, 50);
        fr.add(phone);

        phoneT = new TextField("");
        phoneT.setBounds(200, 160, 180, 50);
        fr.add(phoneT);


        address = new Label("Address : ");
        address.setBounds(10, 100, 50, 50);
        fr.add(address);

        addressT = new TextField("");
        addressT.setBounds(200, 100, 180, 50);
        fr.add(addressT);

        ta = new TextArea(10, 30);
        ta.setBounds(10,250, 370, 230);
        ta.setEditable(false);
        fr.add(ta);

        Add = new Button("Add new Contact");
        Add.setFocusable(false);
        Add.addActionListener(this);
        Add.setBounds(390, 110, 250, 30);
        Add.setBackground(Color.ORANGE);
        fr.add(Add);

        Show = new Button("Show Phone Book");
        Show.setFocusable(false);
        Show.addActionListener(this);
        Show.setBounds(390, 150, 250, 30);
        Show.setBackground(Color.ORANGE);
        fr.add(Show);

        Clear = new Button("Clear");
        Clear.setFocusable(false);
        Clear.addActionListener(this);
        Clear.setBounds(390, 190, 250, 30);
        Clear.setBackground(Color.ORANGE);
        fr.add(Clear);

        searchT = new TextField("");
        searchT.setBounds(390, 340, 250, 50);
        fr.add(searchT);

        searchButton = new Button("Search");
        searchButton.setBounds(390, 400, 250, 30);
        searchButton.setBackground(Color.ORANGE);
        searchButton.setFocusable(false);
        fr.add(searchButton);
        searchButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(Clear)){
            ta.setText("");
        }
        else if(e.getSource().equals(Add)){
            String n = nameT.getText();
            String a = addressT.getText();
            String nu = phoneT.getText();

            Person p = new Person(n, a, nu);
            list.add(p);
        }
        else if(e.getSource().equals(Show)){
            if(list.size() < 1){
                ta.setText("Phone Book is empty.");
            }
            else {
                int count = 1;
                for (Person person : list) {
                    ta.append("<" + count + "> " + person.toString() + "\n");
                    count++;
                }
            }
        }
        if(e.getSource().equals(searchButton)){
            ta.setText("");
            System.out.println("Test");
            String searchkey = searchT.getText();
            for(int i = 0 ; i < list.size() ; i++){
                Person person = list.get(i);
                if(person.name.equals(searchkey) || person.phone_number.equals(searchkey)){
                    ta.append(person.toString() + "\n");
                }
            }
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(3);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
public class PhoneBookApp {
    public static void main(String[] args) {
        Homepage run = new Homepage();
    }
}
