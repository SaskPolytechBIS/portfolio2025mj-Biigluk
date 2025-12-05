
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vuong
 */
public class ClientGUIConsole extends JFrame implements ChatIF {

    private JButton closeB = new JButton("Close");
    private JButton openB = new JButton("Open");
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
        bottom.add(openB);
        bottom.add(sendB);
        bottom.add(closeB);
        bottom.add(quitB);
        setVisible(true);
        sendB.addActionListener((ActionEvent e) -> {
            //send();
            display(messageTxF.getText() + "\n");
        });
    }

    @Override
    public void display(String message) {
        messageList.insert(message, 0);
    }

    public static void main (String[] args){
        ClientGUIConsole console = new ClientGUIConsole("localhost", 5555);
        
    }
}
