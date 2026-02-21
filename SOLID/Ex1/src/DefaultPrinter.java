public class DefaultPrinter implements StudentPrinter {

    private final DatabaseService db;

    DefaultPrinter(DatabaseService db) {
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
