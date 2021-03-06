import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.InetAddress;
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
		
		enterField = new JTextField();
		enterField.setEditable(false);
		
		enterField.addActionListener(
			//Anonymous Class
			new ActionListener(){
				
				public void actionPerformed(ActionEvent event){
					
					sendData(event.getActionCommand());
					enterField.setText("");
				}
	
			});
		
		add(enterField, BorderLayout.NORTH);
		displayArea = new JTextArea();
		add(new JScrollPane(displayArea),BorderLayout.CENTER);
		
		//Setting Up Window
		setSize(350,150);
		setVisible(true);
					
	}//End Default Constructor
	
	public void runClient(){
		
		try{
			
			connectToServer();
			getStreams();
			processConnection();
			
		}
		catch(EOFException e){
			displayMessage("\nClient Terminated Connection");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			closeConnection();
		}
	}

	private void closeConnection() {
		// TODO Auto-generated method stub
		displayMessage("\nClosing Connection");
		setTextFieldEditable(false);
		
		try{
			
			input.close();
			output.close();
			client.close();			
		}
		catch(IOException e){
			e.printStackTrace();
		}
				
		
	}

	private void displayMessage(final String message) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(
				
			new Runnable(){
				
				public void run(){
					
					displayArea.append(message);
				}
			}
			
			);	
		
	}

	private void getStreams() throws IOException {
		// TODO Auto-generated method stub
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush();
		
		input = new ObjectInputStream(client.getInputStream());
		
		displayMessage("\nGot IO Streams");
				
	}

	private void processConnection() throws IOException{
		// TODO Auto-generated method stub
		setTextFieldEditable(true);
		
		do{
			
			try{
				
				message = (String) input.readObject();
				displayMessage("\n" + message);
			}
			catch(ClassNotFoundException e){
				displayMessage("\nUnknown object type received");
			}
		}
		while(!message.equals("SERVER>>>TERMINATE"));
		
		
	}

	private void setTextFieldEditable(final boolean isEditable) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(
					
				new Runnable(){
					
					public void run(){
						enterField.setEditable(isEditable);
					}
				}		
			);
		
	}

	private void connectToServer() throws IOException{
		// TODO Auto-generated method stub
		displayMessage("Attempting Connection");
		
		client = new Socket(InetAddress.getByName(chatServer), 12345);
		
		displayMessage("Connected to: " + client.getInetAddress().getHostName());
				
	}

	private void sendData(String message) {
		// TODO Auto-generated method stub
		try{
			
			output.writeObject("CLIENT>>>" + message);
			output.flush();
			displayMessage("\nCLIENT>>>" + message);
		}
		catch(IOException e){
			displayMessage("\nError writing object");
		}
		
	}

}//End Class
