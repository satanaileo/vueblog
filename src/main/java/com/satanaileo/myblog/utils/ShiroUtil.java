package com.satanaileo.myblog.utils;

import com.satanaileo.myblog.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
 * satanaileo
 * 2022/9/8 14:01
 */
public class ShiroUtil {
    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
