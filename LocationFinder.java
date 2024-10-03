import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class LocationFinder {
    public static void main(String[] args){
        try {
            String ipAddress = "8.8.8.8"; //replace with the IP address you want to check
            URL url = new URL("https://api.ipgeolocation.io/ipgeo?apikey=YOUR_API_KEY&ip=" + ipAddress);
            // Replace "YOUR_API_KEY" with your actual API key obtained from a service like IPGeolocation (https://ipgeolocation.io).
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "Application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null){
                System.out.println(output);
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}