package fr.iutlannion.map;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class AdresseAPI {

    private static final String baseURL = "https://api-adresse.data.gouv.fr/search/";

    public static ArrayList<Adresse> getAdresses(String recherche) {
        ArrayList<Adresse> answers = new ArrayList<Adresse>();

        try {
            URIBuilder query = new URIBuilder(baseURL);
            query.addParameter("q", recherche);

            answers = getAdressesFromQuery(query.build().toURL());
        } catch (URISyntaxException e) {
            System.out.println("L'URL n'est pas syntaxiquement correcte.");
        } catch (MalformedURLException e) {
            System.out.println("URL malformée...");
        } catch (IOException e) {
            System.out.println("IOException");
        }

        return answers;
    }

    private static ArrayList<Adresse> getAdressesFromQuery(URL query) throws IOException {
        ArrayList<Adresse> answers = new ArrayList<Adresse>();

        HttpURLConnection connection = (HttpURLConnection) query.openConnection();

        // Send request
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String json = in.readLine();

        //String test = "{\"type\": \"FeatureCollection\", \"version\": \"draft\", \"features\": [{\"type\": \"Feature\", \"geometry\": {\"type\": \"Point\", \"coordinates\": [5.891743, 45.69767]}, \"properties\": {\"label\": \"8 Bd du Port aux Filles 73100 Aix-les-Bains\", \"score\": 0.8631675712555784, \"housenumber\": \"8\", \"id\": \"73008_1700_00008\", \"type\": \"housenumber\", \"x\": 924979.77, \"y\": 6515019.99, \"importance\": 0.49484328381136206, \"name\": \"8 Bd du Port aux Filles\", \"postcode\": \"73100\", \"citycode\": \"73008\", \"city\": \"Aix-les-Bains\", \"context\": \"73, Savoie, Auvergne-Rh\\u00f4ne-Alpes\", \"street\": \"Bd du Port aux Filles\"}}, {\"type\": \"Feature\", \"geometry\": {\"type\": \"Point\", \"coordinates\": [2.290084, 49.897443]}, \"properties\": {\"label\": \"8 Boulevard du Port 80000 Amiens\", \"score\": 0.4609014653088431, \"housenumber\": \"8\", \"id\": \"80021_6590_00008\", \"type\": \"housenumber\", \"x\": 648952.58, \"y\": 6977867.25, \"importance\": 0.5699161183972735, \"name\": \"8 Boulevard du Port\", \"postcode\": \"80000\", \"citycode\": \"80021\", \"city\": \"Amiens\", \"context\": \"80, Somme, Hauts-de-France\", \"street\": \"Boulevard du Port\"}}, {\"type\": \"Feature\", \"geometry\": {\"type\": \"Point\", \"coordinates\": [2.062794, 49.0317]}, \"properties\": {\"label\": \"8 Boulevard du Port 95000 Cergy\", \"score\": 0.457538199081032, \"housenumber\": \"8\", \"id\": \"95127_1448_00008\", \"type\": \"housenumber\", \"x\": 631466.41, \"y\": 6881718.82, \"importance\": 0.5329201898913519, \"name\": \"8 Boulevard du Port\", \"postcode\": \"95000\", \"citycode\": \"95127\", \"city\": \"Cergy\", \"context\": \"95, Val-d'Oise, \\u00cele-de-France\", \"street\": \"Boulevard du Port\"}}, {\"type\": \"Feature\", \"geometry\": {\"type\": \"Point\", \"coordinates\": [3.605884, 43.425225]}, \"properties\": {\"label\": \"8 Boulevard du Port 34140 M\\u00e8ze\", \"score\": 0.44976255796098435, \"housenumber\": \"8\", \"id\": \"34157_0770_00008\", \"type\": \"housenumber\", \"x\": 749085.29, \"y\": 6258645.39, \"importance\": 0.4473881375708283, \"name\": \"8 Boulevard du Port\", \"postcode\": \"34140\", \"citycode\": \"34157\", \"city\": \"M\\u00e8ze\", \"context\": \"34, H\\u00e9rault, Occitanie\", \"street\": \"Boulevard du Port\"}}, {\"type\": \"Feature\", \"geometry\": {\"type\": \"Point\", \"coordinates\": [-2.34098, 47.25881]}, \"properties\": {\"label\": \"8 Boulevard du Port 44380 Pornichet\", \"score\": 0.44941167894119716, \"housenumber\": \"8\", \"id\": \"44132_0141_00008\", \"type\": \"housenumber\", \"x\": 296410, \"y\": 6697932.5, \"importance\": 0.443528468353169, \"name\": \"8 Boulevard du Port\", \"postcode\": \"44380\", \"citycode\": \"44132\", \"city\": \"Pornichet\", \"context\": \"44, Loire-Atlantique, Pays de la Loire\", \"street\": \"Boulevard du Port\"}}], \"attribution\": \"BAN\", \"licence\": \"ETALAB-2.0\", \"query\": \"8 bd du port\\\"\", \"limit\": 5}";
        JSONObject obj = new JSONObject(json);

        JSONArray adresses = obj.getJSONArray("features");
        for (int i = 0; i < adresses.length(); i++) {
            JSONObject properties = adresses.getJSONObject(i).getJSONObject("properties");

            String numero = "", rue = "", ville = "", codePostal = "";

            if (properties.has("housenumber"))
                 numero = properties.getString("housenumber");

            if (properties.has("street"))
                rue = properties.getString("street");

            if (properties.has("city"))
                ville = properties.getString("city");

            if (properties.has("postcode"))
                codePostal = properties.getString("postcode");

            JSONArray geometry = adresses.getJSONObject(i).getJSONObject("geometry").getJSONArray("coordinates");
            double latitude = geometry.getDouble(0);
            double longitude = geometry.getDouble(1);
            LatLng coords = new LatLng(latitude, longitude);

            Adresse adresse = new Adresse(numero, rue, ville, codePostal);
            adresse.setCoords(coords);

            answers.add(adresse);

            System.out.println(adresse);
            System.out.println(coords);
        }

        return answers;
    }

}
