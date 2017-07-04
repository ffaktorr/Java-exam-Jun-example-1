package gui;

import event.animateEvent;
import event.fiborEvent;
import threads.animateThread;
import event.clientEvent;

import javax.swing.*;

public class mainWindow extends JFrame {
    private JLabel lblAnim,lblServerReq,lblFibor;
    private JTextField txtAnim,txtServerReq,txtFibor;
    private JButton btnAnim,btnServerReq,btnFibor;
    private JTextArea txaServerReq;

    public mainWindow(){
        this.setTitle("Ispit Jun 2 primer");
        this.setBounds(0,0,400,600);
        this.setLayout(null);

        initAnimation();
        initServerReq();
        initFibor();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initAnimation(){

        lblAnim = new JLabel("Input some text...");
        lblAnim.setBounds(10,5,390,30);
        this.add(lblAnim);

        txtAnim = new JTextField();
        txtAnim.setBounds(10,30,360,30);
        this.add(txtAnim);

        btnAnim = new JButton("Animate");
        btnAnim.setBounds(10,70,360,30);
        this.add(btnAnim);

        animateThread t1= new animateThread(lblAnim);
        t1.start();

        btnAnim.addActionListener(new animateEvent(t1,txtAnim));


    }

    public void initServerReq(){
        lblServerReq = new JLabel("Input message u want to send:");
        lblServerReq.setBounds(10,100,350,30);
        this.add(lblServerReq);

        txtServerReq = new JTextField();
        txtServerReq.setBounds(10,130,150,30);
        this.add(txtServerReq);

        btnServerReq = new JButton("Send");
        btnServerReq.setBounds(200,130,100,30);
        this.add(btnServerReq);

        txaServerReq = new JTextArea();
        txaServerReq.setBounds(10,170,360,150);
        this.add(txaServerReq);

        btnServerReq.addActionListener(new clientEvent(txtServerReq,txaServerReq));

    }

    public void initFibor(){

        lblFibor = new JLabel("Unesite broj elemenata Fibornacijevog niza");
        lblFibor.setBounds(10,320,400,30);
        this.add(lblFibor);

        txtFibor = new JTextField();
        txtFibor.setBounds(10,360,150,30);
        this.add(txtFibor);

        btnFibor = new JButton("sum of elements");
        btnFibor.setBounds(170,360,150,30);
        this.add(btnFibor);

        btnFibor.addActionListener(new fiborEvent(txtFibor));

    }

    public static void main(String[] args) {
        mainWindow window = new mainWindow();

    }
}

