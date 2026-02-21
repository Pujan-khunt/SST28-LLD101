import java.util.LinkedHashMap;
import java.util.Map;

public class StudentParser {

    private static final String STUDENT_KEY_VALUE_DELIMITER = "=";
    public static final String STUDENT_DELIMITER = ";";

    // Confused whether should I make this method static or not?
    // Since only a single parser is required to parse students
    // We can either make this class singleton or use the static keyword
    public Map<String, String> parse(String rawStudent) {
        Map<String, String> parsedStudent = new LinkedHashMap<>();
        String[] parts = rawStudent.split(STUDENT_DELIMITER);
        for (String p : parts) {
            String[] t = p.split(STUDENT_KEY_VALUE_DELIMITER);
            if (t.length == 2) {
                parsedStudent.put(t[0].trim(), t[1].trim());
            }
        }
        return parsedStudent;
    }
}
