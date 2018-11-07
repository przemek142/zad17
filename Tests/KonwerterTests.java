
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KonwerterTests {

    // test konwertera miar
    @Test
    public void converterTest0() {

        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(null);
        przelicznikMiar.convert();
        assertThat(przelicznikMiar.isError(), is(true));
    }

    @Test
    public void converterTest1() {
        HashMap<String, String> map = new HashMap<>();
        map.put("milimetry", "0");


        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        Assert.assertEquals(BigDecimal.valueOf(0), przelicznikMiar.getMilimetry());
        Assert.assertEquals(BigDecimal.valueOf(0), przelicznikMiar.getMetry());
        Assert.assertEquals(BigDecimal.valueOf(0), przelicznikMiar.getCentymetry());
    }

    @Test
    public void converterTest2() {
        HashMap<String, String> map = new HashMap<>();


        map.put("centymetry", "-1");
        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        Assert.assertEquals(BigDecimal.valueOf(10), przelicznikMiar.getMilimetry());
        Assert.assertEquals(BigDecimal.valueOf(0.01), przelicznikMiar.getMetry());
        Assert.assertEquals(BigDecimal.valueOf(1), przelicznikMiar.getCentymetry());
    }


    @Test
    public void converterTest3() {
        HashMap<String, String> map = new HashMap<>();

        map.put("metry", "1");

        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        Assert.assertEquals(BigDecimal.valueOf(1000), przelicznikMiar.getMilimetry());
        Assert.assertEquals(BigDecimal.valueOf(1), przelicznikMiar.getMetry());
        Assert.assertEquals(BigDecimal.valueOf(100), przelicznikMiar.getCentymetry());
    }

    @Test
    public void converterTest4() {
        HashMap<String, String> map = new HashMap<>();
        map.put("milimetry", "0");
        map.put("metry", "1");
        map.put("centymetry", "-1");
        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        assertThat(przelicznikMiar.isError(), is(true));
    }

    @Test
    public void converterTest5() {
        HashMap<String, String> map = new HashMap<>();
        map.put("metry", "1");
        map.put("centymetry", "-1");
        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        assertThat(przelicznikMiar.isError(), is(true));
    }

    @Test
    public void converterTest6() {
        HashMap<String, String> map = new HashMap<>();
        map.put("milimetry", "0");
        map.put("centymetry", "-1");
        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        assertThat(przelicznikMiar.isError(), is(true));
    }

    @Test
    public void converterTest7() {
        HashMap<String, String> map = new HashMap<>();
        map.put("milimetry", "0");
        map.put("metry", "1");
        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        assertThat(przelicznikMiar.isError(), is(true));
    }

    @Test
    public void converterTest8() {
        HashMap<String, String> map = new HashMap<>();
        map.put("milimetry", "schabowy");
        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        assertThat(przelicznikMiar.isError(), is(true));
    }

    @Test
    public void converterTest9() {
        HashMap<String, String> map = new HashMap<>();
        map.put("miligramy", "0");

        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        Assert.assertEquals(BigDecimal.valueOf(0), przelicznikMiar.getMiligramy());
        Assert.assertEquals(BigDecimal.valueOf(0), przelicznikMiar.getGramy());
        Assert.assertEquals(BigDecimal.valueOf(0), przelicznikMiar.getKilogramy());
    }

    @Test
    public void converterTest10() {
        HashMap<String, String> map = new HashMap<>();
        map.put("gramy", "0");

        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        Assert.assertEquals(BigDecimal.valueOf(0), przelicznikMiar.getMiligramy());
        Assert.assertEquals(BigDecimal.valueOf(0), przelicznikMiar.getGramy());
        Assert.assertEquals(BigDecimal.valueOf(0), przelicznikMiar.getKilogramy());
    }

    @Test
    public void converterTest11() {
        HashMap<String, String> map = new HashMap<>();
        map.put("kilogramy", "0");

        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        Assert.assertEquals(BigDecimal.valueOf(0), przelicznikMiar.getMiligramy());
        Assert.assertEquals(BigDecimal.valueOf(0), przelicznikMiar.getGramy());
        Assert.assertEquals(BigDecimal.valueOf(0), przelicznikMiar.getKilogramy());
    }

    @Test
    public void converterTest12() {
        HashMap<String, String> map = new HashMap<>();
        map.put("kilogramy", "01");

        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        Assert.assertEquals(BigDecimal.valueOf(1000000), przelicznikMiar.getMiligramy());
        Assert.assertEquals(BigDecimal.valueOf(1000), przelicznikMiar.getGramy());
        Assert.assertEquals(BigDecimal.valueOf(1), przelicznikMiar.getKilogramy());
    }

    @Test
    public void converterTest13() {
        HashMap<String, String> map = new HashMap<>();
        map.put("gramy", "0001000");

        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        Assert.assertEquals(BigDecimal.valueOf(1000000), przelicznikMiar.getMiligramy());
        Assert.assertEquals(BigDecimal.valueOf(1000), przelicznikMiar.getGramy());
        Assert.assertEquals(BigDecimal.valueOf(1), przelicznikMiar.getKilogramy());
    }

    @Test
    public void converterTest14() {
        HashMap<String, String> map = new HashMap<>();
        map.put("miligramy", "1000000");

        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(map);
        przelicznikMiar.convert();
        Assert.assertEquals(BigDecimal.valueOf(1000000), przelicznikMiar.getMiligramy());
        Assert.assertEquals(BigDecimal.valueOf(1000), przelicznikMiar.getGramy());
        Assert.assertEquals(BigDecimal.valueOf(1), przelicznikMiar.getKilogramy());
    }
    @Test
    public void textTest0() {
        PrzelicznikTekstu przelicznikTekstu = new PrzelicznikTekstu(null);
        przelicznikTekstu.makeStats();
        assertThat(przelicznikTekstu.isError(), is(true));


    }



    @Test
    public void textTest1() {
        String text = "  dsfsd  sdfr ";
        PrzelicznikTekstu przelicznikTekstu = new PrzelicznikTekstu(text);
        przelicznikTekstu.makeStats();

        Assert.assertThat(przelicznikTekstu.getNumberOfWords(), CoreMatchers.is(2));
        Assert.assertThat(przelicznikTekstu.getNumberOfChars(), CoreMatchers.is(14));
        Assert.assertThat(przelicznikTekstu.getNumberOfCharsNoSpaces(), CoreMatchers.is(9));
        Assert.assertThat(przelicznikTekstu.isPalindrom(), CoreMatchers.is(false));
    }
    @Test
    public void textTest2() {
        String text = "";
        PrzelicznikTekstu przelicznikTekstu = new PrzelicznikTekstu(text);
        przelicznikTekstu.makeStats();

        Assert.assertThat(przelicznikTekstu.getNumberOfWords(), CoreMatchers.is(0));
        Assert.assertThat(przelicznikTekstu.getNumberOfChars(), CoreMatchers.is(0));
        Assert.assertThat(przelicznikTekstu.getNumberOfCharsNoSpaces(), CoreMatchers.is(0));
        Assert.assertThat(przelicznikTekstu.isPalindrom(), CoreMatchers.is(false));
    }
    @Test
    public void textTest3() {
        String text = "   A to    kan?apa pa .!na Kota.";
        PrzelicznikTekstu przelicznikTekstu = new PrzelicznikTekstu(text);
        przelicznikTekstu.makeStats();

        Assert.assertThat(przelicznikTekstu.getNumberOfWords(), CoreMatchers.is(6));
        Assert.assertThat(przelicznikTekstu.getNumberOfChars(), CoreMatchers.is(32));
        Assert.assertThat(przelicznikTekstu.getNumberOfCharsNoSpaces(), CoreMatchers.is(21));
        Assert.assertThat(przelicznikTekstu.isPalindrom(), CoreMatchers.is(true));
    }
}
