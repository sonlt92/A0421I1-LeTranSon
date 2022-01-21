//package com.letranson.furama.service.impl;
//
//import com.letranson.furama.bean.Role;
//import com.letranson.furama.repository.AppUserRepository;
//import com.letranson.furama.repository.UserRoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private AppUserRepository appUserRepository;
//
//    @Autowired
//    private UserRoleRepository userRoleRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        com.letranson.furama.bean.User appUser = this.appUserRepository.findByUserName(userName);
//
//        if (appUser == null) {
//            System.out.println("User not found! " + userName);
//            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
//        }
//
//        List<Role> roleNames = this.userRoleRepository.findByUsers(appUser);
//
//        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//        if (roleNames != null) {
//            for (Role role : roleNames) {
//                GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
//                grantList.add(authority);
//            }
//        }
//
//        return (UserDetails) new User(appUser.getUserName(),
//                appUser.getPassWord(), grantList);
//    }
//
//}