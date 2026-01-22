package umc.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.study.service.StoreService.StoreQueryService;

@SpringBootApplication // 스프링 부트 애플리케이션의 시작점을 표현, 자동설정, 컴포넌트 스캔, 스프링 컨텍스트 생성
@EnableJpaAuditing // Jpa Auditing 기능을 활성화한다. 이게 없으면 @createdDate, @LastModify 에노테이션 실행 불가능
public class StudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext context) {
        return args -> {
            StoreQueryService storeService = context.getBean(StoreQueryService.class);

            // 파라미터 값 설정
            String name = "요아정";
            Float score = 4.0f;

            // 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
            System.out.println("Executing findStoresByNameAndScore with parameters:");
            System.out.println("Name: " + name);
            System.out.println("Score: " + score);

            storeService.findStoresByNameAndScore(name, score)
                    .forEach(System.out::println);
        };
    }
}

