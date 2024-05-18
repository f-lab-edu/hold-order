package com.holdOrder.HoldOrder.applicationTest;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
public class ApplicationTestCheck {
    @Autowired
    DataSource dataSource;

    @Test
    @DisplayName("테스트가 application-test 설정파일을 잘 준수하면서 실행되는지 확인")
    public void work_in_application_test_setting() {
        assertThat(((HikariDataSource) dataSource).getJdbcUrl()).isEqualTo("jdbc:h2:mem:test;MODE=MySQL");
    }
}
