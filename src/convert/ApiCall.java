package convert;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class ApiCall {
    public double Convert(String from,String To) throws IOException, InterruptedException{
        URL obj = new URL("http://api.exchangeratesapi.io/v1/latest?access_key=9e82057a2a2de180379d711fe37b6859&format=1");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            try {
                JSONObject object = new JSONObject(response.toString());
                JSONObject rates_object = new JSONObject(object.getJSONObject("rates").toString());
                return rates_object.getDouble(To)/rates_object.getDouble(from);

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {
            System.out.println("GET request did not work.");
        }
        return 0;
    }
}
