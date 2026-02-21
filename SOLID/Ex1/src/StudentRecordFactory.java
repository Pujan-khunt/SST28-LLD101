import java.util.Map;

public class StudentRecordFactory {

    private final FakeDb db;

    StudentRecordFactory(FakeDb db) {
        this.db = db;
    }

    public StudentRecord createStudent(Map<String, String> parsedStudent) {
        String id = IdUtil.nextStudentId(db.count());

        String name = parsedStudent.getOrDefault("name", "");
        String email = parsedStudent.getOrDefault("email", "");
        String phone = parsedStudent.getOrDefault("phone", "");
        String program = parsedStudent.getOrDefault("program", "");

        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        db.save(rec);

        return rec;
    }
}
