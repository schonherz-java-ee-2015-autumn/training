package hu.schonherz.training.java.solid.cipher;

public interface DecrypterService {
  String decrypt(String encrypted) throws DecryptionException;
}
