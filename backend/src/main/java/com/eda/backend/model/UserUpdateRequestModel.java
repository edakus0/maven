package com.eda.backend.model;

import lombok.Data;

@Data //verileri çekiyoruz
public class UserUpdateRequestModel {
    String userName;
    String password;
}
