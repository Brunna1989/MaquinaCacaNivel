package servidor;

import client.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 12345;
    private static final String SECRET_KEY = "1a09698bd334ba19a0bfe21e7cbbdf8af19e8381d2e4ede8d8b784e9f08207c5"; // Substitua pela mesma chave do cliente

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("servidor.Server started. Waiting for app.ClientMachine...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                Thread clientThread = new Thread(new ClientHandler(clientSocket, SECRET_KEY));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}