import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Dictionary {
    private Map<String, String> dictionary = new HashMap<>();

    public Dictionary() {
    }

    public Dictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public void addWord(String word, String translate) {
        if (word == null || translate == null) {
            throw new IllegalArgumentException("Incorrect data!");
        }
        dictionary.put(word, translate);
    }

    public String getTranslate(String word) {
        if (word == null) {
            throw new IllegalArgumentException();
        }
        return dictionary.get(word);
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dictionary that = (Dictionary) o;
        return Objects.equals(dictionary, that.dictionary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dictionary);
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "dictionary=" + dictionary +
                '}';
    }
}
