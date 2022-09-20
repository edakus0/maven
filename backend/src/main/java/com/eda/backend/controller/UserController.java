package com.eda.backend.controller;

import com.eda.backend.entitiy.User;
import com.eda.backend.model.UserUpdateRequestModel;
import com.eda.backend.repository.UserRepository;
import com.eda.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Sınıfın uygulamanın denetleyici parçası olduğunu gösterir
@RequestMapping("/api") //Verilen URL kalıbı ile karşılaşıldığında yöntemin çağırılması gerektiğini belirtir
public class UserController {
    @Autowired //Kontrolün tersine çevrilmesi içindir.Bağımlılığın kontrolü uygulamaya enjekte edilir veya ters çevrilir
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/users/post") //Yeni bir kullanıcı yarattık post ile ekledik
    public void createUser(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("/users") //Girdiğimiz kullanıcı adı ve parolayı bize getiriyor
        List<User> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/users/{id}") //Girdiğimiz verileri güncellememizi sağlıyor
    public User updateUser(@PathVariable Long id,@Validated @RequestBody UserUpdateRequestModel userUpdateRequestModel){
        User user = userService.update(id,userUpdateRequestModel);
        return user;

    }
    @DeleteMapping("/users/delete/{id}") //Verileri silmemizi sağlıyor
    public void deleteUser(@PathVariable Long id){
        userService.sil(id);
    }
}