package br.com.magalutest.api.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestProduto {

	public static String getProdutos(int pagina) {
		String output = "";
		try {
			URL url = new URL("http://challenge-api.luizalabs.com/api/product/?page=" + pagina);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader( (conn.getInputStream())));
			String linha;
			System.out.println("Output from Server .... \n");
			while ((linha = br.readLine()) != null) {
				output = output + linha;
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static String getProduto(String idProduto) {
		String output = "";
		try {
			URL url = new URL("http://challenge-api.luizalabs.com/api/product/" + idProduto + "/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader( (conn.getInputStream())));
				String linha;
				System.out.println("Output from Server .... \n");
				while ((linha = br.readLine()) != null) {
					output = output + linha;
				}
				conn.disconnect();
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}	
}
