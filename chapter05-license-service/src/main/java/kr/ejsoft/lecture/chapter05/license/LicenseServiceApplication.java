package kr.ejsoft.lecture.chapter05.license;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
//@ConfigurationPropertiesScan
@RefreshScope
public class LicenseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LicenseServiceApplication.class, args);
    }
}
