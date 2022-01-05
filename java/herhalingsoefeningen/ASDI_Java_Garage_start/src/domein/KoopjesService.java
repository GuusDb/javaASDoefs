package domein;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

public class KoopjesService extends Thread {
	private List<Auto> koopjes = new ArrayList<>();
//	private List<    > clients = new ArrayList<>();

	public KoopjesService() { // voorlopig één klant op localhost (dit werken we niet verder uit, klanten
							  // kunnen zich hier registreren)
/*		try {
			clients.add(           ); //
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public void run() {
		//TODO voorzie zowel toegang tot UDP (uitvoer lijst van auto's) als TCP (invoer auto's)
		//
		
		// start lus om telkens de info van één aanbieder te ontvangen
					System.out.println("wacht op aanbieder");
		
		// indien verbinding lees de info

					
					System.out.println("aanbieding toegevoegd");
		// beëindig de TCP verbinding
					
		// maak packetje klaar met de lijst van auto's als één string en verstuur naar alle
		// alle geregistreerde ClientLuisteraars
					
		//einde lus
	}
}
