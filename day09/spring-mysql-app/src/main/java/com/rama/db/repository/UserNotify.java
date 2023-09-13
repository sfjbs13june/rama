package com.rama.db.repository;

import org.springframework.stereotype.Component;

@Component
public class UserNotify {

    public String isSave() {
        return "saved data";
    }

    public String isGet() {
        return "read data";
    }

    public String isDeleted() {
        return "delete data";
    }
}
