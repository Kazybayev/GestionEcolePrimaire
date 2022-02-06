import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student extends JFrame implements ActionListener {

    Container container = getContentPane();
    JButton addButton = new JButton("ADD A STUDENT ");
    JButton updateButton = new JButton("UPDATE STUDENT INFO");
    JButton deleteButton = new JButton("DELETE A STUDENT");
    //buttons
    ImageIcon img = new ImageIcon("images/left-arrow.png");
    JButton returnButton =new JButton(img);

    public Student(){
        super();
        this.studentProperties();
        this.setLayoutManager();
        this.setLocationAndSize();
        this.addComponentsToContainer();
        this.addActionEvent();
    }

    //Student Properties :
    public void studentProperties() {
        this.setTitle("Student Interface");
        this.setBounds(200, 200, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public void setLayoutManager() {

        container.setLayout(null);
        container.setBackground(Color.white);
    }
    public void setLocationAndSize() {
        addButton.setBounds(200, 180, 200, 30);
        updateButton.setBounds(200, 230, 200, 30);
        deleteButton.setBounds(200, 280, 200, 30);
        returnButton.setBounds(10,10,30,30);
    }
    public void addComponentsToContainer(){
        container.add(updateButton);
        container.add(addButton);
        container.add(deleteButton);
        container.add(returnButton);
    }
    public void addActionEvent() {
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        returnButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of  return button
        if (e.getSource() == returnButton) {
            this.dispose();
            new Menu().setVisible(true);
        }
        //Coding Part of Student add button
        if (e.getSource() == addButton) {
            this.dispose();
            new AddStudent().setVisible(true);
        }
        if (e.getSource()== updateButton){
            this.dispose();
            new UpdateStudent().setVisible(true);
        }
        if (e.getSource() == deleteButton){
            this.dispose();
            new DeleteStudent().setVisible(true);
        }
        }


}
