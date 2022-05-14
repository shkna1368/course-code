import javax.swing.*;
import java.awt.*;

public class CalculatorLayout  extends JFrame {

    public CalculatorLayout() {

        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Container container = getContentPane();

        container.setLayout(null);


        JLabel title = new JLabel("Registration Lable");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);

        container.add(title);


        setVisible(true);
    }
}
