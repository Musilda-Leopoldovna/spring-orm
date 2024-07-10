package hiber.service;

import hiber.model.User;

public interface UserService {

    void add(User user);

    void listUsers();

    void getUserByCar(String model, int series);
}
