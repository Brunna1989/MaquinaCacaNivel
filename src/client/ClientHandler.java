package client;

import criptografia.AESUtil;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private static final String SECRET_KEY = "1a09698bd334ba19a0bfe21e7cbbdf8af19e8381d2e4ede8d8b784e9f08207c5";

    public ClientHandler(Socket clientSocket, String secretKey) {
        this.clientSocket = clientSocket;
        try {
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String encryptedRequest = (String) inputStream.readObject();
                String decryptedRequest = AESUtil.decrypt(encryptedRequest, SECRET_KEY);
                if (decryptedRequest.equals("PLAY")) {
                    int result = playSlotMachine();
                    String encryptedResult = AESUtil.encrypt(String.valueOf(result), SECRET_KEY);
                    outputStream.writeObject(encryptedResult);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int playSlotMachine() {
        return (int) (Math.random() * 7);
    }
}
