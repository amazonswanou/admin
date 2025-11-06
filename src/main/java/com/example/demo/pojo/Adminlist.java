package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (AdminlistDao)实体类
 *
 * @author makejava
 * @since 2024-11-03 13:33:14
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Adminlist implements Serializable {

    private String adminId;

    private String adminName;

    private String role;

    private String username;

    private String password;

}

