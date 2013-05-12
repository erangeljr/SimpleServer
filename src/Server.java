import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Server extends JFrame{
	
	private JTextField enterField;
	private JTextArea displayArea;

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
		
		super("Server Application");
		
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
	
	public void runServer(){
		
	}
	
	private void sendData(String actionCommand) {
		// TODO Auto-generated method stub
		
	}

}//End Class
