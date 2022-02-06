import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class Branch extends JFrame implements ActionListener {

    Container container = getContentPane();
    //labels
    JLabel branchName = new JLabel("Branch Name: ");
    JLabel duration = new JLabel("Duration : ");
    JLabel semester= new JLabel("semesters ");
    //input components
    JTextField branchNameField = new JTextField();
    JTextField durationField = new JTextField();
    //buttons
    ImageIcon img = new ImageIcon("images/left-arrow.png");
    JButton returnButton = new JButton(img);
    JButton submitButton = new JButton("Submit");

    //Constructor
    public Branch() {
        super();
        this.branchProperties();
        this.setLayoutManager();
        this.setLocationAndSize();
        this.addComponentsToContainer();
        this.addActionEvent();

    }

    public void branchProperties() {
        this.setTitle("Add Branch ");
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
        branchName.setBounds(150, 100, 150, 30);
        duration.setBounds(150, 150, 150, 30);
        semester.setBounds(380, 150, 150, 30);
        //inputs
        branchNameField.setBounds(300, 100, 200, 30);
        durationField.setBounds(300, 150, 70, 30);
        //buttons
        submitButton.setBounds(350, 200, 100, 25);
        returnButton.setBounds(10, 10, 30, 30);
    }
    public void addComponentsToContainer() {
        //add labels
        container.add(branchName);
        container.add(duration);
        container.add(semester);
        //add inputs
        container.add(branchNameField);
        container.add(durationField);
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
            new Menu().setVisible(true);
        }
        if (e.getSource() == submitButton) {
            //insert data
            Connector C = new Connector();
            String query= "INSERT INTO branch VALUES('" +branchNameField.getText()+"',"
                    +durationField.getText()+")";
            try {
                C.insertIntoBranch(query);
                JOptionPane.showMessageDialog(this, "Branch added successfully");
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }


        }
    }


}
