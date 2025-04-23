import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Cart {
    public Cart(){
        JDialog citems= new JDialog();
        JPanel p = new JPanel(){
            private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("background.png"))).getImage();
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
            }
        };
        JLabel ci=new JLabel();
        JButton b = new JButton("Order Info");
        ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
        JPanel q=new JPanel(){
            private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("adminbg.png"))).getImage();
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
            }
        };
        citems.setContentPane(q);

        ci.setText("Cart Items");
        ci.setBounds(150,50,130,60);
        ci.setFont(new Font("MV BOLI",Font.BOLD,23));
        ci.setForeground(Color.pink);

        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        for (int i = 0; i < Main.cartitems.size(); i++) {
            JCheckBox box = new JCheckBox();
            box.setText(Main.cartitems.get(i).getItem() + "   ₹" + Main.cartitems.get(i).getPrice());
            box.setFont(new Font(null, Font.PLAIN, 18));
            box.setForeground(Color.WHITE);
            box.setOpaque(false);
            checkBoxes.add(box);
            box.setSelected(true);
            box.setFocusable(false);
            p.add(Box.createVerticalStrut(7));
            p.add(box);
        }
        JScrollPane sp = new JScrollPane(p);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setBounds(40, 120, 370, 400);

        b.setFocusable(false);
        b.setBounds(150,550,130,40);
        b.setFont(new Font("MV BOLI",Font.PLAIN,18));
        b.addActionListener(e -> {
            JDialog d = new JDialog();
            JPanel op = new JPanel(){
                private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("background.png"))).getImage();
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
                }
            };
            JButton po = new JButton("Place Order");
            JLabel t=new JLabel();
            JPanel o=new JPanel(){
                private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("adminbg.png"))).getImage();
                @Override
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
                }
            };

            final int[] total={0};
            op.setLayout(new GridBagLayout());
            GridBagConstraints gbc=new GridBagConstraints();
            gbc.gridx=0;
            gbc.gridy=0;
            gbc.insets=new Insets(5,10,5,10);
            gbc.anchor=GridBagConstraints.WEST;
            for(int i = 0; i<checkBoxes.size(); i++){
                if(checkBoxes.get(i).isSelected()){
                    total[0] = total[0] + Integer.parseInt(Main.cartitems.get(i).getPrice());
                    JLabel name = new JLabel(Main.cartitems.get(i).getItem());
                    name.setFont(new Font("MV BOLI", Font.PLAIN, 19));
                    name.setForeground(Color.WHITE);
                    JLabel price = new JLabel("₹" + Main.cartitems.get(i).getPrice());
                    price.setFont(new Font(null, Font.PLAIN, 19));
                    price.setForeground(Color.WHITE);

                    gbc.gridx = 0;
                    gbc.gridwidth = 2;
                    op.add(name, gbc);
                    gbc.gridx = 2;
                    gbc.gridwidth = 1;
                    op.add(price, gbc);

                    gbc.gridy++;
                }
            }
            JScrollPane osp = new JScrollPane(op);
            osp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            osp.setBounds(40,100,370,380);

            t.setText("Total Price : ₹"+total[0]);
            t.setFont(new Font(null,Font.ITALIC,22));
            t.setBounds(140,520,200,50);
            t.setForeground(Color.ORANGE);

            po.setFont(new Font("MV BOLI",Font.PLAIN,18));
            po.setFocusable(false);
            po.setBounds(150,600,150,40);
            po.addActionListener(e1 -> {
                if(total[0]==0){
                    JOptionPane.showMessageDialog(d,"Nothing to order !","Fail",JOptionPane.WARNING_MESSAGE);
                    d.dispose();
                }
                else {
                    try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\anves\\IdeaProjects\\foodys\\src\\myorders",true))) {
                        for(int i = 0; i<checkBoxes.size(); i++) {
                            if (checkBoxes.get(i).isSelected())
                                writer.write(Main.cartitems.get(i).getItem() + " - ₹" + Main.cartitems.get(i).getPrice() + "\n");
                        }
                        writer.write("\nTotal Price: ₹" + total[0] + "\n");
                        writer.write("------------------------------------\n\n");
                    }catch (IOException g) {
                        g.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(d,
                            "THANK YOU !\nORDER PLACED SUCCESSFULLY !",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE,
                            new ImageIcon(Objects.requireNonNull(getClass().getResource("smile.gif"))));
                    d.dispose();
                    citems.dispose();
                    Main.cartitems.clear();
                }
                });

            d.setContentPane(o);
            d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            d.setLayout(null);
            d.setTitle("Order");
            d.setSize(850,700);
            d.add(po);
            d.add(osp);
            d.add(t);
            d.setModal(true);
            d.setLocationRelativeTo(null);
            d.setVisible(true);
        });

        citems.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        citems.setLayout(null);
        citems.setTitle("CART");
        citems.setSize(850,700);
        citems.add(b);
        citems.add(sp);
        citems.add(ci);
        citems.setModal(true);
        citems.setLocationRelativeTo(null);
        citems.setVisible(true);
    }
}
