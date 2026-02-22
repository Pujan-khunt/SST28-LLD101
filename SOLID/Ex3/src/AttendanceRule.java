public class AttendanceRule extends Rule {

    public AttendanceRule(String reason, StudentProfile profile) {
        super(reason, profile);
    }

    @Override
    boolean check() {
        return profile.attendancePct >= RuleInput.minAttendance;
    }

}
