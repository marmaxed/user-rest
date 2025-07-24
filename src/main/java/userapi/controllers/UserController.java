package userapi.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userapi.models.entities.User;
import userapi.models.rest.UserRequestDTO;
import userapi.services.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createNewUser")
    public ResponseEntity<User> create(@RequestBody @Valid UserRequestDTO dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @GetMapping("/users")
    public ResponseEntity<User> get(@RequestParam UUID userID) {
        return ResponseEntity.ok(userService.getUser(userID));
    }

    @PutMapping("/userDetailsUpdate")
    public ResponseEntity<User> update(@RequestParam UUID userID, @RequestBody @Valid UserRequestDTO dto) {
        return ResponseEntity.ok(userService.updateUser(userID, dto));
    }

    @DeleteMapping("/users")
    public ResponseEntity<Void> delete(@RequestParam UUID userID) {
        userService.deleteUser(userID);
        return ResponseEntity.noContent().build();
    }
}

