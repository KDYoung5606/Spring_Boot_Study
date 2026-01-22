package umc.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication // 스프링 부트 애플리케이션의 시작점을 표현, 자동설정, 컴포넌트 스캔, 스프링 컨텍스트 생성
@EnableJpaAuditing // Jpa Auditing 기능을 활성화한다. 이게 없으면 @createdDate, @LastModify 에노테이션 실행 불가능
public class StudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }
}
