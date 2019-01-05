//package com.ljt.myblog.Repository.User.Impl;
//
//import com.ljt.myblog.Domain.User.User;
//import com.ljt.myblog.Repository.User.UserRepositoey;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//import java.util.concurrent.atomic.AtomicLong;
//
//@Repository
//public class UserRepositoryImpl implements UserRepositoey {
//    private static AtomicLong counter = new AtomicLong();
//    private final ConcurrentMap<Long,User> userMap = new ConcurrentHashMap<Long,User>();
//    @Override
//    public User saveOrUpdateUser(User user){
//        Long id = user.getId();
//        if(id == null){
//            id = counter.incrementAndGet();
//            user.setid(id);
//        }
//        this.userMap.put(id,user);
//        return user;
//    }
//    @Override
//    public void deleteUser(Long id){
//        this.userMap.remove(id);
//    }
//    @Override
//    public User getUserByid(Long id){
//        return this.userMap.get(id);
//    }
//
//    public List<User> listUser(){
//
//        return new ArrayList<User>(this.userMap.values());
//    }
//}
