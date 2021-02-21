package Proiect1.Server;

import java.util.ArrayList;
import java.util.List;

public class Server  implements Observed{
    private List<Client> listClients;


    public Server() {
        if (listClients == null) {
            listClients = new ArrayList<>();
        }
    }

    public void teach(String message) {
        notifyObserver(message);
    }

    @Override
    public void register(Observer obj) {
        listClients.add((Client) obj);
    }

    @Override
    public void unregister(Observer obj) {
        listClients.remove(obj);
    }

    @Override
    public void notifyObserver(String message) {
        for (Client client : listClients) {
            client.update(message);
        }
    }
}
