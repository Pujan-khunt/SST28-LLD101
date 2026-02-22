public class EarnedCreditsRule extends Rule {

    public EarnedCreditsRule(String reason, StudentProfile profile) {
        super(reason, profile);
    }

    @Override
    boolean check() {
        return profile.earnedCredits >= 20;
    }

}
