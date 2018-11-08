import java.math.BigDecimal;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {

        KonwerterWalut konwerterWalut = new KonwerterWalut();
        System.out.println(konwerterWalut.calculate("4.294124","EUR"));
    }
}
