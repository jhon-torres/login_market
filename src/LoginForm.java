import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class LoginForm extends JDialog{
    private JTextField emailFT;
    private JButton cancelButton;
    private JButton OKButton;
    private JPanel loginPanel;
    private JPasswordField passwordTF;

    public LoginForm (JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(640,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email=emailFT.getText();
                String password=String.valueOf(passwordTF.getPassword());

                user=getAuthenticationUser(email, password);

                if(user!=null){
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(
                            LoginForm.this,"email o password incorrectos",
                            "Intente nuevamente",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
    }

    //elementos de autenticacion
    public User user;

    private User getAuthenticationUser(String email, String password){
        User user = null;
        
        final String DB_URL="jdbc:mysql://localhost/mitienda?serverTimezon=UTC";
        final String USERNAME="rooT";
        final String PASSWORD="";
        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);
        } catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }
}
