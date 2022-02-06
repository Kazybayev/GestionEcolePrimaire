import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class AddTeacher extends JFrame implements ActionListener {

    //declarations
    Container container = getContentPane();
    //labels
    JLabel firstName = new JLabel("First Name: ");
    JLabel lastName = new JLabel("Last Name: ");
    JLabel email = new JLabel("Email: ");
    JLabel field = new JLabel("Field: ");
    JLabel salary = new JLabel("Salary: ");
    //input components
    JTextField fNameText = new JTextField();
    JTextField lNameText = new JTextField();
    JTextField emailText = new JTextField();
    JTextField fieldText = new JTextField();
    JTextField salaryText = new JTextField();
    //buttons
    ImageIcon img = new ImageIcon("images/left-arrow.png");
    JButton returnButton = new JButton(img);
    JButton submitButton = new JButton("Submit");

    //Constructor
    public AddTeacher() {
        super();
        this.addTeacherProperties();
        this.setLayoutManager();
        this.setLocationAndSize();
        this.addComponentsToContainer();
        this.addActionEvent();

    }

    public void addTeacherProperties() {
        this.setTitle("Add Teacher ");
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
        firstName.setBounds(150, 50, 150, 30);
        lastName.setBounds(150, 100, 150, 30);
        email.setBounds(150, 150, 150, 30);
        field.setBounds(150, 200, 150, 30);
        salary.setBounds(150, 250, 150, 30);
        //inputs
        fNameText.setBounds(300, 50, 200, 30);
        lNameText.setBounds(300, 100, 200, 30);
        emailText.setBounds(300, 150, 200, 30);
        fieldText.setBounds(300, 200, 200, 30);
        salaryText.setBounds(300,250,200,30);
        //buttons
        submitButton.setBounds(370, 420, 100, 25);
        returnButton.setBounds(10, 10, 30, 30);

    }

    public void addComponentsToContainer() {
        //add labels
        container.add(firstName);
        container.add(lastName);
        container.add(email);
        container.add(field);
        container.add(salary);
        //add inputs
        container.add(fNameText);
        container.add(lNameText);
        container.add(emailText);
        container.add(fieldText);
        container.add(salaryText);
        //add buttons
        container.add(returnButton);
        container.add(submitButton);

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
            new Teacher().setVisible(true);
        }
        if (e.getSource() == submitButton) {
            //yrecuperi les données fi list
            Vector addTchList = new Vector();
            addTchList.add(fNameText.getText());
            addTchList.add(lNameText.getText());
            addTchList.add(emailText.getText());
            addTchList.add(fieldText.getText());
            addTchList.add(Integer.parseInt(salaryText.getText()));
            //yib3ath yinserihom
            Connector C = new Connector();
            try {
                C.insertIntoTeacher(addTchList);
                JOptionPane.showMessageDialog(this, "Teacher added successfully");
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        }
    }
}
