package model.service.impl;

import model.bean.User;
import model.repository.UsersRepository;
import model.repository.impl.UsersRepositoryImpl;
import model.service.UsersService;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository =new UsersRepositoryImpl();

    @Override
    public void insertUser(User user) throws SQLException {
        usersRepository.insertUser(user);
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = this.usersRepository.selectAllUsers();
        return userList;
    }

    @Override
    public User selectUser(int id) {
        return this.usersRepository.selectUser(id);
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        this.usersRepository.deleteUser(id);
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        this.usersRepository.updateUser(user);
        return false;
    }

    @Override
    public List<User> search(String country) throws SQLException {
        List<User> users = this.usersRepository.search(country);
        return users;
    }
}
