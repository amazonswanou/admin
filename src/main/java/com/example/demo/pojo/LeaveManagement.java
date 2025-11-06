package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (LeaveManagement)实体类
 *
 * @author makejava
 * @since 2024-11-03 13:37:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LeaveManagement implements Serializable {

    private String id;

    private String username;

    private String studentId;

    private String leaveTime;

    private String reasonType;

    private String location;

    private String status;

    private String leaveStatus;

}

