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
			// start();
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
