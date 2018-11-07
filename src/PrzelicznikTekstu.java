import java.util.Arrays;

public class PrzelicznikTekstu {
    private String text;
    private int numberOfWords = 0;
    private int numberOfChars = 0;
    private int numberOfCharsNoSpaces = 0;
    private boolean palindrom = false;
    private boolean error = false;

    public int getNumberOfCharsNoSpaces() {
        return numberOfCharsNoSpaces;
    }

    public boolean isError() {
        return error;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public int getNumberOfChars() {
        return numberOfChars;
    }


    public boolean isPalindrom() {
        return palindrom;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PrzelicznikTekstu(String text) {
        if (text == null) {
            this.text = "";
            error=true;
        } else {
            this.text = text;
        }
    }

    private boolean isPalindrom(String text, int wordCount) {
        char[] textChars = text.toLowerCase().replaceAll("[?|.|\\s+|!|,|'|`|\"|–|:]", "").toCharArray();
        if (wordCount < 2)
            return false;

        for (int i = 0; i < textChars.length; i++) {
            if (textChars[i] != textChars[textChars.length - (1 + i)])
                return false;
        }
        return true;
    }

    public String makeStats() {
        String output = "";
        String[] words = {};


        if (text == null || text.isEmpty()) {
            output = "<h2>Brak tekstu</h2>";

        } else
            words = text.trim().strip().split("\\s+");
        numberOfWords = words.length;
        numberOfChars = text.length();
        numberOfCharsNoSpaces = text.replace(" ", "").length();
        palindrom = isPalindrom(text, words.length);
        output = String.format("%s<br><br><h3>Ilość słów: %d<br>Ilość znaków: %d<br>Ilość znaków (bez spacji): %d<br>Palindrom: %s</h3>",
                text,
                numberOfWords,
                numberOfChars,
                numberOfCharsNoSpaces,
                palindrom);

        return output;
    }
}
