package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.PasswordDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.UserInfoDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    UserDTO findOneByUserName(String userName);
    UserDTO findUserById(long id);
    void delete(long[] ids);
    List<UserDTO> getUsers(String searchValue, Pageable pageable);
    List<UserInfoDTO> getUsers();
    int getTotalItems(String searchValue);
    UserDTO insert(UserDTO userDTO);
    UserDTO update(Long id, UserDTO userDTO);
    UserDTO updateProfileOfUser(String id, UserDTO userDTO);
    void updatePassword(long id, PasswordDTO userDTO) throws Exception;
    UserDTO resetPassword(long id);
    UserDTO findOneByUserNameAndStatus(String name, int status);
}
