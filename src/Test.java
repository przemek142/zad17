import java.math.BigDecimal;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
//        map.put("milimetry", "");
//        map.put("metry", "");
        map.put("centymetry", "1");

        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);

        System.out.println("a " + przelicznikMiar);

        przelicznikMiar.convert();

        System.out.println("c " + przelicznikMiar);
    }
}
