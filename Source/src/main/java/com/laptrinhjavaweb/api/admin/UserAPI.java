package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.PasswordDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.UserInfoDTO;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Validated
public class UserAPI {


    @Autowired
    private IUserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<List<UserInfoDTO>> getAll() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUsers(@RequestBody UserDTO newUser) {
        return ResponseEntity.ok(userService.insert(newUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUsers(@PathVariable("id") long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.update(id, userDTO));
    }

    @PutMapping("/change-password/{id}")
    public ResponseEntity<String> changePasswordUser(@PathVariable("id") long id, @RequestBody PasswordDTO passwordDTO) {
        try {
            userService.updatePassword(id, passwordDTO);
            return ResponseEntity.ok(SystemConstant.UPDATE_SUCCESS);
        } catch (Exception e) {
//            LOGGER.error(e.getMessage());
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PutMapping("/password/{id}/reset")
    public ResponseEntity<UserDTO> resetPassword(@PathVariable("id") long id) {
        return ResponseEntity.ok(userService.resetPassword(id));
    }

    @PutMapping("/profile/{username}")
    public ResponseEntity<UserDTO> updateProfileOfUser(@PathVariable("username") String username, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateProfileOfUser(username, userDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUsers(@RequestBody long[] idList) {
        if (idList.length > 0) {
            userService.delete(idList);
        }
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO newUser) {
        return userRepository.existsByUserName(newUser.getUserName())
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(userService.insert(newUser));
    }
}
