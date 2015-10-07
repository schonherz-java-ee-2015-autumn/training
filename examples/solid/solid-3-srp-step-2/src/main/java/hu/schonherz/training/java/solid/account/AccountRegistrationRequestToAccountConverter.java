package hu.schonherz.training.java.solid.account;

import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.cipher.CipherService;

public class AccountRegistrationRequestToAccountConverter {

  private CipherService cipherService;

  public AccountRegistrationRequestToAccountConverter(CipherService cipherService) {
    this.cipherService = cipherService;
  }

  public Account convert(AccountRegistrationRequest source) {
    Account account = new Account();
    account.setUsername(source.getUsername());
    account.setEmail(source.getEmail());
    String encryptedPassword = this.cipherService.encrypt(source.getPassword());
    account.setEncryptedPassword(encryptedPassword);
    return account;
  }

}
