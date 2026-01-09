package com.example.perestoronin.springbook.simple_spring_boot_mvc.config;


import org.apache.catalina.Server;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.security.PrivateKey;

@ConfigurationProperties("virtualpets-spring-boot")
@Configuration
public class VirtualpetsServerSpringBootProperties {
    private String version;
    private Server server;
    public class Server{
        private String url;
        public String getUrl(){
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }

    }
    public String getVersion(){
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Server getServer() {
        return server;
    }
}
