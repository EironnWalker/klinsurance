package com.ht.klinsurance.sys.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRole implements Serializable {

    private String roleId;
    private String roleName;
    private String description;
}