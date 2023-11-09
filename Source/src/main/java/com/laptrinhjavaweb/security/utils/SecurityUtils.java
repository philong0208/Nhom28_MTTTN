package com.laptrinhjavaweb.security.utils;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.MyUserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtils {

    public static MyUserDetail getPrincipal() {
        return (MyUserDetail) (SecurityContextHolder
                .getContext()).getAuthentication().getPrincipal();
    }

    public static List<String> getAuthorities() {
        List<String> results = new ArrayList<>();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
        return results;
    }
    public static boolean isAdmin() {
        return getAuthorities().contains(SystemConstant.ADMIN_ROLE);
    }
    public static boolean isUser() {
        return getAuthorities().contains(SystemConstant.USER_ROLE);
    }
    public static boolean notLoginYet() {
        List<String> authorities = getAuthorities();
        return authorities.contains(SystemConstant.ANONYMOUS_ROLE);
    }
}
