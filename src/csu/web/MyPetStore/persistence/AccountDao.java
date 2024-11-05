package csu.web.MyPetStore.persistence;

import csu.web.MyPetStore.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AccountDao {

    Account getAccountByUsername(String username);

    Account getAccountByUsernameAndPassword(Account account);
    Account resultSetToAccount(ResultSet resultSet) throws SQLException;
    void insertAccount(Account account);

    void insertProfile(Account account);

    void insertSignon(Account account);

    void updateAccount(Account account);

    void updateProfile(Account account);

    void updateSignon(Account account);

}