
import java.io.IOException;
import java.util.ArrayList;

public class EchoServer extends AbstractServer {
    //Class variables *************************************************

    /**
     * The default port to listen on.
     */
    final public static int DEFAULT_PORT = 5555;

    //Constructors ****************************************************
    /**
     * Constructs an instance of the echo server.
     *
     * @param port The port number to connect on.
     */
    public EchoServer(int port) {

        super(port);

        try {
            this.listen(); //Start listening for connections
        } catch (Exception ex) {
            System.out.println("ERROR - Could not listen for clients!");
        }

    }

    //Instance methods ************************************************
    /**
     * This method handles any messages received from the client.
     *
     * @param msg The message received from the client.
     * @param client The connection from which the message originated.
     */
    public void handleMessageFromClient(Object msg, ConnectionToClient client) {
        if (msg instanceof Envelope) {
            Envelope env = (Envelope) msg;
            handleCommandFromClient(env, client);
        } else {
            System.out.println("Message received: " + msg + " from " + client);
            String userId;
            userId = client.getInfo("userId").toString();
            this.sendToAllClientsInRooms(userId + ": " + msg, client);
        }
    }

    public void handleCommandFromClient(Envelope env, ConnectionToClient client) {
        if (env.getId().equals("#login")) {
            String userId = env.getContents().toString();
            client.setInfo("userId", userId);
        }
        if (env.getId().equals("#join")) {
            String roomName = env.getContents().toString();
            client.setInfo("RoomName", roomName);
        }

        if (env.getId().equals("#pm")) {
            String target = env.getArg();
            String message = env.getContents().toString();
            sendToAClient(message, target, client);
        }
        if (env.getId().equals("#pm")) {
            String userId = env.getContents().toString();
            String message = env.getContents().toString();
            this.sendToAllClients(userId + " yells: " + message);
        }

        //#who
        if (env.getId().equals("#who")) {
            this.sendRoomListToClient(client);
        }

    }

    /**
     * This method overrides the one in the superclass. Called when the server
     * starts listening for connections.
     */
    protected void serverStarted() {
        System.out.println("Server listening for connections on port " + getPort());
    }

    /**
     * This method overrides the one in the superclass. Called when the server
     * stops listening for connections.
     */
    protected void serverStopped() {
        System.out.println("Server has stopped listening for connections.");
    }

    //Class methods ***************************************************
    /**
     * This method is responsible for the creation of the server instance (there
     * is no UI in this phase).
     *
     * @param args[0] The port number to listen on. Defaults to 5555 if no
     * argument is entered.
     */
    public static void main(String[] args) {
        int port = 0; //Port to listen on

        try {
            port = Integer.parseInt(args[0]);
        } catch (ArrayIndexOutOfBoundsException oob) {
            port = DEFAULT_PORT; //Set port to 5555
        }

        EchoServer sv = new EchoServer(port);

        try {
            sv.listen(); //Start listening for connections
        } catch (Exception ex) {
            System.out.println("ERROR - Could not listen for clients!");
        }

    }

    @Override
    protected void clientConnected(ConnectionToClient client) {

        System.out.println("<Client Connected:" + client.toString() + ">");
        client.setInfo("userId", "guest");
        client.setInfo("RoomName", "lobby");

    }

    // an example of how framework can be extended
    public void sendToAClient(Object msg, String pmTarget, ConnectionToClient client) //this is the workhose
    {
        Thread[] clientThreadList = getClientConnections();

        for (int i = 0; i < clientThreadList.length; i++) {
            //If thread is the one you want
            ConnectionToClient target = (ConnectionToClient) clientThreadList[i];
            if (target.getInfo("userId").equals(pmTarget)) {
                try {
                    target.sendToClient(client.getInfo("userId") + ": " + msg);
                } catch (Exception ex) {
                    //try not to leave the exception empty
                    ex.printStackTrace();
                }
            }
        }
    }

    public void sendToAllClientsInRooms(Object msg, ConnectionToClient client) {
        Thread[] clientThreadList = getClientConnections();
        String room = (String) client.getInfo("RoomName");
        for (Thread clientThreadList1 : clientThreadList) {
            //If thread is the one you want
            ConnectionToClient target = (ConnectionToClient) clientThreadList1;
            if (target.getInfo("RoomName").equals(room)) {
                try {
                    target.sendToClient(client.getInfo("userId") + ": " + msg);
                } catch (IOException ex) {
                    //try not to leave the exception empty
                    ex.printStackTrace();
                }
            }
        }
    }

    public void sendRoomListToClient(ConnectionToClient client) {
        Envelope env = new Envelope();
        env.setId("#who");
        ArrayList<String> userList = new ArrayList<String>();

        Thread[] clientThreadList = getClientConnections();
        for (Thread clientCon : clientThreadList) {
            ConnectionToClient target = (ConnectionToClient) clientCon;
            userList.add(target.getInfo("userId").toString());
        }

        env.setContents(userList);
        try {
            client.sendToClient(env);
        } catch (Exception ex) {
            System.out.println("fail to send user list to client");
        }
    }

    //hook method implementation overwrite
    @Override
    synchronized protected void clientDisconnected(ConnectionToClient client) {
        System.out.println("<Client Disconnected:" + client.toString() + ">");
    }

    @Override
    synchronized protected void clientException(
            ConnectionToClient client, Throwable exception) {
        System.out.println("< " + client.getName() + " has disconnected.");
    }

}
//End of EchoServer class
