
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame{
    private Button btnExit=new Button("Exit");
    private Button btnStart=new Button("Start");
    private Button btnStop=new Button("Stop");
    private Label lab=new Label("(@w@)");
    private int count =0;
    private Timer t1;
    private boolean flag=true;
    public MainFrame(){
        init();
    }
    private void init(){
        this.setBackground(Color.black);
        this.setResizable(false);
        this.setLayout(null);
        this.setBounds(100,100,500,300);
        lab.setBounds(225,100,47,50);
        lab.setBackground(new Color(255, 174, 191));
        btnStart.setBounds(100,250,100,30);
        btnExit.setBounds(200,250,100,30);
        btnStop.setBounds(300,250,100,30);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        this.add(btnExit);
        this.add(btnStart);
        this.add(btnStop);
        this.add(lab);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                lab.setText(Integer.toString(++count));
//                MainFrame.this.setTitle(Integer.toString(count));
                t1.start();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                lab.setText(Integer.toString(--count));
//                MainFrame.this.setTitle(Integer.toString(count));
                t1.stop();
            }
        });
        t1 =new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lab.setText(Integer.toString(lab.getX())+","+Integer.toString(lab.getY()));
                if(lab.getX()>MainFrame.this.getWidth()-75){
                    flag=false;
                }else if(lab.getX()<=0)  {
                    flag=true;
                }
                if(flag==true){
                    lab.setLocation(lab.getX() + 25, lab.getY());
                    lab.setBackground(new Color(255, 174+lab.getX()/7, 191+lab.getX()/7));
                }else{
                    lab.setLocation(lab.getX() - 25, lab.getY());
                    lab.setBackground(new Color(255, 174+lab.getX()/7, 191+lab.getX()/7));
                }

            }
        });
    }
}
