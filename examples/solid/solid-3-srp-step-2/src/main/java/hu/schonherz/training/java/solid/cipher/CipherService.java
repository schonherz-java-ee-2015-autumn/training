package hu.schonherz.training.java.solid.cipher;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class CipherService {
  private SecretKeySpec secretKey;
  private IvParameterSpec iv;

  public CipherService(String keyString, String ivString) {
    byte[] encodedKey = Base64.decodeBase64(keyString);
    this.secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");

    byte[] encodedIv = Base64.decodeBase64(ivString);
    this.iv = new IvParameterSpec(encodedIv);
  }

  public String encrypt(String unencrypted) {
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, this.secretKey, this.iv);

      byte[] bytes = unencrypted.getBytes();

      byte[] raw = cipher.doFinal(bytes);

      return Base64.encodeBase64String(raw);
    } catch (Exception e) {
      return null;
    }
  }
}
