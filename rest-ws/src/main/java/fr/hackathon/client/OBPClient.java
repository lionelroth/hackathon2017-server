package fr.hackathon.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Client appelé pour envoyer des requetes à l'API OBP
 */
public class OBPClient {

	private static final String URL_ROOT = "https://socgen-k-api.openbankproject.com";
	private static final String URL_OBP_DIRECT_LOGIN = URL_ROOT + "/my/logins/direct";	// nedpoint direct login
	
	/**
	 * testing only
	 */
	public static void main(String[] args) {
		String token = directLogin();
		System.out.println("token received : " + token);
		boolean success = effectuerVirement(token, Float.parseFloat("10.15"));
		System.out.println("virement ? success " + success);
	}

	/**
	 * Directlogin API OBP
	 */
	private static String directLogin() {
		String token = "";
		try {
			URL url = new URL(URL_OBP_DIRECT_LOGIN);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			String username = "1000203892";	// id de l'utilisateur qui sera débité (socgen-k)
			String pwd = "123456";			// mdp associé
			
//			String consumerKey = "sjyie0auvpkixmovtk5ycqrttsqyapsuj4pyitq1";
			String consumerKey = "xii1nteagk3nwh35vbwzyozhb1q3bjzzscc1mgsg";
			String basicAuth = "DirectLogin username=\"" + username + "\",   password=\"" + pwd + "\",  consumer_key=\"" + consumerKey  + "\"";
			conn.setRequestProperty ("Authorization", basicAuth);
			System.out.println("basicAuth : " + basicAuth);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			StringBuilder sb = new StringBuilder();
			while ((output = br.readLine()) != null) {
				sb.append(output);
				System.out.println(output);
			}
			String myJSONString = sb.toString();
			System.out.println("myjsonStr " + myJSONString);
			JsonObject jobj = new Gson().fromJson(myJSONString, JsonObject.class);
			
			token = jobj.get("token").toString();
//			token = token.replaceAll("\"", "");
			System.out.println("token reçu lors du direct login : " + token);
			
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return token;
	}
	
	/**
	 * Effectue virement depuis compte du user appli vers le compte garant SG
	 * @param token reçu de l'appel de directLogin
	 * @param amount montant du virement à effectué (issu du challenge déclenché cf BDD)
	 * @return <code>true</code> si le virement a marché, <code>false</code> sinon
	 */
	private static boolean effectuerVirement(String token, float amount) {
		boolean success = false;
		try {
			
			String compteADebiter = "410ad4eb-9f63-300f-8cb9-12f0ab677521";	// user = 1000203892 
			String compteACrediter = "07a49ac2-6e4c-3dbf-afd5-04d8105ebf50"; // user = 1000203894 
			String banqueId1 = "00100";	//id de la banque de l'utilisateur à débiter
			String banqueId2 = "00100";	//id de la banque de l'utilisateur à créditer
//			String URL_OBP_VIREMENT = URL_ROOT + "/banks/" + banqueId1 + "/accounts/" + compteADebiter + "/owner/transaction-request-types/SANDBOX_TAN/transaction-requests";
			String URL_OBP_VIREMENT = "https://socgen-k-api.openbankproject.com/obp/v3.0.0/banks/00100/accounts/410ad4eb-9f63-300f-8cb9-12f0ab677521/owner/transaction-request-types/SANDBOX_TAN/transaction-requests";
			
			URL url = new URL(URL_OBP_VIREMENT);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "DirectLogin token=\"" + token  + "\"");
			conn.setDoOutput(true);
			String jsonValue = "{ \"to\":{    \"bank_id\":\"" + banqueId2 + "\",    \"account_id\":\""+ compteADebiter + "\"  },  \"value\":{    \"currency\":\"XAF\",    \"amount\":\"" + amount + "\"  },  \"description\":\"Good\"}";
			OutputStream outputStr = conn.getOutputStream();
			outputStr.write(jsonValue.getBytes("UTF-8"));
			
			if (conn.getResponseCode() != 201) {	// code http attendu = 201, sinon c ke le virement a fail
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
	
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	
			String output;
			System.out.println("Output from Server .... \n");
			StringBuilder sb = new StringBuilder();
			// affichage de la réponse de l'API en console pour vérifier si conforme au retour de l'API Explorer et Postman
			System.out.println("Retour de l'API : ");
			while ((output = br.readLine()) != null) {
				sb.append(output);
				System.out.println(output);
			}
			String myJSONString = sb.toString();
			
			success = true;
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}
	
}