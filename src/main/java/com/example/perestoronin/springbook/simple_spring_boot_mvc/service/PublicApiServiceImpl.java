package com.example.perestoronin.springbook.simple_spring_boot_mvc.service;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.controller.api.domain.RegisterArgument;
import com.example.perestoronin.springbook.simple_spring_boot_mvc.controller.api.domain.ServerTechnicalInfo;
import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.UserDao;
import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.Role;
import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.User;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Service
public class PublicApiServiceImpl implements PublicApiService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Clock clock;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public void register(RegisterArgument registerArgument)
            throws ServiceException {

        User user = new User();
        user.setLogin(registerArgument.login());
        user.setName(registerArgument.name());
        user.setPassword(passwordEncoder.encode(registerArgument.password()));
        user.setEmail(registerArgument.email());
        user.setRegistrationDate(OffsetDateTime.now(clock));
        user.setRoles(Role.USER.name());
        user.setEnabled(true);
        userDao.save(user);
    }

    @Override
    public ServerTechnicalInfo getServerTechnicalInfo()       throws ServiceException {
        try {

            Properties properties = System.getProperties();
            Map<String, String> infoMap = new HashMap<String, String>();
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                infoMap.put(String.valueOf(entry.getKey()),
                        String.valueOf(entry.getValue()));
            }
            ServerTechnicalInfo info = new ServerTechnicalInfo(infoMap);
            return info;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }
}