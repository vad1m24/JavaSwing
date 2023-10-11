package main.java.by.task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame {
    private int WINDOW_HEIGHT = 300;
    private int WINDOW_WIDTH = 700;
    private int WINDOW_POS_X = 300;
    private int WINDOW_POS_Y = 100;
    private String WINDOW_TITLE = "Чат с логированием, сервер :";
    private String login;
    private LogHandler logHandler;
    private String msgText = "";
    private JButton sendButton = new JButton("Отправить");
    private JLabel inputLabel = new JLabel("Введите сообщение");
    private JTextField inputField = new JTextField();
    private JTextArea outputField = new JTextArea();
    private JPanel mainGrid = new JPanel(new GridLayout(1, 2));
    private JPanel inputGrid = new JPanel(new GridLayout(3, 1));

    ChatWindow(String login, String server, LogHandler logHandler) throws IOException {
        this.logHandler = logHandler;
        this.login = login;
        WINDOW_TITLE = WINDOW_TITLE + server;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(WINDOW_TITLE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        initWindow();

        inputGrid.add(outputField);
        inputGrid.add(inputLabel);
        inputGrid.add(inputField);
        mainGrid.add(inputGrid);
        mainGrid.add(sendButton);
        add(mainGrid);
        setVisible(true);
    }

    private void initWindow() throws IOException {
        outputField.enableInputMethods(false);
        outputField.setBackground(Color.LIGHT_GRAY);


        StringBuilder builder = new StringBuilder();
        for (String string : logHandler.Read()) {
            builder.append(string);
            builder.append("\n");
        }
        outputField.setText(builder.toString());


        //поле ввода-вывода
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss"));
                String msgText = dt + " " + login + ": " + inputField.getText();
                try {
                    logHandler.Write(msgText);
                    outputField.append(msgText);
                    outputField.append("\n");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                inputField.setText("");
            }
        });
        inputField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss"));
                    String msgText = dt + " " + login + ": " + inputField.getText();
                    try {
                        logHandler.Write(msgText);
                        outputField.append(msgText);
                        outputField.append("\n");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    inputField.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
}
