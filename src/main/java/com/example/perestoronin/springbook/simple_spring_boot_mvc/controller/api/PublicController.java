package com.example.perestoronin.springbook.simple_spring_boot_mvc.controller.api;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.controller.api.domain.RegisterArgument;
import com.example.perestoronin.springbook.simple_spring_boot_mvc.controller.api.domain.ServerTechnicalInfo;
import com.example.perestoronin.springbook.simple_spring_boot_mvc.service.PublicApiService;
import jakarta.validation.Valid;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/v1/PublicService",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces =MediaType.APPLICATION_JSON_VALUE )
public class PublicController  {

    @Autowired
    public PublicApiService publicService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.POST, value = "register")
    public void register(
            @RequestBody @Valid RegisterArgument registerArgument)
throws ServiceException
    {
        publicService.register(registerArgument);
    }


    @RequestMapping(method = RequestMethod.GET,
            value = "serverTechnicalInfo")  // (1)
    public ServerTechnicalInfo getServerTechnicalInfo()
            throws ServiceException {
        return publicService.getServerTechnicalInfo(); // (2)
    }
}
