
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame{
//    private JButton btnExit=new JButton("Exit");
    private JButton btnAuto=new JButton("Auto");
//    private JButton btnStop=new JButton("Stop");
    private JButton btnRight=new JButton(new ImageIcon("src/Right.gif"));
    private JButton btnAtk=new JButton(new ImageIcon("src/Attack.gif"));
    private JButton btnLeft=new JButton(new ImageIcon("src/Left.gif"));
    private JPanel south=new JPanel(new GridLayout(1,5));
    private JPanel center=new JPanel(null);
    private Label lab=new Label("(@w@)");
    private JLabel sun=new JLabel(new ImageIcon("src/Sun.gif"));
    private JLabel ball=new JLabel(new ImageIcon("src/Ball.gif"));
    private int score=0;
    private JLabel labHit=new JLabel("Hit:"+Integer.toString(score));
    private Timer t1;
    private Timer t2;
    private boolean flag=true;
    public MainFrame(){
        init();
    }
    private void init(){
        center.setBackground(Color.black);
        this.setTitle("只有一人的射擊遊戲");
        this.setResizable(false);
        this.setBounds(100,100,1000,650);
        lab.setBounds(MainFrame.this.getWidth()/2,MainFrame.this.getHeight()-145,47,50);
        lab.setBackground(new Color(255, 174, 191));
        sun.setBounds(100,100,100,100);
        btnAuto.setBounds(100,250,100,30);
//        btnExit.setBounds(200,250,100,30);
        btnAtk.setBounds(200,250,100,30);
//        btnStop.setBounds(300,250,100,30);
        btnRight.setBounds(300,250,100,30);

        ball.setBounds(lab.getX()+20,lab.getY()-60,30,30);
        ball.setBackground(Color.white);
        ball.setVisible(false);
        ball.setName("false");

//        this.setLayout(BorderLayout());
//        ball.setBackground(Color.white);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        this.getContentPane().add(BorderLayout.SOUTH,south);
        this.getContentPane().add(BorderLayout.CENTER,center);
//        south.add(BorderLayout.SOUTH,btnStart);
        south.add(BorderLayout.SOUTH,labHit);
        south.add(BorderLayout.SOUTH,btnLeft);
        south.add(BorderLayout.SOUTH,btnAtk);
        south.add(BorderLayout.SOUTH,btnRight);
        south.add(BorderLayout.SOUTH,btnAuto);
        center.add(BorderLayout.SOUTH,sun);
        center.add(BorderLayout.CENTER,lab);


        center.add(BorderLayout.CENTER,ball);


//        this.getContentPane().add(BorderLayout.SOUTH,btnRight);

//        btnExit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                System.exit(0);
//            }
//        });
        btnAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                lab.setText(Integer.toString(++count));
//                MainFrame.this.setTitle(Integer.toString(count));
                t1.start();
            }
        });
//        btnStop.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
////                lab.setText(Integer.toString(--count));
////                MainFrame.this.setTitle(Integer.toString(count));
//                t1.stop();
//            }
//        });
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(lab.getX()<MainFrame.this.getWidth()-55){
                    lab.setLocation(lab.getX()+25,lab.getY());
                }
                t1.stop();
            }
        });
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(lab.getX()>0){
                    lab.setLocation(lab.getX()-25,lab.getY());
                }
                t1.stop();
            }
        });
        btnAtk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                t2.start();

            }
        });
        t1 =new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(lab.getX()>MainFrame.this.getWidth()-75){
                    flag=false;
                }else if(lab.getX()<=0)  {
                    flag=true;
                }
                if(flag==true){
                    lab.setLocation(lab.getX() + 25, lab.getY());

                }else{
                    lab.setLocation(lab.getX() - 25, lab.getY());

                }

            }
        });
        t2 =new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if ( ball.getName().equals("false")){
                    ball.setLocation(lab.getX()+20,lab.getY()-60);
                    ball.setVisible(true);
                    ball.setName("true");
                }else{
                    if(ball.getY()<=sun.getY()+100&&ball.getX()>=sun.getX()&&ball.getX()<sun.getX()+100) {
                        ball.setVisible(false);
                        ball.setLocation(lab.getX()+20,lab.getY()-60);
                        ball.setName("false");
                        t2.stop();
                        score=score+1;
                        labHit.setText("Hit:"+Integer.toString(score));
                    }else if(ball.getY()<0){
                        ball.setVisible(false);
                        ball.setLocation(lab.getX()+20,lab.getY()-60);
                        ball.setName("false");
                        t2.stop();
                    }else{
                        ball.setLocation(ball.getX(),ball.getY()-10);
                    }
                }

            }
        });
    }
}
