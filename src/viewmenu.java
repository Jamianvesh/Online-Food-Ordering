import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

public class viewmenu {
    public viewmenu(){
        JDialog vmenu=new JDialog();
        JButton f=new JButton("FOOD");
        JButton d=new JButton("DRINKS");
        ImageIcon fi=new ImageIcon(Objects.requireNonNull(getClass().getResource("biryani.png")));
        ImageIcon di=new ImageIcon(Objects.requireNonNull(getClass().getResource("sprite.png")));

        JPanel q=new JPanel(){
            private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("background.png"))).getImage();
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
            }
        };

        Image fni= fi.getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
        f.setIcon(new ImageIcon(fni));
        f.setBounds(125,60,180,80);
        f.setFont(new Font("TT ESPINA",Font.BOLD,22));
        f.setForeground(Color.PINK);
        f.setBackground(Color.BLACK);
        f.setFocusable(false);
        f.setBorder(new LineBorder(Color.BLACK,0));
        f.setOpaque(false);
        f.addActionListener(e1 -> {
            JPanel p=new JPanel(){
                private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("background.png"))).getImage();
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
                }
            };
            p.setLayout(new GridBagLayout());
            GridBagConstraints gbc=new GridBagConstraints();
            gbc.gridx=0;
            gbc.gridy=0;
            gbc.insets=new Insets(5,5,5,5);
            gbc.anchor=GridBagConstraints.WEST;
            if(Main.food !=null) {
                for (int i = 0; i < Main.food.size(); i++) {
                    JLabel foodname = new JLabel(Main.food.get(i).getItem());
                    foodname.setFont(new Font("MV BOLI", Font.PLAIN, 18));
                    foodname.setForeground(Color.WHITE);
                    JLabel foodprice = new JLabel("₹" + Main.food.get(i).getPrice());
                    foodprice.setFont(new Font(null, Font.PLAIN, 18));
                    foodprice.setForeground(Color.WHITE);

                    gbc.gridx = 0;
                    gbc.gridwidth = 2;
                    p.add(foodname, gbc);
                    gbc.gridx = 2;
                    p.add(foodprice, gbc);

                    gbc.gridy++;
                }
            }
            JScrollPane spfood = new JScrollPane(p);
            spfood.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            spfood.setBounds(15,180,400,400);
            vmenu.add(spfood);
            vmenu.revalidate();
            vmenu.repaint();
        });

        Image dni= di.getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
        d.setIcon(new ImageIcon(dni));
        d.setBounds(555,60,180,80);
        d.setFont(new Font("TT ESPINA",Font.BOLD,22));
        d.setForeground(Color.PINK);
        d.setBackground(Color.BLACK);
        d.setFocusable(false);
        d.setBorder(new LineBorder(Color.BLACK,0));
        d.setOpaque(false);
        d.addActionListener(e2 -> {
            JPanel p=new JPanel(){
                private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("background.png"))).getImage();
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
                }
            };
            p.setLayout(new GridBagLayout());
            GridBagConstraints gbc=new GridBagConstraints();
            gbc.gridx=0;
            gbc.gridy=0;
            gbc.insets=new Insets(5,5,5,5);
            gbc.anchor=GridBagConstraints.WEST;
            if(Main.drink !=null) {
                for (int i = 0; i < Main.drink.size(); i++) {
                    JLabel drinkname = new JLabel(Main.drink.get(i).getItem());
                    drinkname.setFont(new Font("MV BOLI", Font.PLAIN, 18));
                    drinkname.setForeground(Color.WHITE);
                    JLabel drinkprice = new JLabel("₹" + Main.drink.get(i).getPrice());
                    drinkprice.setFont(new Font(null, Font.PLAIN, 18));
                    drinkprice.setForeground(Color.WHITE);

                    gbc.gridx = 0;
                    gbc.gridwidth = 2;
                    p.add(drinkname, gbc);
                    gbc.gridx = 2;
                    p.add(drinkprice, gbc);

                    gbc.gridy++;
                }
            }
            JScrollPane spdrink = new JScrollPane(p);
            spdrink.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            spdrink.setBounds(445,180,400,400);
            vmenu.add(spdrink);
            vmenu.revalidate();
            vmenu.repaint();
        });

        vmenu.setContentPane(q);
        vmenu.setTitle("MENU");
        vmenu.setSize(860,650);
        vmenu.setLayout(null);
        vmenu.add(f);
        vmenu.add(d);
        vmenu.setModal(true);
        vmenu.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        vmenu.setLocationRelativeTo(null);
        vmenu.setVisible(true);
    }
}
