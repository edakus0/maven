package com.eda.backend.service;


import com.eda.backend.entitiy.User;
import com.eda.backend.model.UserUpdateRequestModel;
import com.eda.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service //Bu sınıfın kullanıcı hizmetini sağladığını gösterir
public class UserService<PasswordEencoder> {
    @Autowired
    UserRepository userRepository;
    PasswordEencoder passwordEencoder;

    //Save ile kaydetmemizi sağlar
    public void save(User user){
        userRepository.save(user);

    }

    //Kullanıcıları listelememizi sağlar
    public List<User> getUsers() {

        return userRepository.findAll();
    }

    //Update yapmamızı sağlayan fonksiyon
    public User update(Long id, UserUpdateRequestModel userUpdateRequestModel) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        user.setUserName(userUpdateRequestModel.getUserName());
        user.setPassword(userUpdateRequestModel.getPassword());
        userRepository.save(user);
        return user;
    }

    //Silme işlemini yapmamızı sağlayan fonksiyon
    public void sil(Long id) {
        userRepository.deleteById(id);
    }
}
