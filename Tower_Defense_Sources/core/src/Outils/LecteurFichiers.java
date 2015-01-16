package Outils;

import java.io.*;

public class LecteurFichiers
{
	public static int getInt(String file, String stat)
	{
		int valRet = -1;
		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			 
			try
			{
				String line;
				boolean trouve = false;
				while ((line = buff.readLine()) != null && trouve)
				{
					System.out.println(line);
					if(line.contains(stat))
					{
						trouve = true;
						valRet = Integer.parseInt(line.substring(line.indexOf(":") + 1));
					}
				}
			}
			finally
			{
				buff.close();
			}
		}
		catch (IOException ioe)
		{
			System.out.println("Erreur --" + ioe.toString());
			System.exit(-1);
		}
		return valRet;
	}
}
