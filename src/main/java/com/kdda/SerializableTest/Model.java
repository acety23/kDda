package com.kdda.SerializableTest;

import java.io.Serializable;

/**
 * java bean
 * 
 * @author baijiechong
 * @since 2023/5/21 18:51
 **/
public class Model implements Serializable {

    private static final long serialVersionUID = 17638329634L;

    private boolean isSuccess;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getBjc() {
        return "baijiechong";
    }
}
