package Proiect1.Ex1.Server;

public interface Observed {
    void register(Observer obj);

    void unregister(Observer obj);

    void notifyObserver(String message);

}
