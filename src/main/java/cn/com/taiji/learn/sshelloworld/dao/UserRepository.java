package cn.com.taiji.learn.sshelloworld.dao;
import cn.com.taiji.learn.sshelloworld.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}