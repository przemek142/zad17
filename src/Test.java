import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import java.util.regex.Matcher;

import java.util.regex.Pattern;


public class Test {
    public static void main(String[] args) {
        Pattern patternDate = Pattern.compile("^[1|2][0|9][0|1|9][0-9]-[0|1][0-9]-[0|1|2|3][0-9]$");


        String input = "1018-13-39";
        Matcher matcher = patternDate.matcher(input);

        System.out.println(matcher.matches());
    }
}
