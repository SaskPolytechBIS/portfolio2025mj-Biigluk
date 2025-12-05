
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author oksma
 */
public class ClientGUIConsole extends JFrame implements ChatIF {

    final public static int DEFAULT_PORT = 5555;
    ChatClient client;

    private JButton logoutB = new JButton("Logout");
    private JButton loginB = new JButton("Login");
    private JButton sendB = new JButton("Send");
    private JButton quitB = new JButton("Quit");

    private JTextField portTxF = new JTextField("5555");
    private JTextField hostTxF = new JTextField("127.0.0.1");
    private JTextField messageTxF = new JTextField("");

    private JLabel portLB = new JLabel("Port: ", JLabel.RIGHT);
    private JLabel hostLB = new JLabel("Host: ", JLabel.RIGHT);
    private JLabel messageLB = new JLabel("Message: ", JLabel.RIGHT);

    private JTextArea messageList = new JTextArea();

    public ClientGUIConsole(String host, int port) {
        super("Simple Chat GUI");
        setSize(300, 400);

        setLayout(new BorderLayout(5, 5));
        JPanel bottom = new JPanel();
        add("Center", messageList);
        add("South", bottom);

        bottom.setLayout(new GridLayout(5, 2, 5, 5));
        bottom.add(hostLB);
        bottom.add(hostTxF);
        bottom.add(portLB);
        bottom.add(portTxF);
        bottom.add(messageLB);
        bottom.add(messageTxF);
        bottom.add(loginB);
        bottom.add(sendB);
        bottom.add(logoutB);
        bottom.add(quitB);

        setVisible(true);

        sendB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                send(messageTxF.getText() + "\n");
//                display(messageTxF.getText() + "\n");
            }
        });

        logoutB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Logout();
            }
        });

        loginB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login(messageTxF.getText() + "\n");
//                display(messageTxF.getText() + "\n");
            }
        });

        try {
            client = new ChatClient(host, port, this);

        } catch (IOException exception) {
            System.out.println("cannot connect....");
        }
    }

    public void login(String message) {
        client.handleMessageFromClientUI("#login " + message);
    }

    public void Logout() {
        client.handleMessageFromClientUI("#logoff");

    }

    public void send(String message) {
        client.handleMessageFromClientUI(message);
    }

    public void display(String message) {
        messageList.insert(message, 0);
    }

    public static void main(String[] args) {
        String host = "";
        int port = 0;
        try {
            host = args[0];
            port = Integer.parseInt(args[1]);

        } catch (ArrayIndexOutOfBoundsException e) {
            host = "localhost";
            port = DEFAULT_PORT;
        }
        ClientGUIConsole gui = new ClientGUIConsole("localhost", 555);
        // TODO code application logic here
    }

}
