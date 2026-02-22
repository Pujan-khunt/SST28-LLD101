public class DisciplinaryRule extends Rule {

    public DisciplinaryRule(String reason, StudentProfile profile) {
        super(reason, profile);
    }

    @Override
    boolean check() {
        return profile.disciplinaryFlag == LegacyFlags.NONE;
    }

}
