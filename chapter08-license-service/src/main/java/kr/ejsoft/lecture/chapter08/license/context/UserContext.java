package kr.ejsoft.lecture.chapter08.license.context;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class UserContext {
    public static final String CORRELATION_ID = "tmx-correlation-id";
    public static final String USER_ID = "tmx-user-id";
    public static final String AUTH_TOKEN = "tmx-auth-token";
    public static final String ORGANIZATION_ID = "tmx-organization-id";

    private String correlationId = "";
    private String userId = "";
    private String authToken = "";
    private String organizationId = "";
}
