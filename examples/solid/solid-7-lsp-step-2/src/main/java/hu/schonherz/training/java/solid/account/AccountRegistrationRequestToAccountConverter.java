package hu.schonherz.training.java.solid.account;

import org.apache.commons.lang3.Validate;

import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.cipher.CipherService;
import hu.schonherz.training.java.solid.cipher.EncryptionException;
import hu.schonherz.training.java.solid.converter.ConversionException;

public class AccountRegistrationRequestToAccountConverter {

  private CipherService cipherService;

  public AccountRegistrationRequestToAccountConverter(CipherService cipherService) {
    Validate.notNull(cipherService);
    this.cipherService = cipherService;
  }

  public Account convert(AccountRegistrationRequest source) throws ConversionException {
    try {
      Validate.notNull(source);

      Account account = new Account();
      account.setUsername(source.getUsername());
      account.setEmail(source.getEmail());
      String encryptedPassword = this.cipherService.encrypt(source.getPassword());
      account.setEncryptedPassword(encryptedPassword);
      return account;
    } catch (EncryptionException e) {
      throw new ConversionException("Could not convert account registration request to account", e);
    }
  }

}
