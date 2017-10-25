import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    private Random rnd=new Random(System.currentTimeMillis());
    private LoginFrame loginframe;
    private Container cp;
    private int Screenw=Toolkit.getDefaultToolkit().getScreenSize().width;
    private int Screenh=Toolkit.getDefaultToolkit().getScreenSize().height;
    private int width=500,height=500;
    private JMenuBar jmb=new JMenuBar();
    private JMenu jmF=new JMenu("File");
    private JMenu jmS=new JMenu("Set");
    private JMenu jmG=new JMenu("Game");
    private JMenu jmA=new JMenu("About");
    private JMenuItem jmiexit=new JMenuItem("Exit");
    private JMenuItem jmiloto=new JMenuItem("樂透開獎");
    private JPanel jplloto=new JPanel(new GridLayout(1,6,3,3));
    private JPanel jplloto2=new JPanel(new GridLayout(1,2,3,3));
    private JInternalFrame jifloto=new JInternalFrame();
    private JDesktopPane jdp=new JDesktopPane();
    private JLabel jlb[]=new JLabel[6];
    private JButton jbtnclose=new JButton("Close");
    private JButton jbtnregen=new JButton("Regen");
    public MainFrame(LoginFrame log){
        loginframe=log;
        init();
    }
    private void init(){
        this.setBounds(Screenw/2-width/2,Screenh/2-height/2,width,height);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginframe.setVisible(true);
            }
        });
        this.setJMenuBar(jmb);
        jmb.add(jmF);
        jmb.add(jmS);
        jmb.add(jmG);
        jmb.add(jmA);
        jmF.add(jmiexit);
        jmG.add(jmiloto);
        this.setContentPane(jdp);
        cp=jifloto.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(jplloto,BorderLayout.CENTER);
        cp.add(jplloto2,BorderLayout.SOUTH);
        for(int i=0;i<6;i++){
            jlb[i]=new JLabel();
            jplloto.add(jlb[i]);
        }
        loto();
        jplloto2.add(jbtnclose);
        jplloto2.add(jbtnregen);
        jmiexit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmiloto.setAccelerator(KeyStroke.getKeyStroke('L',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmiexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginframe.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });

        jmiloto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.add(jifloto);
                jifloto.setBounds(10,10,300,300);
                jifloto.setVisible(true);
                loto();

            }
        });
        jbtnclose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jifloto.dispose();
            }
        });
        jbtnregen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loto();
            }
        });

    }
    private void loto(){

        int data[]=new int[6];
        Boolean flag=true;
        int i=0;
        while(i<6){
            data[i]=rnd.nextInt(42)+1;
            flag=true;
            int j=0;
            while(j<i&&flag){
                if(data[i]==data[j]){
                    flag=false;
                }
                j++;
            }
            if(flag){
                jlb[i].setText(Integer.toString(data[i]));
                i++;
            }
        }

    }
}
