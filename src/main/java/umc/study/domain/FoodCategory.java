package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.MemberPrefer;

import java.util.ArrayList;
import java.util.List;

@Entity // DB에 엔티티인것을 표현
@Getter // LOMBOK 라이브러리의 기능, 자동으로 GETTER를 넣어준다.
@Builder // LOMBOK 라이브러리의 기능, 자동으로 BUILDER를 넣어준다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory extends BaseEntity {
    // JPA한테 이건 PRIMARY_KEY라는 사실을 알려주는 @ID 에노테이션 이때 꼭 @Entity 에노테이션이 있다면
    // 반드시 @id 에노테이션이 존재해야한다,
    @Id // 이 변수는 PK이야
    // PRIMARY_KEY 값을 자동생성 전략을 지정.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 15)
    private String name;

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();
}
