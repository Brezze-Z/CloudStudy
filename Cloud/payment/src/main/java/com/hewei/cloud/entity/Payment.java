package com.hewei.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// 支付实体类
// 做分布式平台的时候需要引入序列化
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private int id;
    private String serial;


}
