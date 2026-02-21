public class DefaultPrinter implements StudentPrinter {

    private final FakeDb db;

    DefaultPrinter(FakeDb db) {
        this.db = db;
    }

    @Override
    public void print(StudentRecord record) {
        System.out.println("OK: created student " + record.id);
        System.out.println("Saved. Total students: " + db.count());
        System.out.println("CONFIRMATION:");
        System.out.println(record);
    }
}
