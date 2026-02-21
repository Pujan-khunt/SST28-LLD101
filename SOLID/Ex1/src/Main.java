public class Main {

    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        FakeDb db = new FakeDb();
        StudentParser parser = new StudentParser();
        StudentValidator validator = new StudentValidator();
        OnboardingService svc = new OnboardingService(db, parser, validator);

        String raw =
            "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}
