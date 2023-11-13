package com.laptrinhjavaweb.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDTO extends AbstractDTO {

    @Pattern(regexp = "^[a-zA-Z0-9-]+$", message = "Tên đăng nhập không hợp lệ: chỉ bao gồm chữ cái, chữ số và dấu gạch ngang!")
    private String userName;
    @Pattern(regexp = "^[a-zA-Z0-9-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$", message = "Email không hợp lệ")
    private String email;
    @NotBlank
    private String fullName;
    @Size(min = 6, max = 20, message = "Mật khẩu phải có độ dài từ 6 đến 20 ký tự")
    private String password;
    private Integer status;
    private String roleCode;
    private Map<String,String> roleDTOs;
    private List<RoleDTO> roles = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public Map<String, String> getRoleDTOs() {
        return roleDTOs;
    }

    public void setRoleDTOs(Map<String, String> roleDTOs) {
        this.roleDTOs = roleDTOs;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
