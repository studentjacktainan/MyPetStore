package csu.web.MyPetStore.service;

import csu.web.MyPetStore.domain.Account;
import csu.web.MyPetStore.persistence.AccountDao;
import csu.web.MyPetStore.persistence.impl.AccountDaoImpl;

public class AccountService {
    private AccountDao accountDao;
    public AccountService(){
        this.accountDao=new AccountDaoImpl();
    }
    public Account getAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return accountDao.getAccountByUsernameAndPassword(account);
    }
}
