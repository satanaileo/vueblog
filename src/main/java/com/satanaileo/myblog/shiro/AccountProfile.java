package com.satanaileo.myblog.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * satanaileo
 * 2022/9/7 10:18
 */
@Data
public class AccountProfile implements Serializable {
    private Long id;
    private String username;
    private String avatar;
}
