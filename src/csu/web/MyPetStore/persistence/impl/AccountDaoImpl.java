package csu.web.MyPetStore.persistence.impl;

import csu.web.MyPetStore.domain.Account;
import csu.web.MyPetStore.persistence.AccountDao;
import csu.web.MyPetStore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
    private static final String GET_ACCOUNT_BY_USERNAME="SELECT SIGNON.USERNAME,ACCOUNT.EMAIL,ACCOUNT.FIRSTNAME,ACCOUNT.LASTNAME,ACCOUNT.STATUS,ACCOUNT.ADDR1 AS address1,ACCOUNT.ADDR2 AS address2,ACCOUNT.CITY,ACCOUNT.STATE,ACCOUNT.ZIP,ACCOUNT.COUNTRY,ACCOUNT.PHONE,PROFILE.LANGPREF AS languagePreference,PROFILE.FAVCATEGORY AS favouriteCategoryId,PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption,BANNERDATA.BANNERNAME FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID = ? AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
    private static final String GET_ACCOUNT_BY_USERNAME_AND_PASSWORD="SELECT SIGNON.USERNAME,ACCOUNT.EMAIL,ACCOUNT.FIRSTNAME,ACCOUNT.LASTNAME,ACCOUNT.STATUS,ACCOUNT.ADDR1 AS address1,ACCOUNT.ADDR2 AS address2,ACCOUNT.CITY,ACCOUNT.STATE,ACCOUNT.ZIP,ACCOUNT.COUNTRY,ACCOUNT.PHONE,PROFILE.LANGPREF AS languagePreference,PROFILE.FAVCATEGORY AS favouriteCategoryId,PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption,BANNERDATA.BANNERNAME FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID = ? AND SIGNON.PASSWORD = ? AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
    private static final String UPDATE_ACCOUNT="UPDATE ACCOUNT SET EMAIL = ?,FIRSTNAME = ?,LASTNAME = ?,STATUS = ?,ADDR1 = ?,ADDR2 = ?,CITY = ?,STATE =?,ZIP = ?,COUNTRY = ?,PHONE = ? WHERE USERID = ?";
    private static final String INSERT_ACCOUNT="INSERT INTO ACCOUNT (EMAIL, FIRSTNAME, LASTNAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE, USERID) VALUES (?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_PROFILE="UPDATE PROFILE SET LANGPREF = ?,FAVCATEGORY = ? WHERE USERID = ?";
    private static final String INSERT_PAOFILE="INSERT INTO PROFILE (LANGPREF, FAVCATEGORY, USERID) VALUES (?, ?, ?)";
    private static final String UPDATE_SIGNON="UPDATE SIGNON SET PASSWORD = ? WHERE USERNAME = ?";
    private static final String INSERT_SIGNON="INSERT INTO SIGNON (PASSWORD,USERNAME) VALUES (?, ?)";
    @Override
    public Account getAccountByUsername(String username) {
        return null;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) {
        Account accountResult = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                accountResult = this.resultSetToAccount(resultSet);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return accountResult;
    }

    public Account resultSetToAccount(ResultSet resultSet) throws SQLException {
        Account account = new Account();
        account.setUsername(resultSet.getString("username"));
//        account.setPassword(resultSet.getString("password"));
        account.setEmail(resultSet.getString("email"));
        account.setFirstName(resultSet.getString("firstName"));
        account.setLastName(resultSet.getString("lastName"));
        account.setStatus(resultSet.getString("status"));
        account.setAddress1(resultSet.getString("address1"));
        account.setAddress2(resultSet.getString("address2"));
        account.setCity(resultSet.getString("city"));
        account.setState(resultSet.getString("state"));
        account.setZip(resultSet.getString("zip"));
        account.setCountry(resultSet.getString("country"));
        account.setPhone(resultSet.getString("phone"));
        account.setFavouriteCategoryId(resultSet.getString("favouriteCategoryId"));
        account.setLanguagePreference(resultSet.getString("languagePreference"));
        account.setListOption(resultSet.getInt("listOption") == 1);
        account.setBannerOption(resultSet.getInt("bannerOption") == 1);
        account.setBannerName(resultSet.getString("bannerName"));
        return account;
    }
    @Override
    public void insertAccount(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setString(1,account.getEmail());
            preparedStatement.setString(2,account.getFirstName());
            preparedStatement.setString(3,account.getLastName());
            preparedStatement.setString(4,account.getStatus());
            preparedStatement.setString(5,account.getAddress1());
            preparedStatement.setString(6,account.getAddress2());
            preparedStatement.setString(7,account.getCity());
            preparedStatement.setString(8,account.getState());
            preparedStatement.setString(9,account.getZip());
            preparedStatement.setString(10,account.getCountry());
            preparedStatement.setString(11,account.getPhone());
            preparedStatement.setString(12,account.getUsername());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertProfile(Account account) {

    }

    @Override
    public void insertSignon(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void updateProfile(Account account) {

    }

    @Override
    public void updateSignon(Account account) {

    }

}
