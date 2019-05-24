import java.net.Socket;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import java.io.IOException;

public class Client {
    // server part
    private static final int SERVER_PORT = 8000;
    private static final String SERVER_IP = "172.16.97.13";
    private static final int BUFFER_SIZE = 200;


    private InetAddress address;
    private DatagramSocket socket;

    private static final String TEAMNAME = "Tchebychev";

    private String currentGame;

    private static Client instance = null;

    // port = 8000
    // ip = 172.16.97.13
    private Client() {
        this.currentGame = "";
        // try to establish connection
        try {
            this.connect();
        } catch(Exception exception) {
            System.err.println(exception.getMessage());
            System.exit(1);
        }

    }

    public static final Client instance() {
        return instance;
    }

    public static final void initialize() {
        instance = new Client();
    }

    private void connect() throws Exception {
        try {
            this.socket = new DatagramSocket();
            this.address = InetAddress.getByName(SERVER_IP);
        } catch(IOException exception) {
            throw new Exception("Get by name failed");
        }

        try {
            this.sendData(TEAMNAME);
            this.receiveData();
        } catch(Exception sendDataException) {
            throw sendDataException;
        }

        System.out.println(this.currentGame);
    }

    public void sendData(String data) throws Exception {
        byte[] buffer = data.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, this.address, SERVER_PORT);
        packet.setData(buffer);
        try {
            this.socket.send(packet);
        } catch(IOException sendException) {
            throw new Exception("Error when sending data");
        }
    }

    public void receiveData() throws Exception {
        byte[] buffer = new byte[BUFFER_SIZE];
        DatagramPacket packet = new DatagramPacket(buffer, BUFFER_SIZE, this.address, SERVER_PORT);
        try {
            this.socket.receive(packet);
        } catch(IOException receiveException) {
            throw new Exception("Error when receiving data");
        }

        this.currentGame = new String(packet.getData());
    }
}