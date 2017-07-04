package event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fiborEvent implements ActionListener {

    public JTextField broj;

    public fiborEvent(JTextField broj){
        this.broj=broj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int n = Integer.parseInt(this.broj.getText());
        int suma = fb(n);

        JOptionPane.showMessageDialog(null,"Suma: "+ suma);



    }
    public int fb(int n){
        int suma=2;
        int[] niz = new int[n];
        if(n<=0){return 0;}
        if(n==1){return 1;}
        if(n>1){
            niz[0]=1;
            niz[1]=1;
            suma=2;
            for (int i = 2; i < n; i++) {
                niz[i]=niz[i-2]+niz[i-1];
                suma+=niz[i];
            }
        }
        return suma;
    }
}
