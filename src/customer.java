import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.*;
import java.util.Objects;

public class customer {
    public customer(){
        JDialog upage=new JDialog();
        JButton cart=new JButton("Cart");
        JButton f=new JButton("FOOD");
        JButton d=new JButton("DRINKS");
        JLabel hi=new JLabel();
        JButton logoutb=new JButton("Logout");
        JButton myorders=new JButton("My Orders");
        ImageIcon lbi=new ImageIcon(Objects.requireNonNull(getClass().getResource("logout.png")));
        ImageIcon fi=new ImageIcon(Objects.requireNonNull(getClass().getResource("biryani.png")));
        ImageIcon di=new ImageIcon(Objects.requireNonNull(getClass().getResource("sprite.png")));
        ImageIcon cbi=new ImageIcon(Objects.requireNonNull(getClass().getResource("cart.png")));
        JPanel p=new JPanel(){
            private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("background.png"))).getImage();
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
            }
        };

        hi.setText("Hi! "+Main.username+" , Select items to your cart..");
        hi.setForeground(Color.pink);
        hi.setBounds(0,0,500,50);
        hi.setFont(new Font("MV BOLI",Font.ITALIC,20));

        Image lbni= lbi.getImage().getScaledInstance(35,30,Image.SCALE_SMOOTH);
        logoutb.setIcon(new ImageIcon(lbni));
        logoutb.setBounds(0,630,110,30);
        logoutb.setOpaque(false);
        logoutb.setFocusPainted(false);
        logoutb.setFont(new Font("MV BOLI",Font.BOLD,16));
        logoutb.setForeground(Color.pink);
        logoutb.setBackground(Color.BLACK);
        logoutb.setBorder(new LineBorder(Color.black, 0));
        logoutb.addActionListener(e ->upage.dispose());

        Image fni= fi.getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
        f.setIcon(new ImageIcon(fni));
        f.setBounds(125,60,180,90);
        f.setFont(new Font("TT ESPINA",Font.BOLD,22));
        f.setForeground(Color.PINK);
        f.setBackground(Color.BLACK);
        f.setFocusable(false);
        f.setBorder(new LineBorder(Color.BLACK,0));
        f.setOpaque(false);
        f.addActionListener(e1 -> {
            scrollpane sp=new scrollpane();
            JPanel q=sp.panel(Main.food);
            JScrollPane spfood = new JScrollPane(q);
            spfood.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            spfood.setBounds(15,155,400,400);
            upage.add(spfood);
            upage.revalidate();
            upage.repaint();
        });

        Image dni= di.getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
        d.setIcon(new ImageIcon(dni));
        d.setBounds(555,60,180,90);
        d.setFont(new Font("TT ESPINA",Font.BOLD,22));
        d.setForeground(Color.PINK);
        d.setBackground(Color.BLACK);
        d.setFocusable(false);
        d.setBorder(new LineBorder(Color.BLACK,0));
        d.setOpaque(false);
        d.addActionListener(e2 -> {
            scrollpane sp=new scrollpane();
            JPanel q=sp.panel(Main.drink);
            JScrollPane spdrink = new JScrollPane(q);
            spdrink.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            spdrink.setBounds(445,155,400,400);
            upage.add(spdrink);
            upage.revalidate();
            upage.repaint();
        });

        Image cni= cbi.getImage().getScaledInstance(50,60,Image.SCALE_SMOOTH);
        cart.setIcon(new ImageIcon(cni));
        cart.setBounds(340,600,180,50);
        cart.setFocusable(false);
        cart.setBorder(new LineBorder(Color.BLACK,0));
        cart.setOpaque(false);
        cart.setForeground(Color.pink);
        cart.setBackground(Color.BLACK);
        cart.setFocusPainted(false);
        cart.setFont(new Font("MV BOLI",Font.BOLD,20));
        cart.addActionListener(e ->{
            if(!Main.cartitems.isEmpty())
                new Cart();
            else
                JOptionPane.showMessageDialog(upage,"Cart is Empty..!","Empty",JOptionPane.WARNING_MESSAGE);
        });

        myorders.setBounds(740,630,110,30);
        myorders.setOpaque(false);
        myorders.setFocusPainted(false);
        myorders.setFont(new Font("MV BOLI",Font.BOLD,16));
        myorders.setForeground(Color.pink);
        myorders.setBackground(Color.BLACK);
        myorders.setBorder(new LineBorder(Color.black, 0));
        myorders.addActionListener(e ->{
                JDialog orders = new JDialog();
                JLabel l=new JLabel();
                JTextArea ta = new JTextArea();
                JPanel q=new JPanel(){
                    private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("background.png"))).getImage();
                    @Override
                    public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
                    }
                };

                l.setText("Order History");
                l.setFont(new Font("MV BOLI",Font.BOLD,22));
                l.setBounds(250,40,200,60);
                l.setForeground(Color.pink);

                ta.setEditable(false);
                ta.setFont(new Font("null", Font.PLAIN, 18));
                ta.setOpaque(false);
                ta.setForeground(Color.WHITE);
                ta.setLineWrap(true);
                ta.setWrapStyleWord(true);
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\anves\\IdeaProjects\\foodys\\src\\myorders"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        ta.append(line + "\n");
                    }
                    reader.close();
                } catch (IOException g) {
                    ta.setText("No orders found!");
                }

                JScrollPane tasp = new JScrollPane(ta);
                tasp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                tasp.setBounds(75,120,550,500);
                tasp.setOpaque(false);
                tasp.getViewport().setOpaque(false);

                orders.setContentPane(q);
                orders.setTitle("Previous Orders");
                orders.setSize(700, 700);
                orders.setLayout(null);
                orders.add(tasp);
                orders.add(l);
                orders.setModal(true);
                orders.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                orders.setLocationRelativeTo(null);
                orders.setVisible(true);
        });

        upage.setContentPane(p);
        upage.setTitle("USER PAGE");
        upage.setSize(860,700);
        upage.setLayout(null);
        upage.add(logoutb);
        upage.add(hi);
        upage.add(f);
        upage.add(myorders);
        upage.add(d);
        upage.add(cart);
        upage.setModal(true);
        upage.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        upage.setLocationRelativeTo(null);
        upage.setVisible(true);
    }
}
