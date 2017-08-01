package com.a.quarter.model.bean;

/**
 * desc：
 * Created by wd on 2017/7/28.
 * thinking：
 */

public class LoginDataBean {


    /**
     * code : 200
     * user : {"userId":94,"userName":"齐泽普","userPassword":"666666","userPhone":"18931185475","userSex":"男"}
     */

    private String code;
    private UserBean user;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * userId : 94
         * userName : 齐泽普
         * userPassword : 666666
         * userPhone : 18931185475
         * userSex : 男
         */

        private int userId;
        private String userName;
        private String userPassword;
        private String userPhone;
        private String userSex;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getUserSex() {
            return userSex;
        }

        public void setUserSex(String userSex) {
            this.userSex = userSex;
        }
    }
}
