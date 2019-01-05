package com.ljt.myblog.Controller.User;

import com.ljt.myblog.Domain.User.User;

import com.ljt.myblog.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /*@RequestMapping("/user")*/
    @GetMapping
    public ModelAndView List(Model model){
        model.addAttribute("userList",userRepository.findAll());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/List","userModel",model);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id")Long id,Model model){
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user",user.get());
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id")Long id,Model model){
        userRepository.deleteById(id);

        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/modify/{id}")
    public ModelAndView modifyUser(@PathVariable("id")Long id,Model model){
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","修改用户");

        return new ModelAndView("users/form","userModel",model);

    }

    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User(null,null,null));
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        user = userRepository.save(user);

        return new ModelAndView("redirect:/users");
    }























}
