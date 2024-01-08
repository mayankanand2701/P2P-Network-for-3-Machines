package Project;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
import java.net.*;
public class H2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress h1Address = InetAddress.getByName("localhost"); // Replace with the actual H1 address
            int h1Port = 1042;

            // Send request to H1
            byte[] buffer = new byte[1024];
            DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length, h1Address, h1Port);
            socket.send(requestPacket);

            // Receive response from H1
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);
            String dateTime = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("H2 :- Received Date and Time from H1 : " + dateTime);

            // Close the socket
            socket.close();
        } 
		catch (Exception e) {
            e.printStackTrace();
        }
	}

}