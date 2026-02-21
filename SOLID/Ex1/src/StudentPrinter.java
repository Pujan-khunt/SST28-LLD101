public class StudentPrinter {

    private final FakeDb db;

    StudentPrinter(FakeDb db) {
        this.db = db;
    }

    public void printStudent(StudentRecord record) {
        System.out.println("OK: created student " + record.id);
        System.out.println("Saved. Total students: " + db.count());
        System.out.println("CONFIRMATION:");
        System.out.println(record);
    }
}
