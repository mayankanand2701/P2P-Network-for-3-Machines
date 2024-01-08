package Project;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
import java.net.*;
import java.util.Date;
public class DS {//DS DayTime Service Provider
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            DatagramSocket socket = new DatagramSocket(1042); 
            System.out.println("DS: Waiting for requests...");//indicating that the DS is waiting for request
            while (true) {
                byte[] buffer = new byte[1024];//creating an array of byte type
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);//storing the data

                socket.receive(dp);//receiving incoming data
                //Extract the client's address and port from the received packet
                InetAddress clientAddress = dp.getAddress();
                int clientPort = dp.getPort();
               // Get current date and time
                String dateTime = new Date().toString();
                buffer = dateTime.getBytes();

                // Send response to H1
                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
                //read/receive current date and time data and the client's address and port
                socket.send(responsePacket);
                //send the response packet back to the client (H1).
                System.out.println("DS: Sent date and time to H1");
            }
        }
		catch (Exception e) {
            e.printStackTrace();
        }
	}

}

