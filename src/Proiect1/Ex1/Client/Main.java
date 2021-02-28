package Proiect1.Ex1.Client;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Main {

    public static void main(String[] args) {

        SocketAddress address = new InetSocketAddress("localhost", 11111);

        Socket socket = new Socket();
        try {

            socket.connect(address);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Name@Ana");
            dataOutputStream.flush();


            dataOutputStream.writeUTF("Ege@23");
            dataOutputStream.flush();

            dataOutputStream.writeUTF("Message@Cf");
            dataOutputStream.flush();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String message = null;
            try {
                message = String.valueOf(dataInputStream.readUTF());
                System.out.println(message);
            } catch (EOFException e) {

            } catch (IOException e) {
                e.printStackTrace();
            }


            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

