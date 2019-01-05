package com.ljt.myblog.Repository.User;

import com.ljt.myblog.Domain.User.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
   /* User saveOrUpdateUser(User user);

    void deleteUser(Long id);

    User getUserByid(Long id);

    List<User> listUser();*/
}
