import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class server {

    public static void main(String[] args){
        ArrayList<String> messages = new ArrayList<String>();
        try {
            ServerSocket ss = new ServerSocket(6005);
            while (true){
                Socket s = ss.accept();
                ObjectInputStream ois =new ObjectInputStream(s.getInputStream());
                String message = (String) ois.readObject();
                System.out.println("Message recived: "+message);
                messages.add(new StringBuilder(message).reverse().toString());
                System.out.println("Message reversed.Sending all messages to the client");
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(messages);

                ois.close();
                oos.close();
                s.close();
            }

        }catch (IOException  | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
