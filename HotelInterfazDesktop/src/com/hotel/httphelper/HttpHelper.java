package com.hotel.httphelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hotel.dto.TipoHabitacionFront;

public class HttpHelper {
	
	
	public static List<TipoHabitacionFront> obtenerTiposHabitaciones() throws Exception{
		String response = HttpHelper.obtenerFromUrl("http://localhost:8080/tipohab/listar");
		Gson gson = new Gson();
		Type tipoLista = TypeToken.getParameterized(List.class, TipoHabitacionFront.class).getType();		
		return gson.fromJson(response, tipoLista);
	}
	
	public static String obtenerFromUrl(String url) throws Exception {
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		
		int codigoRespuesta = con.getResponseCode();
		
		if(codigoRespuesta == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			String linea;
			StringBuffer respuestaCompleta =new StringBuffer();
			
			while((linea = in.readLine()) != null) {
				respuestaCompleta.append(linea);
			}
			System.out.println(respuestaCompleta.toString());
			return respuestaCompleta.toString();
		} else {
			System.err.println("La peticion Get no funciono Codigo fallido " + codigoRespuesta );
			throw new Exception("La peticion Get no funciono Codigo fallido ");
		}		
	}
	
	
	
	
	
	
	
	private static String sendPOST(String url, String body) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		//con.setRequestProperty("User-Agent", USER_AGENT);
		con.setDoOutput(true);
		
		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(body.getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("POST request did not work.");
		}
		return null;
	}
}
