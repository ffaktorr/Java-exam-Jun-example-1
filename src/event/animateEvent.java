package event;

import threads.animateThread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class animateEvent implements ActionListener{

    private animateThread animateThread;
    private JTextField txtAnim;

    public animateEvent(animateThread animateThread, JTextField txtAnim){
        this.animateThread= animateThread;
        this.txtAnim=txtAnim;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        animateThread.changeMessage(txtAnim.getText());
    }
}
