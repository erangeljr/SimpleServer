import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame{
	
	private JTextField enterField;
	private JTextArea displayArea;

	//Output Stream to Client
	private ObjectOutputStream output;
	//Input Stream from Client
	private ObjectInputStream input;
	
	private String message = "";
	private String chatServer;
	private Socket client;
	
	//Default Constructor
	public Client(String host){
		
		super("Client Application");
		
		chatServer = host;
		
	}

}
