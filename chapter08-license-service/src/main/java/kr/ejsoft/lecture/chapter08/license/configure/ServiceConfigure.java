package kr.ejsoft.lecture.chapter08.license.configure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix="example")
public class ServiceConfigure {
    private String property;
}
