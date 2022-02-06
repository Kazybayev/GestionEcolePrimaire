import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Action_CRUD extends JFrame implements ActionListener {

    //Object declaration
    Container container = getContentPane();
    JLabel chooseYourActionLabel = new JLabel("Choose Your Action");
    JButton addButton = new JButton();
    JButton updateButton = new JButton();
    JButton deleteButton = new JButton();
    JButton logoutButton = new JButton("Log Out");

    //constructeur
    public Action_CRUD(String textSp) {
        super();
        this.crudProperties();
        this.setButtonText(textSp);
        this.setLayoutManager();
        this.setLocationAndSize();
        this.addComponentsToContainer();
        this.addActionEvent();
    }
    //setText of Button
    public void setButtonText(String textSp){
        addButton.setText("Add "+textSp);
        updateButton.setText("Update "+textSp);
        deleteButton.setText("Delete "+textSp);
    }

    //Action_CRUD Properties :
    public void crudProperties() {
        this.setTitle("CRUD");
        this.setBounds(10, 10, 650, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    public void setLayoutManager() {
        container.setLayout(null);
    }
    public void setLocationAndSize() {
        chooseYourActionLabel.setBounds(275, 30, 200, 30);
        addButton.setBounds(225, 80, 200, 30);
        deleteButton.setBounds(225, 130, 200, 30);
        updateButton.setBounds(225, 180, 200, 30);
        logoutButton.setBounds(225, 280, 200, 30);
    }
    public void addComponentsToContainer() {
        container.add(chooseYourActionLabel);
        container.add(addButton);
        container.add(deleteButton);
        container.add(updateButton);
        container.add(logoutButton);
    }
    public void addActionEvent() {
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }
    //Actions
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of ADD button
        if (e.getSource() == addButton) {


        }
        //Coding Part of UPDATE button
        else if (e.getSource() == updateButton) {

        }
        //Coding Part of DELETE button
        else if (e.getSource() == deleteButton) {

        }
        //Coding Part of Log Out button
        if (e.getSource() == logoutButton) {
            this.dispose();
            new LoginFrame().setVisible(true);
        }

    }
}
