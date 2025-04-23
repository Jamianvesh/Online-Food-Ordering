import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class changepassword {
    public changepassword(String pass) {
        JDialog cp = new JDialog();
        JLabel op = new JLabel("Old password :");
        JLabel np = new JLabel("New password :");
        JTextField opt = new JTextField();
        JTextField npt = new JTextField();
        JButton confirm = new JButton("Confirm");
        JPanel p=new JPanel(){
            private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("background.png"))).getImage();
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
            }
        };

        op.setFont(new Font("MV BOLI",Font.PLAIN,22));
        op.setForeground(Color.pink);
        op.setBounds(120,150,160,50);

        opt.setBounds(290,155,160,40);
        opt.setFont(new Font("MV BOLI",Font.PLAIN,18));

        np.setFont(new Font("MV BOLI",Font.PLAIN,22));
        np.setForeground(Color.pink);
        np.setBounds(110,210,170,50);

        npt.setBounds(290,215,160,40);
        npt.setFont(new Font("MV BOLI",Font.PLAIN,18));

        confirm.setBounds(230,300,140,45);
        confirm.setFocusable(false);
        confirm.setFont(new Font("MV BOLI",Font.PLAIN,22));
        confirm.addActionListener(e -> {
            if (opt.getText().equals(pass)) {
                if(opt.getText().equals(Main.adminpass))
                    Main.adminpass= npt.getText().trim();
                if(opt.getText().equals(Main.userpass))
                    Main.userpass=npt.getText().trim();
                ArrayList<String> lines = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\anves\\IdeaProjects\\foodys\\src\\name"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains(opt.getText())) {
                            line = line.replace(opt.getText(), npt.getText());
                        }
                        lines.add(line);
                    }
                } catch (IOException f) {
                    f.printStackTrace();
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\anves\\IdeaProjects\\foodys\\src\\name"))) {
                    for (String line : lines) {
                        writer.write(line);
                        writer.newLine();
                    }
                } catch (IOException g) {
                    g.printStackTrace();
                }
                JOptionPane.showMessageDialog(cp, "Password changed successfully");
                cp.dispose();
            } else {
                JLabel wrongpassword = new JLabel("Wrong password entered..!");
                wrongpassword.setBounds(200, 500, 200, 50);
                wrongpassword.setForeground(Color.WHITE);
                cp.add(wrongpassword);
                cp.revalidate();
                cp.repaint();
            }
        });

        cp.setContentPane(p);
        cp.setSize(600, 600);
        cp.add(confirm);
        cp.add(op);
        cp.add(opt);
        cp.add(np);
        cp.add(npt);
        cp.setTitle("Change password");
        cp.setLocationRelativeTo(null);
        cp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        cp.setLayout(null);
        cp.setModal(true);
        cp.setVisible(true);
    }
}


