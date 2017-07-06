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
	public static final String URL_OBP_DIRECT_LOGIN = URL_ROOT + "/my/logins/direct";	// endpoint direct login de l'API OBP
	/** Compte qui représente un compte unique SG sur lequel sont versés tous les montants manipulés par l'appli */
	public static final String COMPTE_A_CREDITER = "07a49ac2-6e4c-3dbf-afd5-04d8105ebf50"; // user OBP = 1000203894 
	
	/**
	 * testing only
	 */
	public static void main(String[] args) {
		String token = directLogin();
		System.out.println("token received : " + token);
		// juste pour les tests, dans l'appel nominal on récupère ce compte dans la bdd
		String compteADebiter = "410ad4eb-9f63-300f-8cb9-12f0ab677521";	// user = 1000203892 
		boolean success = effectuerVirement(Float.parseFloat("10.15"), compteADebiter, COMPTE_A_CREDITER );
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
	 * Effectue virement d'un compte à un autre : 
	 * 		-	user valide un challenge monétisé : depuis cpt user vers compte SG
	 * 		-	monétisation de la cagnotte de l'objectif : depuis le cpt SG vers le cpt associé à l'objectif  
	 * @param amount montant du virement à effectuer 
	 * @param compteADebiter le compte d'où sera prélevé l'argent
	 * @param compteADebiter le compte sur lequel sera versé l'argent
	 * @return <code>true</code> si le virement a marché, <code>false</code> sinon
	 */
	public static boolean effectuerVirement(float amount, String compteADebiter, String compteACrediter) {
		boolean success = false;
		try {
			String token = directLogin();
			
			String banqueId = "00100";	//id de la banque (virements internes, toujours la même banque)
			//url :	https://socgen-k-api.openbankproject.com/obp/v3.0.0/banks/00100/accounts/410ad4eb-9f63-300f-8cb9-12f0ab677521/owner/transaction-request-types/SANDBOX_TAN/transaction-requests";
			String URL_OBP_VIREMENT = URL_ROOT + "/obp/v3.0.0/banks/" + banqueId + "/accounts/" + compteADebiter + "/owner/transaction-request-types/SANDBOX_TAN/transaction-requests";
			
			URL url = new URL(URL_OBP_VIREMENT);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "DirectLogin token=\"" + token  + "\"");
			conn.setDoOutput(true);
			
			//json body :  {  "to":{    "bank_id":"00100",    "account_id":"07a49ac2-6e4c-3dbf-afd5-04d8105ebf50"  },  "value":{    "currency":"XAF",    "amount":"10"  },  "description":"Good"}
			String jsonValue = "{ \"to\":{    \"bank_id\":\"" + banqueId + "\",    \"account_id\":\""+ COMPTE_A_CREDITER + "\"  },  \"value\":{    \"currency\":\"XAF\",    \"amount\":\"" + amount + "\"  },  \"description\":\"Good\"}";
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