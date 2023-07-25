package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showUsers(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/add_user")
    public String showForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping("/add_user")
    public String submitForm(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "add_success";
    }

    @RequestMapping("/delete_user")
    public String deleteUser(@ModelAttribute(value="userToDelete") User deleteUser, ModelMap model) {
        userService.deleteById(deleteUser.getId());
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping("/user_to_edit")
    public String inputUpdatedData(@ModelAttribute(value="editUser") User user, ModelMap model) {
        model.put("user", user);
        return "update_user";
    }

    @PostMapping("/update_user")
    public String updateUser(@ModelAttribute("updateUser") User user) {
        userService.updateUser(user);
        return "update_success";
    }
}
