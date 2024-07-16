package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public void listUsers() {
      List<User> users = userDao.listUsers();
      for (User user : users) {
         System.out.println(user);
         System.out.println();
      }
   }

   @Transactional(readOnly = true)
   @Override
   public void getUserByCar(String model, int series) {
      try {
         userDao.getUserByCar(model, series);
         System.out.println();
      } catch (javax.persistence.PersistenceException e) {
         System.err.println("The user was not found or incorrectly entered data.");
      }
   }
}
