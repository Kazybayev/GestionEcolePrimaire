import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Vector;

public class AddStudent extends JFrame implements ActionListener {

    //declarations
    Connector C =new Connector();
    Container container = getContentPane();
        //labels
    JLabel firstName = new JLabel("First Name: ");
    JLabel lastName = new JLabel("Last Name: ");
    JLabel sex= new JLabel("Sex: ");
    JLabel email = new JLabel("Email: ");
    JLabel address = new JLabel("Address: ");
    JLabel dateBirth= new JLabel("Date Of Birth: ");
    JLabel branch = new JLabel("Branch: ");
        //input components
    JTextField fNameText = new JTextField();
    JTextField lNameText = new JTextField();
    JTextField emailText = new JTextField();
    JTextField addressText = new JTextField();
    JTextField dbirthText = new JTextField();
        //radio button for sexe
    ButtonGroup sexeRadioGroup = new ButtonGroup();
    JRadioButton sexeF = new JRadioButton("Female");
    JRadioButton sexeM = new JRadioButton("Male");
        //Branch selection list
    Vector branchList;
    {
        try {
            branchList = C.getBranchList();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    JComboBox branchSelect = new JComboBox(branchList);
        //buttons
        ImageIcon img = new ImageIcon("images/left-arrow.png");
    JButton returnButton =new JButton(img);
    JButton submitButton = new JButton("Submit");

    public AddStudent()  {
        super();
        this.addStudentProperties();
        this.setLayoutManager();
        this.setLocationAndSize();
        this.addComponentsToContainer();
        this.addActionEvent();
    }

    public void addStudentProperties() {
        this.setTitle("Add Student ");
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
        firstName.setBounds(150,50,150,30);
        lastName.setBounds(150,100,150,30);
        sex.setBounds(150,150,150,30);
        email.setBounds(150,200,150,30);
        address.setBounds(150,250,150,30);
        dateBirth.setBounds(150,300,150,30);
        branch.setBounds(150,350,150,30);
        //inputs
        fNameText.setBounds(300,50,200,30);
        lNameText.setBounds(300,100,200,30);
        sexeF.setBounds(300,150,80,30);
        sexeM.setBounds(400,150,80,30);
        emailText.setBounds(300,200,200,30);
        addressText.setBounds(300,250,200,30);
        dbirthText.setBounds(300,300,200,30);
        branchSelect.setBounds(300,350,200,30);
        branchSelect.setBackground(Color.white);
        //buttons
        submitButton.setBounds(370,420,100,25);
        returnButton.setBounds(10,10,30,30);

    }
    public void addComponentsToContainer(){
        //add labels
        container.add(firstName);
        container.add(lastName);
        container.add(sex);
        container.add(email);
        container.add(address);
        container.add(dateBirth);
        container.add(branch);
        //add sex elements
        sexeRadioGroup.add(sexeF);
        sexeRadioGroup.add(sexeM);
        container.add(sexeF);
        container.add(sexeM);
        //add inputs
        container.add(fNameText);
        container.add(lNameText);
        container.add(emailText);
        container.add(addressText);
        container.add(dbirthText);
        container.add(branchSelect);
        //add buttons
        container.add(returnButton);
        container.add(submitButton);

    }
    public void addActionEvent() {
        submitButton.addActionListener(this);
        returnButton.addActionListener(this);
        branchSelect.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String selectedBranch = branchSelect.getSelectedItem().toString();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of  return button
        if (e.getSource() == returnButton) {
            this.dispose();
            new Student().setVisible(true);
        }
       if (e.getSource() == submitButton){

            Vector addStuList = new Vector();
            addStuList.add(fNameText.getText());
            addStuList.add(lNameText.getText());
            if (sexeF.isSelected())
                addStuList.add("Female");
            else if (sexeM.isSelected())
                addStuList.add("Male");
            addStuList.add(emailText.getText());
            addStuList.add(addressText.getText());
            addStuList.add(dbirthText.getText());
           addStuList.add(branchSelect.getSelectedItem().toString());

           try {
               C.insertIntoStudent(addStuList);
               JOptionPane.showMessageDialog(this, "Student added successfully");
           } catch (SQLException ex) {
               ex.printStackTrace();
           } catch (ClassNotFoundException ex) {
               ex.printStackTrace();
           }

        }

        }

    }




