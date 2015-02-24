package Reseau;

import java.io.IOException;
import java.net.*;

import javax.xml.stream.events.StartDocument;


public class Controleur_reseau implements Runnable
{
	private final int PORT = 10666;
	private ServerSocket servSock;
	private Socket sock;

	public Controleur_reseau()
	{
		try
		{
			servSock = new ServerSocket(PORT);
<<<<<<< HEAD
			//start();
=======
			// start();
>>>>>>> 4efda73d2c765ea595a325a9133b29eef9306b91
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run()
	{
		try
		{
			sock = servSock.accept();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
