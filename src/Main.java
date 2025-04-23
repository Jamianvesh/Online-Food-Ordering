import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.*;

public class Main{
    public static String adminname;
    public static String adminpass;
    public static String username;
    public static String userpass;
    public static ArrayList<menu> food=new ArrayList<>();
    public static ArrayList<menu> drink=new ArrayList<>();
    public static ArrayList<menu> cartitems=new ArrayList<>();

    public static void main(String[] args) {
        ImageIcon i=new ImageIcon(Objects.requireNonNull(Main.class.getResource("imageicon.jpg")));
        JButton b=new JButton("Click Me !");
        JFrame foodys=new JFrame("ONLINE FOOD ORDERING");
        JPanel p=new JPanel(){
            private final Image backgroundimage=new ImageIcon(Objects.requireNonNull(getClass().getResource("bg.png"))).getImage();
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(backgroundimage,0,0,getWidth(),getHeight(),this);
            }
        };

        b.setBounds(280,310,150,50);
        b.setFocusable(false);
        b.setForeground(Color.WHITE);
        b.setBackground(new Color(0X123456));
        b.setFont(new Font("MV BOLI",Font.BOLD,20));

        b.addActionListener(e -> new User());

        foodys.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        foodys.setExtendedState(JFrame.MAXIMIZED_BOTH);
        foodys.setIconImage(i.getImage());
        foodys.setContentPane(p);
        foodys.add(b);
        foodys.setLayout(null);
        foodys.setLocationRelativeTo(null);
        foodys.setVisible(true);

        try(BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\anves\\IdeaProjects\\foodys\\src\\name")))  {
            String line;
            Pattern apattern = Pattern.compile("Adminname:(.*?) , Password:(.*)");
            Pattern upattern = Pattern.compile("Username:(.*?) , Password:(.*)");
            while ((line = reader.readLine()) != null) {
                Matcher amatcher = apattern.matcher(line);
                Matcher umatcher = upattern.matcher(line);
                if (amatcher.find()) {
                    adminname = amatcher.group(1).trim();
                    adminpass = amatcher.group(2).trim();
                }
                if (umatcher.find()) {
                    username = umatcher.group(1).trim();
                    userpass = umatcher.group(2).trim();
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try(BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\anves\\IdeaProjects\\foodys\\src\\food")))  {
            String line;
            Pattern fpattern = Pattern.compile("Food :(.*?) , Price : ₹(.*)");
            Pattern dpattern = Pattern.compile("Drink :(.*?) , Price : ₹(.*)");
            while ((line = reader.readLine()) != null) {
                Matcher fmatcher = fpattern.matcher(line);
                Matcher dmatcher = dpattern.matcher(line);
                if (fmatcher.find()) {
                   menu x=new menu(fmatcher.group(1).trim(),fmatcher.group(2).trim());
                   food.add(x);
                }
                if (dmatcher.find()) {
                    menu x=new menu(dmatcher.group(1).trim(),dmatcher.group(2).trim());
                    drink.add(x);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}