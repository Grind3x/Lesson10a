import java.io.File;

public class Main {
    public static void main(String[] args) {
        File in = new File("English.in");
        File out = new File("Ukrainian.out");

        Dictionary dictionary = new Dictionary();
        dictionary.addWord("name", "ім'я");
        dictionary.addWord("my", "моє");
        dictionary.addWord("vitaliy", "віталій");

        Translator translator = new Translator(dictionary);
        translator.translate(in, out);
    }
}
