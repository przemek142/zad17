import java.math.BigDecimal;
import java.util.HashMap;

public class PrzelicznikMiar {
    private HashMap<String, String> data;
    private String type;
    private BigDecimal metry = BigDecimal.valueOf(-1);
    private BigDecimal milimetry = BigDecimal.valueOf(-1);
    private BigDecimal centymetry = BigDecimal.valueOf(-1);
    private BigDecimal miligramy = BigDecimal.valueOf(-1);
    private BigDecimal gramy = BigDecimal.valueOf(-1);
    private BigDecimal kilogramy = BigDecimal.valueOf(-1);
    private boolean error = false;

    @Override
    public String toString() {
        return String.format("mm: %s, cm: %s, m: %s", milimetry.toString(), centymetry.toString(), metry.toString());
    }

    public BigDecimal getMiligramy() {
        return miligramy;
    }

    public BigDecimal getGramy() {
        return gramy;
    }

    public BigDecimal getKilogramy() {
        return kilogramy;
    }

    public boolean isError() {
        return error;
    }

    public BigDecimal getMetry() {
        return metry;
    }

    public BigDecimal getMilimetry() {
        return milimetry;
    }

    public BigDecimal getCentymetry() {
        return centymetry;
    }

    public String convert() {
        String output = "";
        int numberOfKeys = 0;
        boolean convertionError = false;
        String type = "";
        BigDecimal value = BigDecimal.valueOf(0);

        if (data == null)
            numberOfKeys = 2;
        else {
            for (String key : data.keySet()) {
                numberOfKeys += 1;
            }
        }
        if (numberOfKeys == 1) {
            for (String key : data.keySet()) {
                type = key;
                try {
                    value = new BigDecimal(data.get(key).replace(",", ".")).abs();
                } catch (NumberFormatException e) {
                    error = true;
                    convertionError = true;
                }
            }
        }

        if (data == null || data.isEmpty() || numberOfKeys > 1 || convertionError) {
            output = "<h2>Błędne dane lub za dużo danych</h2>";
            error = true;
        } else {
            output += "<h2>Podana wartość w przeliczeniu na:</h2>";
            switch (type) {
                case "milimetry":
                    milimetry = value;
                    centymetry = value.divide(BigDecimal.valueOf(10));
                    metry = value.divide(BigDecimal.valueOf(1000));
                    output += String.format(
                            "<p>milimetry = %smm </p><p>centymetry = %scm</p><p>metry = %sm</p>",
                            milimetry.toString(),
                            centymetry.toString(),
                            metry.toString());
                    break;
                case "metry":
                    milimetry = value.multiply(BigDecimal.valueOf(1000));
                    centymetry = value.multiply(BigDecimal.valueOf(100));
                    metry = value;
                    output += String.format(
                            "<p>milimetry = %smm </p><p>centymetry = %scm</p><p>metry = %sm</p>",
                            milimetry.toString(),
                            centymetry.toString(),
                            metry.toString());
                    break;
                case "centymetry":
                    milimetry = value.multiply(BigDecimal.valueOf(10));
                    centymetry = value;
                    metry = value.divide(BigDecimal.valueOf(100));
                    output += String.format(
                            "<p>milimetry = %smm </p><p>centymetry = %scm</p><p>metry = %sm</p>",
                            milimetry.toString(),
                            centymetry.toString(),
                            metry.toString());
                    break;
                case "miligramy":
                    miligramy = value;
                    gramy = value.divide(BigDecimal.valueOf(1000));
                    kilogramy = value.divide(BigDecimal.valueOf(1000000));
                    output += String.format(
                            "<p>miligramy = %smg</p><p>gramy = %sg</p><p>kilogramy = %skg</p>",
                            miligramy.toString(),
                            gramy.toString(),
                            kilogramy.toString());
                    break;
                case "gramy":
                    miligramy = value.multiply(BigDecimal.valueOf(1000));
                    gramy = value;
                    kilogramy = value.divide(BigDecimal.valueOf(1000));
                    output += String.format(
                            "<p>miligramy = %smg</p><p>gramy = %sg</p><p>kilogramy = %skg</p>",
                            miligramy.toString(),
                            gramy.toString(),
                            kilogramy.toString());
                    break;
                case "kilogramy":
                    miligramy = value.multiply(BigDecimal.valueOf(1000000));
                    gramy = value.multiply(BigDecimal.valueOf(1000));
                    kilogramy = value;
                    output += String.format(
                            "<p>miligramy = %smg</p><p>gramy = %sg</p><p>kilogramy = %skg</p>",
                            miligramy.toString(),
                            gramy.toString(),
                            kilogramy.toString());
                    break;
            }

        }
        return output;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, String> getData() {
        return data;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }

    public PrzelicznikMiar(HashMap<String, String> data) {
        this.data = data;
    }
}
