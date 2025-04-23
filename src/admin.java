import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class admin {
    public admin(){
        JDialog apage=new JDialog();
        JButton vmenu=new JButton("View Menu");
        JButton aitems=new JButton("Add Items");
        JButton ritems=new JButton("Drop Items");
        JButton logoutb=new JButton("Logout");
        ImageIcon i=new ImageIcon(Objects.requireNonNull(getClass().getResource("logout.png")));
        JPanel p=new JPanel(){
            private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("adminbg.png"))).getImage();
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
            }
        };

        Image ni= i.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
        logoutb.setIcon(new ImageIcon(ni));
        logoutb.setBounds(0,600,180,40);
        logoutb.setOpaque(false);
        logoutb.setFocusPainted(false);
        logoutb.setFont(new Font("MV BOLI",Font.BOLD,18));
        logoutb.setForeground(Color.pink);
        logoutb.setBackground(Color.BLACK);
        logoutb.setBorder(new LineBorder(Color.black, 0));
        logoutb.addActionListener(e ->apage.dispose());

        vmenu.setBounds(100,200,150,50);
        vmenu.setForeground(Color.pink);
        vmenu.setFont(new Font("MV BOLI",Font.PLAIN,22));
        vmenu.setFocusable(false);
        vmenu.addActionListener(e -> new viewmenu());

        aitems.setBounds(100,300,150,50);
        aitems.setForeground(Color.pink);
        aitems.setFont(new Font("MV BOLI",Font.PLAIN,22));
        aitems.setFocusable(false);
        aitems.addActionListener(e -> {
            JDialog additem = new JDialog();
            JLabel inl = new JLabel("Item Name :");
            JLabel ipl = new JLabel("Item Price :");
            JTextField intf = new JTextField();
            JTextField iptf  = new JTextField();
            JLabel il = new JLabel("Item");
            JButton ADD = new JButton("ADD");
            String[] cat ={"Food","Drink"};
            JComboBox <String> catitems = new JComboBox<>(cat);
            JPanel q=new JPanel(){
                private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("background.png"))).getImage();
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
                }
            };

            il.setFont(new Font("MV BOLI",Font.PLAIN,22));
            il.setForeground(Color.pink);
            il.setBounds(120,150,160,50);

            catitems.setBounds(290,155,160,40);
            catitems.setFont(new Font("MV BOLI",Font.PLAIN,18));

            inl.setFont(new Font("MV BOLI",Font.PLAIN,22));
            inl.setForeground(Color.pink);
            inl.setBounds(120,210,160,50);

            intf.setBounds(290,215,160,40);
            intf.setFont(new Font("MV BOLI",Font.PLAIN,18));

            ipl.setFont(new Font("MV BOLI",Font.PLAIN,22));
            ipl.setForeground(Color.pink);
            ipl.setBounds(120,270,160,50);

            iptf.setBounds(290,275,160,40);
            iptf.setFont(new Font("MV BOLI",Font.PLAIN,18));

            ADD.setBounds(230,340,90,40);
            ADD.setFocusable(false);
            ADD.setFont(new Font("MV BOLI",Font.PLAIN,22));
            ADD.addActionListener(e1 -> {
                String s = (String) catitems.getSelectedItem();
                if (!((intf.getText().isEmpty()) && (iptf.getText().isEmpty()))) {
                    if (s.equals("Food")) {
                        menu x = new menu(intf.getText(), iptf.getText());
                        Main.food.add(x);
                        ArrayList<String> lines = new ArrayList<>();
                        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\anves\\IdeaProjects\\foodys\\src\\food"))) {
                            String line;
                            while ((line = reader.readLine()) != null)
                                lines.add(line);
                        } catch (IOException a) {
                            a.printStackTrace();
                        }
                        lines.add("Food :" + intf.getText() + " , Price : ₹" + iptf.getText());
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\anves\\IdeaProjects\\foodys\\src\\food"))) {
                            for (String line : lines) {
                                writer.write(line);
                                writer.newLine();
                            }
                        } catch (IOException g) {
                            g.printStackTrace();
                        }
                    }
                    if (s.equals("Drink")) {
                        menu x = new menu(intf.getText(), iptf.getText());
                        Main.drink.add(x);
                        ArrayList<String> lines = new ArrayList<>();
                        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\anves\\IdeaProjects\\foodys\\src\\food"))) {
                            String line;
                            while ((line = reader.readLine()) != null)
                                lines.add(line);
                        } catch (IOException a) {
                            a.printStackTrace();
                        }
                        lines.add("Drink :" + intf.getText() + " , Price : ₹" + iptf.getText());
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\anves\\IdeaProjects\\foodys\\src\\food"))) {
                            for (String line : lines) {
                                writer.write(line);
                                writer.newLine();
                            }
                        } catch (IOException g) {
                            g.printStackTrace();
                        }
                    }
                    JOptionPane.showMessageDialog(additem, intf.getText() + " added successfully ");
                }
                intf.setText("");
                iptf.setText("");
            });

            additem.setSize(600,600);
            additem.setTitle("Add Item");
            additem.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            additem.setContentPane(q);
            additem.setLayout(null);
            additem.add(il);
            additem.add(catitems);
            additem.add(inl);
            additem.add(ipl);
            additem.add(intf);
            additem.add(iptf);
            additem.add(ADD);
            additem.setModal(true);
            additem.setLocationRelativeTo(null);
            additem.setVisible(true);
        });

        ritems.setBounds(100,400,150,50);
        ritems.setForeground(Color.pink);
        ritems.setFont(new Font("MV BOLI",Font.PLAIN,22));
        ritems.setFocusable(false);
        ritems.addActionListener(e ->new dropitems());

        apage.setContentPane(p);
        apage.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        apage.setLayout(null);
        apage.setTitle("ADMIN PAGE");
        apage.setSize(700,700);
        apage.add(vmenu);
        apage.add(aitems);
        apage.add(ritems);
        apage.add(logoutb);
        apage.setModal(true);
        apage.setLocationRelativeTo(null);
        apage.setVisible(true);
    }
}
