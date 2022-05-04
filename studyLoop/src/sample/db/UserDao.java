package sample.db;

import sample.model.User;

import java.sql.*;

public class UserDao {


    private static Statement stmt;
    private static ResultSet rs;
    private static DBUtil db = new DBUtil();

    public int getUserCount() {

        String query = "select count(*) from users";

        Connection con = null;
        int count = 0;
        try {


            // opening database connection to MySQL server
            con = db.getConnection();

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                count = rs.getInt(1);
                System.out.println("Total number of books in the table : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return count;
    }

    public boolean isLoginGranted(String login, String pass) {

        return true;
    }

    public static boolean insNewUser(User user) {
//        private String name;
//        private String phoneNumber;
//        private String mail;
//        private String country;
//        private String password;
//        private String gender;
//        private String dateOfBirth;

        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_NAME + "," + Const.USERS_PHONENUMBER + "," + Const.USERS_MAIL + "," + Const.USERS_COUNTRY + "," + Const.USERS_PASSWORD + "," + Const.USERS_GENDER + "," + Const.USERS_BIRTHDATE + ")" + "VALUES('" + user.getName() + "'," + "'" + user.getPassword() + "'," + "'" + user.getMail() + "'," + "'" + user.getCountry() + "'," + "'" + user.getPassword() + "'," + "'" + user.getGender() + "'," + "'" + user.getDateOfBirth() + "')";
        System.out.println(insert);

        Connection con = null;
        int count = 0;
        try {
            // opening database connection to MySQL server
            con = db.getConnection();
            PreparedStatement prSt = con.prepareStatement(insert);
            prSt.executeUpdate();
            return true;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return false;
        } finally {
            //close connection ,stmt and resultset here
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException se) { /*can't do anything */ }

            }
        }

    }

    public static Boolean getUser(User user) {
        Boolean ret = false;

        String select = "select exists( SELECT * FROM `users` WHERE " + Const.USERS_PHONENUMBER + "=? AND " + Const.USERS_PASSWORD + "=? ) ex";

        Connection con = null;
        int count = 0;
        ResultSet resSet = null;
        try {
            con = db.getConnection();

            PreparedStatement prSt = con.prepareStatement(select);
            prSt.setString(1, user.getPassword());
            prSt.setString(2, user.getPhoneNumber());

            resSet = prSt.executeQuery();

            while (resSet.next()) {

                ret = resSet.getBoolean(1);
                System.out.println(ret);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            if (con != null) {
                try {
                    con.close();
                    resSet.close();
                } catch (SQLException se) { /*can't do anything */ }
            }
        }
        return ret;

    }
}
