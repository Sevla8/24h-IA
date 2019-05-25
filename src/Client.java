import java.net.Socket;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import java.io.IOException;

import java.awt.Point;

public class Client {

    public static enum State {
        IS_MINE_TURN, IS_OPPONENT_TURN, IS_ILLEGAL_OPPONENT_SHOT, IS_MINE_SHOT_ILLEGAL, IS_END_GAME
    }

    // server part
    private static final int SERVER_PORT = 8025;
    private static final String SERVER_IP = "172.16.97.194";
    private static final int BUFFER_SIZE = 300;

    private boolean isEndGame;

    private InetAddress address;
    private DatagramSocket socket;

    private static final String TEAMNAME = "Tchebychev";

    private String receivedData;

    private int position;

    private boolean wantedBinary;

    private static Client instance = null;

    // port = 8000
    // ip = 172.16.97.13
    private Client() {
        this.wantedBinary = true;
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
        String data = "";
        try {
            System.out.println("Try to connect...");
            this.socket = new DatagramSocket();
            this.address = InetAddress.getByName(SERVER_IP);
        } catch(IOException exception) {
            throw new Exception("Get by name failed");
        }

        System.out.println("Connected ...");

        try {
            data = this.wantedBinary ? TEAMNAME : "#" + TEAMNAME;
            System.out.println("Sending name.");
            this.sendData(data);
            System.out.println("OK.");
            System.out.println("Recieving player position.");
            data = this.receiveData();
            System.out.println("OK.");
            System.out.println(data);
            this.analyseFirstRequest(data);
            // then receive the map
        } catch(Exception sendDataException) {
            throw sendDataException;
        }
    }

    private void sendData(String data) {
        byte[] buffer = data.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, this.address, SERVER_PORT);
        packet.setData(buffer);
        try {
            this.socket.send(packet);
        } catch(IOException sendException) {
            return;
        }
    }

    public void sendPoint(int rawX, int rawY) {
        String x = "" + (char)(rawX + 65);
        String y = "" + rawY;

        String data = x + ":" + y;

        this.sendData(data);
    }

    public Point getOpponentPoint() {
        Point p = null;
        // opponent coup
        System.out.println("Raw data = " + this.receivedData);
        String[] rawData = this.receivedData.split( "\n" );
        String[] buffer = rawData[0].split(":");
        int x = buffer[2].charAt(0) - 65;
        int y = Integer.parseInt(buffer[3].trim());
        p = new Point(x, y);

        System.out.println(p);

        return p;
    }

    public State getNextState() {
        try {
            this.receivedData = this.receiveData();
            int code = Integer.parseInt(this.receivedData.substring(0, 2));
            if(code == 20) {
                return State.IS_OPPONENT_TURN;
            } else if(code == 10) {
                return State.IS_MINE_TURN;
            } else if(code == 88) {
                return State.IS_END_GAME;
            } else if(code == 21) {
                return State.IS_MINE_SHOT_ILLEGAL;
            } else if(code == 22) {
                return State.IS_ILLEGAL_OPPONENT_SHOT;
            }
        } catch(Exception exception) {
            return null;
        }

        return null;
    }

    public boolean isEndGame() {
        return this.isEndGame;
    }

    public Board recieveMap() {
        String data = "";
        try {
            data = this.receiveData();
        } catch(Exception exception) {
            return null;
        }

        return new Board(data, this.wantedBinary);
    }

    public boolean isFirstPlayer() {
        return this.position == 1;
    }

    private void analyseFirstRequest(String data) {
        this.position = Integer.parseInt(data.substring(1, 2));
    }

    private String receiveData() {
        byte[] buffer = new byte[BUFFER_SIZE];
        DatagramPacket packet = new DatagramPacket(buffer, BUFFER_SIZE, this.address, SERVER_PORT);
        try {
            this.socket.receive(packet);
        } catch(IOException receiveException) {
            return null;
        }

        return new String(packet.getData());
    }
}