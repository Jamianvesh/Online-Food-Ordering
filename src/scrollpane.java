import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class scrollpane {
    public JPanel panel(ArrayList<menu> item){
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
        if(item !=null) {
            for (int i = 0; i < item.size(); i++) {
                int index=i;
                JLabel itemname = new JLabel(item.get(i).getItem());
                itemname.setFont(new Font("MV BOLI", Font.PLAIN, 18));
                itemname.setForeground(Color.WHITE);
                JLabel itemprice = new JLabel("₹" + item.get(i).getPrice());
                itemprice.setFont(new Font(null, Font.PLAIN, 18));
                itemprice.setForeground(Color.WHITE);
                JButton addbutton = new JButton("ADD");
                addbutton.setFocusable(false);
                addbutton.addActionListener(e -> {
                    Main.cartitems.add(item.get(index));
                    JOptionPane.showMessageDialog(p,item.get(index).getItem() + " added to cart !");
                });

                gbc.gridx = 0;
                gbc.gridwidth = 2;
                p.add(itemname, gbc);
                gbc.gridx = 2;
                gbc.gridwidth = 1;
                p.add(itemprice, gbc);
                gbc.gridx = 3;
                p.add(addbutton, gbc);

                gbc.gridy++;
            }
        }
        return p;
    }
}
