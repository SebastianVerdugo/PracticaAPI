package PracticaAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class main {
	
	/*
	 * 1.- Consumir API Rick y Morty
	 * 2.- Transformar la informacion en una coleccion de personajes
	 * 3.- Ordenar la informaicon con un criterio propio
	 * 4.- Buscar la informacion con criterio propio
	 */
	
	public static void main (String args [])
	{
		System.out.println("Practia API Rick y Morty");
		System.out.println();
		System.out.println();
		Scanner sc = new Scanner (System.in);
		int pag=1;
		int iterador=0;
		int iaux=0;
		int opc=0;
		ApiHelper api = new ApiHelper();
		Personaje [] personajesg = new Personaje [826];
		while(pag<=42)
		{
			 String datos = api.get("https://rickandmortyapi.com/api/character?page="+pag);
		     //System.out.println(datos);
		     JsonHelper jsonHelper = new JsonHelper();
		     Personaje [] personajes = jsonHelper.convertJsonAPersonajes(datos);
		     while(iaux<20 && iterador<826)
		     {
		    	 personajesg[iterador]=personajes[iaux];
		    	 iterador++;
		    	 iaux++;
		     }
		     iaux=0;
		     pag++;
		}
		ComparadorNombre comparableNombre = new ComparadorNombre();
		Arrays.sort(personajesg, comparableNombre);
		System.out.println("Nombres ordenados:");
		System.out.println();
        if(personajesg != null)
        {
            for (int i =0; i<personajesg.length; i++) 
            {
                System.out.println(personajesg[i].getName());
            }
        }
        System.out.println();
       
        while(opc!=4)
        {
        	System.out.println("----Busqueda de elementos opciones:----");
			System.out.println("1.- Buscar id por nombre:");
			System.out.println("2.- Buscar url por id");
			System.out.println("3.- Buscar nombre por url");
			System.out.println("4.- Dejar de buscar");
			System.out.println();
            System.out.print("Escriba la opcion de busqueda: ");
        	opc= sc.nextInt();
        	System.out.println();
        	menusBusqueda(opc, personajesg);
        }
       
       
       
	}
	
	public static void menusBusqueda(int opc, Personaje[] personajesg)
	{
		Scanner sc = new Scanner (System.in);
		String nombre= "", url = "";
		int id=0;
		System.out.println();
		switch(opc)
		{
			case 1:
				int result;
				System.out.print("Escriba el nombre del personaje para buscar su id: ");
				nombre = sc.next();
				System.out.println();
				ComparadorNombre comparableNombre = new ComparadorNombre();
				Arrays.sort(personajesg, comparableNombre);
				result= Arrays.binarySearch(personajesg, new Personaje(0, nombre, null), comparableNombre);
				//por alguna razon cuando el string tiene espacios manda el indice correcto pero en negativo, por eso se multiplica
				//por -1 cuando es menor a -1
				if(result<0)
				{
					if(result<-1)
					{
						result=result*-1;
					}
					else
					{
						System.out.println("No se encontro el personaje");
						break;
					}
				}
				System.out.println("id: "+personajesg[result].getID());
				break;
			case 2:
				System.out.print("Escriba el id del personaje para buscar su URL: ");
				id = sc.nextInt();
				System.out.println();
				ComparadorID comparableID = new ComparadorID ();
				Arrays.sort(personajesg, comparableID);
				System.out.println("URL: "+personajesg[Arrays.binarySearch(personajesg, new Personaje(id, null, null), comparableID)].getURL());
				System.out.println();
				break;
			case 3:
				System.out.print("Escriba el url del personaje para buscar su nombre: ");
				url= sc.next();
				System.out.println();
				ComparadorURL comparableURL = new ComparadorURL ();
				Arrays.sort(personajesg, comparableURL);
				System.out.println("Nombre: "+personajesg[Arrays.binarySearch(personajesg, new Personaje (0, null, url), comparableURL)].getName());
				System.out.println();
				break;
		}
	}
		/*
		main m = new main();
		String apiURL = "https://rickandmortyapi.com/api/character";
		String json = m.getData(apiURL);
		JsonParser jsonParser = new JsonParser();
		JsonElement personajesJason = jsonParser.parse(json);
		System.out.println(jsonParser.parse(json).getAsJsonObject().get("results"));
		Personaje [] p = new Gson().fromJson(personajesJason, )
		
		Personaje[] p = new G
		try
		{
			m.getAPI();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getData (String URL ) throws IOException
	{
		URL url = new URL(" https://rickandmortyapi.com/api/character");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(
				  new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		return content;
	}
    */
}
