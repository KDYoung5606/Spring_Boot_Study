package umc.study.domain.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // JPA에게 이 클래스는 테이블이 없는 공통의 부모 클래스라는 걸 알려주고,
// 자식 엔티티들은 내 필드/매핑정보들을 물려받게 해준다.
@EntityListeners(AuditingEntityListener.class) // 생성 및 수정시간을 자동으로 기록하기 위해서 이 리스터를 호충한다는 걸 JPA에게 알려준다.

public abstract class BaseEntity {
    @CreatedDate // 엔티티 최초 실행 시 현재 시간을 자동으로 저장, 한번만 실행됨
    @Column(updatable = false) // 컬럼에 대한 정보를 변경할 수 없게 한다.
    private LocalDateTime createdDate;

    @LastModifiedBy // 마지막 수정한 시간을 자동으로 저장하도록 한다.
    private LocalDateTime lastModifiedDate;
}
