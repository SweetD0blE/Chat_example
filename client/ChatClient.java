import java.io.*;
import java.net.*;

public class ChatClient {		
	
    public static void main(String[] args) throws Exception {
        Socket sock = new Socket("127.0.0.1",
                                 8095);
        OutputStream output  = sock.getOutputStream();
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	
	String message;
	System.out.println("Введите nickname: ");
	
	String nickname = br.readLine();
	String strInv = nickname + ": ";
	System.out.println(strInv);
	output.write(nickname);
	
	while (( message = br.readLine()) != null) {
	    if (message.length() == 0) {
		output.write ("\n".getBytes() );
		break;
	    }
	    message = message + "\n";
	    output.write(message.getBytes());
	    System.out.print(strInv);
	}
	output.close();
    }
}
