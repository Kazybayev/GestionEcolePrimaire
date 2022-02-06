import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    //Object declaration
    Container container = getContentPane();
    JLabel welcomeLabel = new JLabel("Welcome MahaEya");
    //buttons
    JButton studentButton = new JButton("Student");
    JButton teacherButton = new JButton("Teacher");
    JButton branchButton = new JButton("Branch");
    JButton courseButton = new JButton("Course");
    JButton logoutButton = new JButton("Log Out");
    //images
    ImageIcon student = new ImageIcon("images/student.png");
    ImageIcon teacher = new ImageIcon("images/teacher.png");
    ImageIcon branch = new ImageIcon("images/branch.png");
    ImageIcon course = new ImageIcon("images/class.png");
    JLabel studentImg= new JLabel(student);
    JLabel teacherImg= new JLabel(teacher);
    JLabel branchImg = new JLabel(branch);
    JLabel courseImg = new JLabel(course);

    //constructeur
    public Menu() {
        super();
        this.menuProperties();
        this.setLayoutManager();
        this.setLocationAndSize();
        this.addComponentsToContainer();
        this.addActionEvent();
    }
    //Menu Properties :

    public void menuProperties() {
        this.setTitle("Menu");
        this.setBounds(200, 200, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        welcomeLabel.setBounds(185, 30, 400, 30);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.BLUE);
        studentImg.setBounds(90,70,150,150);
        teacherImg.setBounds(370,70,150,150);
        studentButton.setBounds(120, 225, 100, 30);
        teacherButton.setBounds(402, 225, 100, 30);
        branchImg.setBounds(90,270,150,150);
        branchButton.setBounds(120, 420, 100, 30);
        courseImg.setBounds(370,270,150,150);
        courseButton.setBounds(402, 420, 100, 30);
        logoutButton.setBounds(50, 500, 100, 30);
    }

    public void addComponentsToContainer() {
        container.add(welcomeLabel);
        container.add(studentButton);
        container.add(teacherButton);
        container.add(branchButton);
        container.add(courseButton);
        container.add(logoutButton);
        container.add(studentImg);
        container.add(teacherImg);
        container.add(branchImg);
        container.add(courseImg);
    }

    public void addActionEvent() {
        studentButton.addActionListener(this);
        teacherButton.addActionListener(this);
        branchButton.addActionListener(this);
        courseButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }

    //Actions
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of Student button
        if (e.getSource() == studentButton) {
            new Student().setVisible(true);
            this.dispose();
        }
        //Coding Part of Teacher button
        else if (e.getSource() == teacherButton) {
            new Teacher().setVisible(true);
            this.dispose();
               }
        //Coding Part of Branch button
        else if (e.getSource() == branchButton) {
            new Branch().setVisible(true);
            this.dispose();
                   }
        //Coding Part of Course button
        else if (e.getSource() == courseButton) {
            new Course().setVisible(true);
            this.dispose();
        }
        //Coding Part of Log Out button
        if (e.getSource() == logoutButton) {
            this.dispose();
            new LoginFrame().setVisible(true);
        }

    }
}