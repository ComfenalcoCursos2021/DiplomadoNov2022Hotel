package com.hotel.httphelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

public class HttpHelper {
	
	
	public static <T> T ejecutarPOST(String url, Object obj, Class<T> tipo) throws Exception {
		
		
		JsonSerializer<Date> serializador = new JsonSerializer<Date>() {
			public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
				return src == null ? null : new JsonPrimitive(src.getTime());
			};
		};
		
		
		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, serializador).create();
		String body = gson.toJson(obj,tipo);
		System.out.println(body);
		String respuesta = sendPOST(url, body);
		return convertirDesdeJson(respuesta,tipo);
	}
	
	public static <T> T ejecutarGET(String url, Class<T> tipo) throws Exception {
		String respuesta = obtenerFromUrl(url);
		return convertirDesdeJson(respuesta,tipo);
	}
	public static <T> List<T> ejecutarGETList(String url, Class<T> tipo) throws Exception {
		String respuesta = obtenerFromUrl(url);
		return convertirDesdeJsonLista(respuesta,tipo);
	}
	
	
	public static <T> T convertirDesdeJson(String json, Class<T> tipo) {
		Gson gson = new Gson();
		Type tipoGson = TypeToken.getParameterized(tipo).getType();
		return gson.fromJson(json, tipoGson);		
	}
	public static <T> List<T> convertirDesdeJsonLista(String json, Class<T> tipo) {
		Gson gson = new Gson();
		Type tipoGsonList = TypeToken.getParameterized(List.class,tipo).getType();
		return gson.fromJson(json, tipoGsonList);		
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
