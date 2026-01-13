package com.example.perestoronin.springbook.simple_spring_boot_mvc.service;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.controller.api.domain.RegisterArgument;
import com.example.perestoronin.springbook.simple_spring_boot_mvc.controller.api.domain.ServerTechnicalInfo;
import org.hibernate.service.spi.ServiceException;

public interface PublicApiService {

    void register(RegisterArgument registerArgument)
            throws ServiceException;


    ServerTechnicalInfo getServerTechnicalInfo()
            throws ServiceException;
}
