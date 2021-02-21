package Proiect1.Server;

import java.io.*;
import java.util.List;

public class ListenClient implements Runnable {

    private Client client;
    private Thread thread;
    private List<Client> clientList;
    private DataInputStream dataInputStream;
    private Server server;

    ListenClient(Client client, List<Client> clientList, Server server) {
        this.server = server;
        try {
            dataInputStream = new DataInputStream(client.getSocket().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.client = client;
        this.clientList = clientList;
    }

    public void start() {
        if (thread == null) {
            this.thread = new Thread(this);
            thread.start();
        }
    }


    private String receiveMessage() {
        String message = null;
        try {
            message = String.valueOf(dataInputStream.readUTF());
            //   System.out.println(message);
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }


        return message;
    }

    @Override
    public void run() {
        String message;
        do {
            message = receiveMessage();
            if (message != null) {
                String[] messageSplit = message.split("@", 2);
                switch (messageSplit[0]) {
                    case "Name": {
                        System.out.println("Client " + messageSplit[1] + " is connected!!");
                        client.setName(messageSplit[1]);
                        break;
                    }
                    case "Ege": {
                        client.setAge(messageSplit[1]);
                        break;
                    }
                    case "Message": {
                        System.out.println();
                        server.notifyObserver(messageSplit[1]);
                        System.out.println(messageSplit[1]);
                        break;
                    }
                    default:
                        message = null;
                        break;
                }

            }

        } while (message != null);
        System.out.println("Client " + client.getName() + " is disconnected!!");
        server.unregister(client);
        clientList.remove(client);
        System.out.println(clientList.size());
    }
}
