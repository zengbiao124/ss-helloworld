//package cn.com.taiji.learn.sshelloworld.dao;
//
//import cn.com.taiji.learn.sshelloworld.domain.User;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//import java.util.concurrent.atomic.AtomicLong;
//
//@Component
//public class InMemoryUserRepository implements UserRepository {
//    private static AtomicLong counter = new AtomicLong();
//
//    private final ConcurrentMap<Long, User> users = new ConcurrentHashMap<Long, User>();
//
//    @Override
//    public User findByEmail(String email) {
//        return null;
//    }
//
////    @Override
////    public Iterable<User> findAll() {
////        return this.users.values();
////    }
//
//    @Override
//    public User save(User user) {
//        Long id = user.getId();
//        if (id == null) {
//            id = counter.incrementAndGet();
//            user.setId(id);
//        }
//        this.users.put(id, user);
//        return user;
//    }
//
//    @Override
//    public User findUser(Long id) {
//        return this.users.get(id);
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        this.users.remove(id);
//    }
//}