package clients;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;



public class ClientLuisteraar {
	public static void main(String[] args) {
		new ClientLuisteraar().run();
	}
	private void run() {
		System.out.println("Client Luisteraar ontvangt de lijst");
		//TODO  Maak een UDP toegang om één pakket te ontvangen op poort 9999
		//      Wacht op het pakket en toon de ontvangen lijst van auto's af op het scherm
		//      Beeindig de client

		try(DatagramSocket datagramSocket = new DatagramSocket(9999)){
			byte[] buffer = new byte[100];
			DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
			datagramSocket.receive(dp);
			System.out.println(new String(dp.getData(),dp.getOffset(),dp.getLength()));
		}catch(IOException io) {
			io.printStackTrace();
		}
	}

}
