@FunctionalInterface
interface EligibilityRule {

    boolean isEligible(String studentId, String courseId)
            throws EnrollmentDeniedException;
}

class EnrollmentDeniedException extends Exception {

    public EnrollmentDeniedException(String message) {
        super(message);
    }
}