
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;


public class KonwerterWalut {
    private boolean errorGettingData = false;
    String USD = "brak";
    Set rates;

    public void getData() {

        try {

            String data = IOUtils.toString(new URL("http://data.fixer.io/api/latest?access_key=ce5a3626a3293b9533479c202d8c252f"), "UTF-8");
            Object o = new JSONParser().parse(data);
            JSONObject jo = (JSONObject) o;
            JSONObject rates = (JSONObject) jo.get("rates");
            USD = rates.get("USD").toString();


        } catch (IOException e) {
            errorGettingData = true;
            System.out.println("IO");
        } catch (ParseException f) {
            System.out.println("parse");
        }


        System.out.println(USD);
        System.out.println(errorGettingData);
    }

}

