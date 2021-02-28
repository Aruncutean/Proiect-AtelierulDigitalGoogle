package Proiect1.Ex1.Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;

public class Client implements Observer {

    private Socket socket;
    private String id;
    private String name;
    private String age;
    private LocalDateTime loginTime;

    private Client(Builder builder) {
        this.socket = builder.socket;
        this.age = builder.age;
        this.id = builder.id;
        this.loginTime = builder.loginTime;
        this.name = builder.name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Socket getSocket() {
        return socket;
    }

    public void listenTo(Server server) {
        server.register(this);

    }

    @Override
    public void update(String message) {
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static class Builder {
        private Socket socket;
        private String id;
        private String name;
        private String age;
        private LocalDateTime loginTime;

        public Builder(Socket socket) {
            this.socket = socket;
        }


        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(String age) {
            this.age = age;
            return this;
        }

        public Builder setLoginTime(LocalDateTime loginTime) {
            this.loginTime = loginTime;
            return this;
        }


        public Client build() {
            return new Client(this);
        }

    }


}
