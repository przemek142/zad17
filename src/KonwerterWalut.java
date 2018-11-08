import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Set;


public class KonwerterWalut {
    private boolean errorGettingData = false;
    private Set fixerKeys, ratesKeys;
    private HashMap<String, BigDecimal> ratesData = new HashMap<>();
    private HashMap<String, String> fixerData = new HashMap<>();
    private String date = "latest";

    public KonwerterWalut(String date) {
        this.date = date;
        getData();
    }

    public KonwerterWalut(LocalDateTime date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = date.format(dateTimeFormatter);
        getData();
    }

    public KonwerterWalut() {
        getData();
    }

    public Set getFixerKeys() {
        return fixerKeys;
    }

    public Set getRatesKeys() {
        return ratesKeys;
    }


    public void getData() {

        try {
//            http://data.fixer.io/api/2013-12-24?access_key=ce5a3626a3293b9533479c202d8c252f
            URL url = new URL("http://data.fixer.io/api/" + date + "?access_key=ce5a3626a3293b9533479c202d8c252f");
            System.out.println(url.toString());
//            String data = IOUtils.toString(new URL("http://data.fixer.io/api/latest?access_key=ce5a3626a3293b9533479c202d8c252f"), "UTF-8");
            String data = IOUtils.toString(url, "UTF-8");

            JSONObject siteData = (JSONObject) new JSONParser().parse(data);
            fixerKeys = siteData.keySet();

            if (siteData.get("success").toString().compareTo("true") != 0)
                errorGettingData = true;

            for (Object fixer_key : fixerKeys) {
                if (fixer_key.toString().compareTo("rates") != 0)
                    fixerData.put(fixer_key.toString(), siteData.get(fixer_key).toString());
            }


            JSONObject rates = (JSONObject) siteData.get("rates");

            if (rates.isEmpty())
                errorGettingData = true;

            ratesKeys = rates.keySet();

            for (Object ratesKey : ratesKeys) {
                ratesData.put(ratesKey.toString(), (new BigDecimal(rates.get(ratesKey).toString())));
            }

            if (ratesData.isEmpty())
                errorGettingData = true;

        } catch (IOException e) {
            errorGettingData = true;
            System.out.println("IO");
        } catch (ParseException f) {
            errorGettingData = true;
            System.out.println("parse");
        } catch (NullPointerException np) {
            errorGettingData = true;
            System.out.println("null pointer");
        }
        System.out.println("getData failed: " + errorGettingData);
    }

    public String calculate(String inputString, String outputCurrencyString) {
        boolean error = false;
        BigDecimal input = BigDecimal.valueOf(-1);
        try {
            input = new BigDecimal(inputString);
        } catch (Exception e) {
            error = true;
        }

        String output = "---";

        if (!errorGettingData && !error) {
            BigDecimal outpuCurrencyIndex = ratesData.get(outputCurrencyString);
            BigDecimal PLN = ratesData.get("PLN");
            BigDecimal currencyPairRatio = outpuCurrencyIndex.divide(PLN,8, RoundingMode.HALF_UP);
            output=input.multiply(currencyPairRatio).setScale(4,RoundingMode.HALF_UP ).toString();

        }


        return output;
    }

}

