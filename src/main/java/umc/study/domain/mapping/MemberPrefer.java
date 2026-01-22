package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY) // 이 ManyToOne 에노테이션은 jpa에게 다대일 관계라고 알려준다.
    // 또한 필요할 때만 Member 로딩 (지연로딩)하도록 설정한다.
    @JoinColumn(name = "member_id") // FK 컬럼을 만들고 그 컬럼의 이름은 member_id로 해달라고 한다.
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;

}
