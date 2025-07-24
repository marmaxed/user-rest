package userapi.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import userapi.models.entities.Role;
import userapi.models.entities.User;
import userapi.models.rest.UserRequestDTO;
import userapi.repositories.RoleRepository;
import userapi.repositories.UserRepository;
import userapi.system.NotFoundException;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    public UserService(UserRepository userRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public User createUser(UserRequestDTO dto) {
        Role role = new Role(null, dto.getRoleName());
        User user = new User(null, dto.getFio(), dto.getPhoneNumber(), dto.getAvatar(), role);
        return userRepo.save(user);
    }

    @Cacheable(value = "users", key = "#userId")
    public User getUser(UUID userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new NotFoundException(userId));
        return user;
    }

    public User updateUser(UUID id, UserRequestDTO dto) {
        User user = getUser(id);
        user.setFio(dto.getFio());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setAvatar(dto.getAvatar());
        user.setRole(new Role(null, dto.getRoleName()));
        return userRepo.save(user);
    }

    @CacheEvict(value = "users", key = "#userId")
    public void deleteUser(UUID id) {
        User user = getUser(id);
        Role role = user.getRole();
        userRepo.delete(user);
        roleRepo.delete(role);
    }
}

