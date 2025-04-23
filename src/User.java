import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.Objects;

public class User {
    public User(){
        JDialog dialog=new JDialog();
        ImageIcon i=new ImageIcon(Objects.requireNonNull(getClass().getResource("user.jpg")));
        JLabel l=new JLabel();
        JButton admin=new JButton("Admin");
        JButton user=new JButton("User");
        JPanel p=new JPanel(){
            private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("background.png"))).getImage();
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
            }
        };

        Image ni= i.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);

        l.setIcon(new ImageIcon(ni));
        l.setBounds(200,100,200,200);

        admin.setFocusable(false);
        admin.setBounds(150,350,140,50);
        admin.setFont(new Font("ARIAL",Font.ITALIC,22));
        admin.setForeground(Color.WHITE);
        admin.setBackground(Color.black);

        admin.addActionListener(e -> {
            JDialog login = new JDialog();
            JButton lb= new JButton("Login");
            JTextField adminnt=new JTextField();
            JPasswordField adminpt=new JPasswordField();
            JLabel adminnl=new JLabel("Admin Name :");
            JLabel adminpl=new JLabel("Password :");
            JButton changepass = new JButton("change password?");
            JPanel q=new JPanel(){
                private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("background.png"))).getImage();
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
                }
            };

            changepass.setOpaque(false);
            changepass.setFont(new Font("MV BOLI",Font.PLAIN,15));
            changepass.setFocusable(false);
            changepass.setBounds(100,500,190,40);
            changepass.setBackground(Color.white);
            changepass.setForeground(Color.BLUE);
            changepass.setBorder(new LineBorder(Color.white, 0));

            changepass.addActionListener(e1 ->new changepassword(Main.adminpass));

            adminnl.setFont(new Font("MV BOLI",Font.PLAIN,22));
            adminnl.setForeground(Color.pink);
            adminnl.setBounds(120,150,160,50);

            adminnt.setBounds(290,155,160,40);
            adminnt.setFont(new Font("MV BOLI",Font.PLAIN,18));

            adminpl.setFont(new Font("MV BOLI",Font.PLAIN,22));
            adminpl.setForeground(Color.pink);
            adminpl.setBounds(120,210,160,50);

            adminpt.setBounds(290,215,160,40);
            adminpt.setFont(new Font("MV BOLI",Font.PLAIN,18));

            lb.setBounds(230,300,140,45);
            lb.setFocusable(false);
            lb.setFont(new Font("MV BOLI",Font.PLAIN,22));

            lb.addActionListener(e2 -> {
                if((adminnt.getText().equals(Main.adminname)) && (new String(adminpt.getPassword()).equals(Main.adminpass))){
                    login.dispose();
                    new admin();
                }
                if(!(adminnt.getText().equals(Main.adminname)))
                    JOptionPane.showMessageDialog(login,"Wrong admin name entered","Error",JOptionPane.WARNING_MESSAGE);
                if((adminnt.getText().equals(Main.adminname)) && !(new String(adminpt.getPassword()).equals(Main.adminpass)))
                    JOptionPane.showMessageDialog(login,"Wrong password entered","Error",JOptionPane.WARNING_MESSAGE);
                adminnt.setText("");
                adminpt.setText("");
            });

            login.setContentPane(q);
            login.setSize(600,600);
            login.add(lb);
            login.add(adminnl);
            login.add(adminnt);
            login.add(adminpl);
            login.add(adminpt);
            login.add(changepass);
            login.setTitle("LOGIN");
            login.setLocationRelativeTo(null);
            login.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            login.setLayout(null);
            login.setModal(true);
            login.setVisible(true);
        });

        user.setFocusable(false);
        user.setBounds(310,350,140,50);
        user.setFont(new Font("ARIAL",Font.ITALIC,22));
        user.setForeground(Color.WHITE);
        user.setBackground(Color.BLACK);

        user.addActionListener(e -> {
            JDialog login = new JDialog();
            JButton lb= new JButton("Login");
            JTextField usernt=new JTextField();
            JPasswordField userpt=new JPasswordField();
            JLabel usernl=new JLabel("User Name :");
            JLabel userpl=new JLabel("Password :");
            JButton changepass = new JButton("change password?");
            JPanel q=new JPanel(){
                private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("background.png"))).getImage();
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
                }
            };

            changepass.setOpaque(false);
            changepass.setFont(new Font("MV BOLI",Font.PLAIN,15));
            changepass.setFocusable(false);
            changepass.setBounds(100,500,190,40);
            changepass.setBackground(Color.white);
            changepass.setForeground(Color.BLUE);
            changepass.setBorder(new LineBorder(Color.white, 0));

            changepass.addActionListener(e1 ->new changepassword(Main.userpass));

            usernl.setFont(new Font("MV BOLI",Font.PLAIN,22));
            usernl.setForeground(Color.pink);
            usernl.setBounds(120,150,160,50);

            usernt.setBounds(290,155,160,40);
            usernt.setFont(new Font("MV BOLI",Font.PLAIN,18));

            userpl.setFont(new Font("MV BOLI",Font.PLAIN,22));
            userpl.setForeground(Color.pink);
            userpl.setBounds(120,210,160,50);

            userpt.setBounds(290,215,160,40);
            userpt.setFont(new Font("MV BOLI",Font.PLAIN,18));

            lb.setBounds(230,300,140,45);
            lb.setFocusable(false);
            lb.setFont(new Font("MV BOLI",Font.PLAIN,22));

            lb.addActionListener(e2 -> {
                if((usernt.getText().equals(Main.username)) && (new String(userpt.getPassword()).equals(Main.userpass))){
                    login.dispose();
                    new customer();
                }
                if(!(usernt.getText().equals(Main.username)))
                    JOptionPane.showMessageDialog(login,"Wrong user name entered","Error",JOptionPane.WARNING_MESSAGE);
                if((usernt.getText().equals(Main.username)) && !(new String(userpt.getPassword()).equals(Main.userpass)))
                    JOptionPane.showMessageDialog(login,"Wrong password entered","Error",JOptionPane.WARNING_MESSAGE);
                usernt.setText("");
                userpt.setText("");
            });

            login.setContentPane(q);
            login.setSize(600,600);
            login.add(lb);
            login.add(usernl);
            login.add(userpl);
            login.add(usernt);
            login.add(userpt);
            login.add(changepass);
            login.setTitle("LOGIN");
            login.setLocationRelativeTo(null);
            login.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            login.setLayout(null);
            login.setModal(true);
            login.setVisible(true);
        });

        dialog.setContentPane(p);
        dialog.setLayout(null);
        dialog.getContentPane().setBackground(Color.GRAY);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(650,650);
        dialog.setModal(true);
        dialog.setLocationRelativeTo(null);
        dialog.setTitle("DASHBOARD");
        dialog.add(l);
        dialog.add(admin);
        dialog.add(user);
        dialog.setVisible(true);
    }
}
