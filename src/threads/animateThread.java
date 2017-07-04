package threads;


import javax.swing.*;

public class animateThread extends Thread {

    private volatile String messageForAnimation;
    private JLabel lblAnim;
    private int iterator=0;

    public animateThread(JLabel lblAnim){
        this.lblAnim=lblAnim;
        messageForAnimation ="Input some txt...";
    }

    @Override
    public void run() {
        char[] split = new char[0];
        String txtShow = "";
        while (true){

            if(iterator==0){
                txtShow = "";
                split = messageForAnimation.toCharArray();

            }
            if(iterator==split.length){
                txtShow ="";
                iterator=0;

            }
            txtShow+=split[iterator++];
            lblAnim.setText(txtShow);
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }





        }
    }
    public void changeMessage(String txt){this.messageForAnimation = txt;iterator=0; }
}
