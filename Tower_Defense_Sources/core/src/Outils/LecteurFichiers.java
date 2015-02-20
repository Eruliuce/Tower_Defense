package Outils;

import java.io.*;
import java.util.ArrayList;

import monstres.ModeleMonstre;

public class LecteurFichiers
{
	private static int extractInt(String line, String stat) throws NumberFormatException
	{
		int ret = -1;
		try
		{
			ret = Integer.parseInt(line.substring(line.indexOf(":") + 1));
		}
		catch(NumberFormatException e)
		{
			System.err.println("Erreur : " + e);
			System.exit(-1);
		}
		return ret;
	}
	
	private static float extractFloat(String line, String stat) throws NumberFormatException
	{
		float ret = -1.f;
		try
		{
			ret = Float.parseFloat(line.substring(line.indexOf(":") + 1));
		}
		catch(NumberFormatException e)
		{
			System.err.println("Erreur : " + e);
			System.exit(-1);
		}
		return ret;
	}
	
	private static String extractString(String line, String stat)
	{
		return line.substring(line.indexOf(":") + 1);
	}
		
	public static int getInt(String file, String stat)
	{
		int v = -1;
		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			try
			{
				String line;
				boolean trouve = false;
				while ((line = buff.readLine()) != null && !trouve)
				{
					if(line.contains(stat))
					{
						v = extractInt(line, stat);
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
			System.err.println("Erreur : " + e.toString());
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
				while ((line = buff.readLine()) != null && !trouve)
				{
					if(line.contains(stat))
					{
						v = extractFloat(line, stat);
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
			System.err.println("Erreur : " + e);
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
				while ((line = buff.readLine()) != null && !trouve)
				{
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
			System.err.println("Erreur : " + e);
			System.exit(-1);
		}
		return valRet;
	}

	public static ArrayList<ModeleMonstre> getListeModelesMonstres(String file)
	{
		ArrayList<ModeleMonstre> liste = new ArrayList<ModeleMonstre>();
		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			try
			{
				String line, name = "", image = "";
				int pv = -1, vitesse = -1, attaque = -1, recompense = -1, cout = -1;
				boolean invisible = false, volant = false;
				while((line = buff.readLine()) != null)
				{
					if(line.equals("/"))
					{
						liste.add(new ModeleMonstre(name, pv, vitesse, image, attaque, recompense, cout, invisible, volant));
					}
					else
					{
						if(line.contains("name"))
							name = extractString(line, "name");
						else if(line.contains("pv"))
							pv = extractInt(line, "pv");
						else if(line.contains("vitesse"))
							vitesse = extractInt(line, "vitesse");
						else if(line.contains("image"))
							image = extractString(line, "image");
						else if(line.contains("attaque"))
							attaque = extractInt(line, "attaque");
						else if(line.contains("recompense"))
							recompense = extractInt(line, "recompense");
						else if(line.contains("cout"))
							cout = extractInt(line, "cout");
						else if(line.contains("invisible"))
							invisible = extractString(line, "invisible").equals("true") ? true : false;
						else if(line.contains("volant"))
							volant = extractString(line, "volant").equals("true") ? true : false;
						else
						{
							System.err.println("Erreur dans le format du fichier " + file + " à la ligne :\n" + line);
							System.exit(-1);
						}
					}
				}
			}
			finally
			{
				buff.close();
			}
		}
		catch(IOException e)
		{
			System.err.println("Erreur : " + e);
			System.exit(-1);
		}
		return liste;
	}
	
	public static void main(String args[])
	{
		LecteurFichiers.getInt("..\\desktop\\FichiersConf\\Constantes.conf", "vieBaseJoueur");
	}
}
