package userapi.system;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("User with ID " + id + " not found");
    }
}
