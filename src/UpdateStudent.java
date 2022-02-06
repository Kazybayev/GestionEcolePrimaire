import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class UpdateStudent extends JFrame implements ActionListener {
    //declarations
    Container container = getContentPane();
    //labels
    JLabel FirstName = new JLabel("First Name: ");
    JLabel LastName = new JLabel("Last Name: ");
    JLabel text1 = new JLabel("Provide the student name: ") ;
    JLabel text2 = new JLabel("Enter the new address");
    JLabel address = new JLabel("Address: ");
    //input components
    JTextField fNameText = new JTextField();
    JTextField lNameText = new JTextField();
    JTextField addressField = new JTextField();
    //buttons
    ImageIcon img = new ImageIcon("images/left-arrow.png");
    JButton returnButton = new JButton(img);
    JButton submitButton = new JButton("Submit");

    //Constructor
    public UpdateStudent() {
        super();
        this.updateTeacherProperties();
        this.setLayoutManager();
        this.setLocationAndSize();
        this.addComponentsToContainer();
        this.addActionEvent();
    }
    public void updateTeacherProperties() {
        this.setTitle("Update Student ");
        this.setBounds(200, 200, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    public void setLayoutManager() {
        container.setLayout(null);
        container.setBackground(Color.white);
    }
    public void setLocationAndSize() {
        //labels
        text1.setBounds(120,20,300,30);
        FirstName.setBounds(150, 50, 150, 30);
        LastName.setBounds(150, 100, 150, 30);
        text2.setBounds(120,150,300,30);
        address.setBounds(150,200,100,30);
        //inputs
        fNameText.setBounds(300, 50, 200, 30);
        lNameText.setBounds(300, 100, 200, 30);
        addressField.setBounds(300,200,100,30);
        //buttons
        submitButton.setBounds(370, 420, 100, 25);
        returnButton.setBounds(10, 10, 30, 30);
    }
    public void addComponentsToContainer() {
        //add labels
        container.add(FirstName);
        container.add(LastName);
        container.add(text1);
        container.add(text2);
        container.add(address);
        //add inputs
        container.add(fNameText);
        container.add(lNameText);
        container.add(addressField);
        //add buttons
        container.add(submitButton);
        container.add(returnButton);


    }
    public void addActionEvent() {
        submitButton.addActionListener(this);
        returnButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of  return button
        if (e.getSource() == returnButton) {
            this.dispose();
            new Student().setVisible(true);
        }

        if (e.getSource() == submitButton) {
            Connector C = new Connector();
            String query= "UPDATE student SET address='"+addressField.getText()+"' ";
            query+= "WHERE first_name='"+fNameText.getText()+"' and last_name='"+lNameText.getText()+"'";
            try {
                C.updateDatabase(query);
                JOptionPane.showMessageDialog(this, "Student updated successfully");
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        }
    }

}