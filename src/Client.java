import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;

import java.net.ServerSocket;
import java.net.Socket;

public class Client {

    private int port;
    private String ip;

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    private String currentGame;

    public Client(int port, String ip) {
        this.ip = ip;
        this.port = port;
    }

    private void connect() {
        try {
            this.socket = new Socket(this.ip, this.port);
            this.reader = new BufferedReader(
                new InputStreamReader(
                    this.socket.getInputStream()
                )
            );
            
            this.writer = new PrintWriter(this.socket.getOutputStream());

        } catch(IOException connectionException) {
            System.err.println("Error");
        }
    }

    public void sendData(String data) {
        this.writer.println(data);
        this.writer.flush();
    }

    public void receiveData() {
        try {
            this.currentGame = this.reader.readLine();
        } catch(IOException readException) {
            System.err.println("Error when reading");
        }
    }
}