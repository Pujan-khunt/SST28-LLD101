import java.util.*;

public class OnboardingService {

    private final FakeDb db;
    private final StudentParser parser;
    private final StudentValidator validator;

    public OnboardingService(
        FakeDb db,
        StudentParser parser,
        StudentValidator validator
    ) {
        this.db = db;
        this.parser = parser;
        this.validator = validator;
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        Map<String, String> kv = parser.parse(raw);
        List<String> errors = validator.validate(kv);

        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        db.save(rec);

        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + db.count());
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
