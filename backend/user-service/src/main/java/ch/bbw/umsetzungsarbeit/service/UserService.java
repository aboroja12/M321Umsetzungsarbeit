package ch.bbw.umsetzungsarbeit.service;

import ch.bbw.umsetzungsarbeit.model.User;
import ch.bbw.umsetzungsarbeit.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
  }

  public User updateUser(Long id, User updatedUser) {
    User user = getUserById(id);
    user.setName(updatedUser.getName());
    user.setEmail(updatedUser.getEmail());
    return userRepository.save(user);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
