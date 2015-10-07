package hu.schonherz.training.java.solid.cipher;

public class DecryptionException extends CipherException {

  public DecryptionException(String message) {
    super(message);
  }

  public DecryptionException(Throwable cause) {
    super(cause);
  }

  public DecryptionException(String message, Throwable cause) {
    super(message, cause);
  }

}
