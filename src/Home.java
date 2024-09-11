import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home implements ActionListener{
//   ____________________________________Using constructor_____________________________________________________________
    JFrame frame1;
    JPanel panel,panel1;
    JLabel label,label1,label2;
    JButton button;


    Home(){
        frame1 = new JFrame();
        panel = new JPanel();
        panel1 = new JPanel();
        label = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        button = new JButton();

        frame1.setLayout(null);
        panel.setLayout(null);
        panel1.setLayout(null);

        panel.setBounds(0,0,800,300);
        panel1.setBounds(0,300,800,200);

        panel.setBackground(new Color(0xE0D7E0));
        panel1.setBackground(new Color(0xE0D7E0));

        ImageIcon img = new ImageIcon("JavaNotepad/src/img2.png");
        ImageIcon img2 = new ImageIcon("JavaNotepad/src/images.png");
        if (img2.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.out.println("Error loading image.");
        }
        

        label.setIcon(img2);
        label.setBounds(250,35,500,300);

        label1.setText("Hello Everyone !!! " );
        label2.setText( "Here You can Create , Write , Open a File and many more...");
        button.setText("Enter");
        button.setFocusable(false);

        label1.setBounds(180,10,500,50);
        label2.setBounds(45,10,800,50);
        button.setBounds(260,70,200,50);

        Font f1 = new Font(" 'Tilt Neon', cursive",Font.BOLD,50);
        label1.setFont(f1);
        Font f2 = new Font(" 'Tilt Neon', cursive",Font.PLAIN,25);
        label2.setFont(f2);
        Font f3 = new Font(" 'Tilt Neon', cursive",Font.BOLD,25);
        button.setFont(f3);

        button.addActionListener(this);


        panel.add(label);
        panel.add(label1);
        panel1.add(label2);
        panel1.add(button);


        frame1.add(panel);
        frame1.add(panel1);
        frame1.setIconImage(img.getImage());
        frame1.setSize(800,500);
        frame1.setTitle("Notepad_Project | Java");
        frame1.setFont(f3);

        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            new Notepad_Java();
            frame1.dispose();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}