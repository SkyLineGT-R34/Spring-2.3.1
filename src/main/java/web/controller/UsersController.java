package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

// LIST ALL USERS

    @GetMapping("")
    public String readAll(Model model) {
        model.addAttribute("users", userService.readAll());
        return "index";
    }


// READ BY ID
    @GetMapping("/{id}")
    public String read(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.read(id));
        return "user";
    }


// NEW USER
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.create(user);
        return "redirect:/users";
    }


// EDIT
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.read(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/users";
    }

// DELETE //

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }


}

