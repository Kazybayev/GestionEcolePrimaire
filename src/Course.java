import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class Course extends JFrame implements ActionListener {
    Container container = getContentPane();
    Connector C = new Connector();
    //labels
    JLabel courseName = new JLabel("Course Name: ");
    JLabel teacher = new JLabel("Teacher : ");
    //input components
    JTextField courseNameField = new JTextField();
    //buttons
    ImageIcon img = new ImageIcon("images/left-arrow.png");
    JButton returnButton = new JButton(img);
    JButton submitButton = new JButton("Submit");
    // selection list
    Vector<Teachers> teacherList;
    Vector v =new Vector();
    {

        try {
            teacherList = C.getTeacherList();
            for(int i = 0; i<teacherList.size();i++){
                v.add(teacherList.get(i).firstName+ " "+ teacherList.get(i).lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    JComboBox teacherSelect = new JComboBox(v);

    //Constructor
    public Course() {
        super();
        this.courseProperties();
        this.setLayoutManager();
        this.setLocationAndSize();
        this.addComponentsToContainer();
        this.addActionEvent();

    }

    public void courseProperties() {
        this.setTitle("Add Course ");
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
        courseName.setBounds(150, 100, 150, 30);
        teacher.setBounds(150, 150, 150, 30);
        //inputs
        courseNameField.setBounds(300, 100, 200, 30);
        teacherSelect.setBounds(300, 150, 200, 30);
        //buttons
        submitButton.setBounds(350, 200, 100, 25);
        returnButton.setBounds(10, 10, 30, 30);
    }
    public void addComponentsToContainer() {
        //add labels
        container.add(courseName);
        container.add(teacher);
        //add inputs
        container.add(courseNameField);
        container.add(teacherSelect);
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
            new Menu().setVisible(true);
            this.dispose();
        }
          if (e.getSource() == submitButton) {
            //insert data
            int id= teacherList.get(teacherSelect.getSelectedIndex()).id;
            String query= "INSERT INTO course VALUES(nextval('seq_course'),'" +courseNameField.getText()+"',"
                    +id+")";
            try {
                C.insertIntoCourse(query);
                JOptionPane.showMessageDialog(this, "Course added successfully");
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }


        }
    }
}
