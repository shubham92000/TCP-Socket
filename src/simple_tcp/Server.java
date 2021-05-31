package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws Exception{
        ServerSocket server_socket = new ServerSocket(2020);
        System.out.println("Port 2020 is open");

        Socket socket = server_socket.accept();
        System.out.println("Client "+socket.getInetAddress() + "has connected");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        out_socket.println("Welcome");
        String message = in_socket.readLine();

        System.out.println("Client says : " + message);

        socket.close();
        System.out.println("Socket is closed");
        server_socket.close();
    }



    public static void main(String[] args) throws Exception {
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
