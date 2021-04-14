import java.net.Socket;
import java.net.ServerSocket;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class ChatServer {

    public static void main(String[] args) throws Exception {
        // Привязываемся к указанному адресу на локальном компьютере
        // (начинаем слушать подключения)
        ServerSocket serverSocket = new ServerSocket(8095);
	
        while (true) {
	  Socket clientSocket = serverSocket.accept();

	  OutputStream output = clientSocket.getOutputStream();
	  InputStream input = clientSocket.getInputStream();
	  BufferedReader br = new BufferedReader( new InputStreamReader(input) );

	  System.out.println("Клиент подключился!");
	  String nick = br.readLine();
	  System.out.println("-->" + nick + " вошёл(шла) в чат");

	  String message;
	  while (( message = br.readLine()) != null) {
	      if(message.equals("\n")) {
		  break;
	      }
	      System.out.println(nick + ": " + message);
	  }
	  System.out.println("<--" + nick + " покинул(а) чат");
	  
	  output.close();
	  input.close();
	}
    }
}
	
       
