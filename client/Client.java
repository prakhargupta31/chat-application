package client;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Client extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public Client() {
        setTitle("Client");
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

    public void connect() {
        new Thread(() -> {
            try {
                socket = new Socket("127.0.0.1", 5000);
                chatArea.append("Connected to server!\n");

                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);

                receiveMessages();

            } catch (Exception e) {
                chatArea.append("Connection Error: " + e.getMessage() + "\n");
            }
        }).start();
    }

    private void receiveMessages() {
        try {
            String msg;
            while ((msg = reader.readLine()) != null) {
                chatArea.append("Server: " + msg + "\n");
            }
        } catch (Exception e) {
            chatArea.append("Server disconnected.\n");
        }
    }

    private void sendMessage() {
        String msg = inputField.getText();
        if (!msg.isEmpty()) {
            writer.println(msg);
            chatArea.append("Client: " + msg + "\n");
            inputField.setText("");
        }
    }
}
