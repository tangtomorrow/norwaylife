package org.tym.blinking.norwaylife.web.vo;

import com.google.common.base.MoreObjects;

/**
 * Created by tangtomorrow on 2017/2/22.
 */
public class UserVO {
    private int id;
    private String userId;
    private String userName;
    private String email;

    public UserVO() {
    }

    public UserVO(int id, String userId, String userName, String email) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("userId", userId)
                .add("userName", userName)
                .add("email", email)
                .toString();
    }
}
