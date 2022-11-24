package pl.konsultacje.child;

public class NoFoundUser extends RuntimeException {
    public NoFoundUser(String message) {
        super(message);
    }
}
