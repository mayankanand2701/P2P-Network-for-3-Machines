package Project;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
import java.net.*;
public class H1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Create a DatagramSocket named socket for communication using UDP
            DatagramSocket socket = new DatagramSocket();
            //InetAddress represents IPAddress of the DS machine
            InetAddress dsAddress = InetAddress.getByName("localhost"); // Replace with the actual DS address
            int dsPort = 1042;//port number of DS

            // Send request to DS
            byte[] buffer = new byte[1024];
            //array named buffer to hold data that H1 sends
            DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length, dsAddress, dsPort);
            //encapsulates the data from the buffer and specifies the destination address and port.
            socket.send(requestPacket);
            //sends the DatagramPacket to the specified address and port using the DatagramSocket.

            // Receive response from DS
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);
            String dateTime = new String(responsePacket.getData(), 0, responsePacket.getLength());
            //Extract the date and time info from the received packet
            System.out.println("H1 :- Received Date and Time from DS : " + dateTime);

            // Close the socket to release resources
            socket.close();
        } 
		catch (Exception e) {
            e.printStackTrace();
        }
	}
}

