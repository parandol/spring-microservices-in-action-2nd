package kr.ejsoft.lecture.chapter05.license;

import kr.ejsoft.lecture.chapter05.license.configure.BeanConfigure;
import kr.ejsoft.lecture.chapter05.license.configure.DatabaseConfigure;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
@ActiveProfiles("dev")
class LicenseServiceApplicationTests {

//    @Test
    void contextLoads() {
    }

}
