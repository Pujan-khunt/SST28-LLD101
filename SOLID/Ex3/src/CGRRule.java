public class CGRRule extends Rule {

    public CGRRule(String reason, StudentProfile profile) {
        super(reason, profile);
    }

    @Override
    boolean check() {
        return profile.cgr >= 8.0;
    }

}
