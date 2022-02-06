import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteTeacher extends JFrame implements ActionListener {
    //declarations
    Container container = getContentPane();
    //labels
    JLabel firstName = new JLabel("First Name: ");
    JLabel lastName = new JLabel("Last Name: ");
    //input components
    JTextField fNameText = new JTextField();
    JTextField lNameText = new JTextField();
    //buttons
    ImageIcon img = new ImageIcon("images/left-arrow.png");
    JButton returnButton =new JButton(img);
    JButton deleteButton = new JButton("Delete");

    public DeleteTeacher(){
        super();
        this.deleteTeacherProperties();
        this.setLayoutManager();
        this.setLocationAndSize();
        this.addComponentsToContainer();
        this.addActionEvent();

    }
    public void deleteTeacherProperties() {
        this.setTitle("Delete Teacher");
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
        firstName.setBounds(150, 100, 150, 30);
        lastName.setBounds(150, 150, 150, 30);
        //inputs
        fNameText.setBounds(300,100,200,30);
        lNameText.setBounds(300,150,200,30);
        //buttons
        deleteButton.setBounds(370,250,100,25);
        returnButton.setBounds(10,10,30,30);
    }
    public void addComponentsToContainer() {
        //add labels
        container.add(firstName);
        container.add(lastName);
        //add inputs
        container.add(fNameText);
        container.add(lNameText);
        //add buttons
        container.add(returnButton);
        container.add(deleteButton);
    }
    public void addActionEvent() {
        deleteButton.addActionListener(this);
        returnButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of  return button
        if (e.getSource() == returnButton) {
            this.dispose();
            new Teacher().setVisible(true);
        }
        //Coding Part of delete Button : to delete that teacher
        if (e.getSource() == deleteButton){
            Connector C =new Connector();
            String fn= fNameText.getText();
            String ln=lNameText.getText();
            try {
                C.deleteFromDatabase("teacher","first_name='"+fn+"' and last_name='"+ln+"'");
                JOptionPane.showMessageDialog(this, "Teacher deleted successfully");
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }


        }

    }
}
