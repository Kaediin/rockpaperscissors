package interfaces;

/**
 * This interface abstracts user's input, allowing for easier testing (and possible future changes to input methods).
 */
public interface UserInputInterface {
    String nextLine();
    int nextInt();
}
