import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener{
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    //
    ImageIcon img = new ImageIcon("images/login.png");
    JLabel login_icon = new JLabel();

    //constructeur
    public LoginFrame() {
        super();
        this.loginFrameProperties();
        this.setLayoutManager();
        this.setLocationAndSize();
        this.addComponentsToContainer();
        this.addActionEvent();

    }

    //Login Properties :

    public void loginFrameProperties(){
        this.setTitle("Login Form");
        this.setBounds(200, 200, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    public void setLayoutManager() {

        container.setLayout(null);
        container.setBackground(Color.white);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(150, 270, 100, 30);
        passwordLabel.setBounds(150, 320, 100, 30);
        userTextField.setBounds(270, 270, 150, 30);
        passwordField.setBounds(270, 320, 150, 30);
        showPassword.setBounds(270, 360, 150, 30);
        loginButton.setBounds(150, 420, 100, 30);
        resetButton.setBounds(270, 420, 100, 30);
        login_icon.setIcon(img);
        login_icon.setBounds(230,90,150,150);

    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(login_icon);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
    //Actions
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("") && pwdText.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Fields Required");
            } else if (userText.equalsIgnoreCase("mahaeya") && pwdText.equalsIgnoreCase("mahaeya")) {
                //JOptionPane.showMessageDialog(this, "Login Successful");
                this.setVisible(false);
                Menu menu=new Menu();
                menu.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }


}




