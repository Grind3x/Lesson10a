import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Translator {
    private Dictionary dictionary;

    public Translator() {
    }

    public Translator(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void translate(File in, File out) {
        if (in == null || out == null) {
            throw new IllegalArgumentException();
        }
        String textString = fileToString(in).toString();
        List<String> words = new ArrayList<>(Arrays.asList(textString.split(" |, |\\. |: |! |\\? |\n")));
        String translatedWord;
        for (String word : words) {
            if ((translatedWord = dictionary.getTranslate(word.toLowerCase())) != null) {
                Character ch = word.charAt(0);
                if (Character.isUpperCase(ch)) {
                    textString = textString.replaceAll(word, translatedWord.substring(0, 1)
                            .toUpperCase() + translatedWord.substring(1));
                } else {
                    textString = textString.replaceAll(word, translatedWord);
                }
            }
        }
        stringToFile(textString, out);
    }

    private StringBuilder fileToString(File file) {
        if (file == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder();
        String s = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (; (s = br.readLine()) != null; ) {
                stringBuilder.append(s + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }

    private void stringToFile(String str, File file) {
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.print(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
}
