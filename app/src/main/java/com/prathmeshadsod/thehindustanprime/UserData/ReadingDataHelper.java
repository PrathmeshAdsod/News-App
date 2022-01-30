package com.prathmeshadsod.thehindustanprime.UserData;

public class ReadingDataHelper {
    String user_name;
    String user_email;

    // Empty constructor needed while using firebase
    ReadingDataHelper() {

    }

    public ReadingDataHelper(String user_name ,String user_email) {
        this.user_name = user_name;
        this.user_email = user_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
