import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentValidator {
    public List<String> validate(Map<String, String> parsedStudent) {
        List<String> errors = new ArrayList<>();
        
        String name = parsedStudent.getOrDefault("name", "");
        String email = parsedStudent.getOrDefault("email", "");
        String phone = parsedStudent.getOrDefault("phone", "");
        String program = parsedStudent.getOrDefault("program", "");

        // validation inline, printing inline
        if (name.isBlank()) errors.add("name is required");
        if (email.isBlank() || !email.contains("@")) errors.add("email is invalid");
        if (phone.isBlank() || !phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(program.equals("CSE") || program.equals("AI") || program.equals("SWE"))) errors.add("program is invalid");
        
        return errors;
    }
}
