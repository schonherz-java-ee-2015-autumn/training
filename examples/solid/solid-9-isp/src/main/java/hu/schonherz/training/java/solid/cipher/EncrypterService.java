package hu.schonherz.training.java.solid.cipher;

public interface EncrypterService {
  String encrypt(String unencrypted) throws EncryptionException;
}
