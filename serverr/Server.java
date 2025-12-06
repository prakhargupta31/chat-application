package serverr;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Server extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;

    public Server() {
        setTitle("Server");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());
        inputField = new JTextField();
        sendButton = new JButton("Send");
        bottom.add(inputField, BorderLayout.CENTER);
        bottom.add(sendButton, BorderLayout.EAST);
        add(bottom, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        setVisible(true);
    }

    public void startServer() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(5000);
                chatArea.append("Server started. Waiting for client...\n");

                clientSocket = serverSocket.accept();
                chatArea.append("Client connected!\n");

                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream(), true);

                receiveMessages();
            } catch (Exception e) {
                chatArea.append("Error: " + e.getMessage() + "\n");
            }
        }).start();
    }

    private void receiveMessages() {
        try {
            String msg;
            while ((msg = reader.readLine()) != null) {
                chatArea.append("Client: " + msg + "\n");
            }
        } catch (Exception e) {
            chatArea.append("Client disconnected.\n");
        }
    }

    private void sendMessage() {
        String msg = inputField.getText();
        if (!msg.isEmpty()) {
            writer.println(msg);
            chatArea.append("Server: " + msg + "\n");
            inputField.setText("");
        }
    }
}
