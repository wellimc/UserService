package com.fastandfoodius.users.controller;

import com.fastandfoodius.users.model.UserBean;
import com.fastandfoodius.users.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/user")
    public List<UserBean> all() {
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<UserBean> all(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @GetMapping("/user/title/{title}")
    public List<UserBean> search(@PathVariable String title) {
        return repository.findByTitle(title);
    }

    //   @GetMapping("/user/firstName/{firstName}")
    //  public List<UserBean> search(@PathVariable String  firstName){ return repository.findByFirstName(firstName); }

    //  @GetMapping("/user/email/{emailAddress}")
    //  public List<UserBean> search(@PathVariable String  emailAddress){ return repository.findByEmailAddress(emailAddress); }

    @PostMapping("/user")
    public UserBean create(@RequestBody Map<String, String> body) {
        UserBean user = new UserBean();
        user = setUserValues(user, body);
        return repository.saveAndFlush(user);
    }

    @PutMapping("/user/{id}")
    public UserBean update(@PathVariable String id, @RequestBody Map<String, String> body) {
        Integer userId = Integer.parseInt(id);
        UserBean user = repository.findById(userId).orElse(null);
        user = setUserValues(user, body);
        return repository.saveAndFlush(user);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable String id) {
        Integer userId = Integer.parseInt(id);
        UserBean user = repository.findById(userId).orElse(null);
        repository.delete(user);
    }


    private UserBean setUserValues(UserBean user, Map<String, String> body) {
        if (user == null) {
            user = new UserBean();
        }

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = body.get("dateOfBirth");
        Date date = null;
        try {
            date = dt.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        user.setFirstName(body.get("firstName"));
        user.setLastName(body.get("lastName"));
        user.setDateOfBirth(date);
        user.setGender(body.get("gender"));
        user.setTitle(body.get("title"));
        user.setPhone(body.get("phone"));
        user.setAddress(body.get("address"));
        user.setCity(body.get("city"));
        user.setPostalCode(body.get("postalCode"));
        user.setEmail(body.get("email"));
        return user;
    }

}
