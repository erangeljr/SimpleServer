import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Server connection;
	private int counter = 1;
}
