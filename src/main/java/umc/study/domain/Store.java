package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity // 엔티티라는 것을 jpa에게 알려준다.
@Getter // lombok 라이브러리의 기능으로 자동으로 getter를 삽입해준다.
@Builder // 빌더 패턴으로 Lombok이 빌더 메서드를 생성해준다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 객체생성을 스프링이 할 수 있도록 설정하고, 만든 객체의 접근지정자를 protected로 설정함
// ==> JPA 스펙상 프록시 설정을 위해서 이 부분이 꼭 필요하다. 프록시란 일종의 가짜참조라고 생각하면 되는데, 일단 처음 영속화가 이루어지면서 껍데기만 만들어 놓는다
// 이후 해당 엔티티에 대한 조회가 이루어져 객체가 필요해진 순간에 엔티티에서 쿼리가 일어나게 하고, 호출되지 않으면 쿼리를 진행하지 않아 효율을 극대화 한다.
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자를 LOMBOK이 만들어준다.
public class Store extends BaseEntity {


    // DB에 PRIMARY_KEY를 만드는 것과 같은 의미의 에노테이션 조합
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // (자동 증가 컬럼)에 따라서 PK값을 DB가 넣도록 한다.
    private long id;

    @Column(nullable = false, length = 50) // 컬럼의 기능을 제한하는 역할을 하는데, 여기서는 이 컬럼은 NULL을 허용하지 않고, 길이는 50 이하로 한다.
    private String name;

    @Column(nullable = false, length = 50)
    private String address;

    private float score;



    // 다대일 연관관계를 매핑하며, region은 지연로딩(LAZY)으로 실제 접근 시점에 조회된다.
    // CascadeType.ALL은 Store의 영속 상태 변경(PERSIST, REMOVE 등)을 Region에도 전파하는데,
    // ManyToOne에 ALL을 사용하는 것은 Region이 여러 Store에서 공유될 때 매우 위험할 수 있다.
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "region_id") // FK의 컬럼의 이름을 region_id로 할것이다.
    // 여기서 cascade는 상태전파라는 의미를 가지고 있는데 여기서 종속의 타입을 ALL 전체로 해놓았다는 것은 STORE의 상태변화(변경,삭제 등등)을 REGION도 알게해준다는 의미이다.
    private Region region; // 필드를 설정


    // 일대다 연관관계를 표현하는 OneToMany 에노테이션, Store 객체는 여러개의 review 객체를 가질 수 있다.
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    // 여기서 중요한 부분은 매핑을 하는 부분인데, Review 엔티티에 store 필드가 이 연관관계의 주인(외래 키를 가진 쪽)이라는 것을 나타낸다.
    private List<Review> reviewList = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", region=" + (region != null ? region.getName() : "N/A") + // region의 이름 출력
                '}';
    }
}

