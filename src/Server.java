import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JFrame;

public class Server extends JFrame{

	//Output Stream to Client
	private ObjectOutputStream output;
	//Input Stream from Client
	private ObjectInputStream input;
	//ServerSocket
	private ServerSocket server;
	//Connection to Client
	private Server connection;
	private int counter = 1;
	
	//Default Constructor
	public Server(){

	}

	
}
