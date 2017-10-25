import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private int Screenw= Toolkit.getDefaultToolkit().getScreenSize().width;
    private int Screenh= Toolkit.getDefaultToolkit().getScreenSize().height;
    private int width=300,height=200;
    private Container cp;
    private JPanel jpl=new JPanel(new GridLayout(3,2,3,3));
    private JButton jbtnexit=new JButton("Exit");
    private JButton jbtngo=new JButton("Go");
    private JLabel jlbid=new JLabel("ID:");
    private JLabel jlbpw=new JLabel("Password:");
    private JTextField jtf=new JTextField();
    private JPasswordField jpf=new JPasswordField();
    public LoginFrame(){
        init();
    }
    private void init(){
        this.setBounds(Screenw/2-width/2,Screenh/2-height/2,width,height);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(jpl,BorderLayout.CENTER);
        jpl.add(jlbid);
        jpl.add(jtf);
        jpl.add(jlbpw);
        jpl.add(jpf);
        jpl.add(jbtnexit);
        jpl.add(jbtngo);

        jbtnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jbtngo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String pw=new String(jpf.getPassword());
                if(jtf.getText().equals("h304")&&pw.equals("23323456")){
                    MainFrame mf=new MainFrame(LoginFrame.this);
                    mf.setVisible(true);
                    LoginFrame.this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(LoginFrame.this,"Error");
                }
            }
        });

    }

}
