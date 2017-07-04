package event;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class clientEvent implements ActionListener {

    private JTextArea txaServerReq;
    private JTextField txtServerReq;

    public clientEvent(JTextField txtServerReq,JTextArea txaServerReq){

        this.txaServerReq = txaServerReq;
        this.txtServerReq = txtServerReq;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Socket s = new Socket("192.168.1.3",6005);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

            String message = txtServerReq.getText();
            oos.reset();
            oos.writeObject(message);

            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            ArrayList<String> messages = (ArrayList<String>) ois.readObject();
            StringBuilder sb = new StringBuilder();
            for(String mes:messages){
                sb.append(mes);
                sb.append("\n");
            }

            txaServerReq.setText(sb.toString());
            ois.close();
            oos.close();
            s.close();

        }catch (IOException | ClassNotFoundException e1){
            e1.printStackTrace();
        }


    }
}
