package hu.schonherz.training.java.solid.account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import hu.schonherz.training.java.solid.account.model.Account;

public class AccountService {

  private SecretKeySpec secretKey;
  private IvParameterSpec iv;
  private String dbFile;

  public AccountService(String keyString, String ivString, String dbFile) {
    byte[] encodedKey = Base64.decodeBase64(keyString);
    this.secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");

    byte[] encodedIv = Base64.decodeBase64(ivString);
    this.iv = new IvParameterSpec(encodedIv);

    this.dbFile = dbFile;
  }

  public AccountRegistrationResponse register(AccountRegistrationRequest request) {
    if (request == null) {
      throw new IllegalArgumentException("Registration request cannot be null");
    }

    List<String> validationErrors = validateRequest(request);

    if (validationErrors.size() > 0) {
      return new AccountRegistrationResponse(validationErrors, null);
    }

    Account account = createAccount(request);
    saveToDatabase(account);

    return new AccountRegistrationResponse(null, account);
  }

  private void saveToDatabase(Account account) {
    try (FileWriter writer = new FileWriter(this.dbFile, true)) {
      writer.append(account.getUsername()).append(',').append(account.getEmail()).append(',')
          .append(account.getEncryptedPassword()).append('\n');
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private Account createAccount(AccountRegistrationRequest request) {
    Account account = new Account();
    account.setUsername(request.getUsername());
    account.setEmail(request.getEmail());
    String encryptedPassword = encryptPassword(request.getPassword());
    account.setEncryptedPassword(encryptedPassword);
    return account;
  }

  private List<String> validateRequest(AccountRegistrationRequest request) {
    List<String> validationErrors = new LinkedList<>();
    if (request.getUsername() == null || request.getUsername().trim().length() == 0) {
      validationErrors.add("Username must be entered");
    }

    if (request.getPassword() == null || request.getPassword().trim().length() == 0) {
      validationErrors.add("Password must be entered");
    }

    if (request.getPasswordConfirmation() == null
        || request.getPasswordConfirmation().trim().length() == 0) {
      validationErrors.add("Password confirmation must be entered");
    }

    if (request.getPassword() != null
        && !request.getPassword().equals(request.getPasswordConfirmation())) {
      validationErrors.add("Password confirmation must match the password entered");
    }

    if (request.getEmail() == null || request.getEmail().trim().length() == 0) {
      validationErrors.add("Email address must be entered");
    }

    if (request.getEmail() != null
        && !request
            .getEmail()
            .trim()
            .matches(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
      validationErrors.add("A valid email address must be entered");
    }
    return validationErrors;
  }

  private String encryptPassword(String password) {
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, this.secretKey, iv);

      byte[] passwordBytes = password.getBytes();

      byte[] encryptedPasswordRaw = cipher.doFinal(passwordBytes);

      return Base64.encodeBase64String(encryptedPasswordRaw);
    } catch (Exception e) {
      return null;
    }
  }
}
