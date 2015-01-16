package Outils;

import java.io.*;
import java.util.ArrayList;

public class LecteurFichiers
{
	private static int extractInt(String line, String stat) throws NumberFormatException
	{
		return Integer.parseInt(line.substring(line.indexOf(":") + 1));
	}
	
	private static float extractFloat(String line, String stat) throws NumberFormatException
	{
		return Float.parseFloat(line.substring(line.indexOf(":") + 1));
	}
	
	private static String extractString(String line, String stat)
	{
		return line.substring(line.indexOf(":") + 1);
	}
		
	public static int getInt(String file, String stat)
	{
		int v = 0;
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
						try
						{
							v = extractInt(line, stat);
						}
						catch(NumberFormatException e)
						{
							System.out.println("Erreur : " + e.toString());
							System.exit(-1);
						}
						trouve = true;
					}
				}
			}
			finally
			{
				buff.close();
			}
		}
		catch (IOException e)
		{
			System.out.println("Erreur : " + e.toString());
			System.exit(-1);
		}
		return v;
	}
	
	public static float getFloat(String file, String stat)
	{
		float v = 0.f;
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
						try
						{
							v = extractFloat(line, stat);
						}
						catch(NumberFormatException e)
						{
							System.out.println("Erreur : " + e.toString());
							System.exit(-1);
						}
						trouve = true;
					}
				}
			}
			finally
			{
				buff.close();
			}
		}
		catch (IOException e)
		{
			System.out.println("Erreur : " + e.toString());
			System.exit(-1);
		}
		return v;
	}
	
	public static String getString(String file, String stat)
	{
		String valRet = "";
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
						valRet = extractString(line, stat);
						trouve = true;
					}
				}
			}
			finally
			{
				buff.close();
			}
		}
		catch (IOException e)
		{
			System.out.println("Erreur : " + e.toString());
			System.exit(-1);
		}
		return valRet;
	}
	
	/* A terminer :
	public static ArrayList<ModeleMonstre> getListeModelesMonstres
	{
		ArrayList<ModeleMonstre> liste = new ArrayList<ModeleMonstre>();
		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			try
			{
				String line;
				
			}
		}
		catch
		return liste;
	}
	*/
}
