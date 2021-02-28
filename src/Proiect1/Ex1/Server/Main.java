package Proiect1.Ex1.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Client> clients;
        Server server = new Server();

        SocketAddress address = new InetSocketAddress("localhost", 11111);
        Socket client;
        try {
            ServerSocket socket = new ServerSocket();
            socket.bind(address);
            clients = new ArrayList<>();
            Random random = new Random();
            while (socket != null) {
                client = socket.accept();
                Client client1 = new Client.Builder(client).setId(String.valueOf(random.nextInt())).build();
                client1.listenTo(server);
                clients.add(client1);
                ListenClient listenClient = new ListenClient(client1, clients, server);
                listenClient.start();
                System.out.println(clients.size());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
