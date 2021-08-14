package org.zerock.board.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    // 명시적 Lazy 로딩 지정 후 데이터베이스와 추가적인 설정을 해야 예외가 발생하지 않는다.
    @ManyToOne (fetch = FetchType.LAZY) //  명시적으로 Lazy 로딩 지정
    private Member writer;  // 연관관계 지정

    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContent(String content){
        this.content = content;
    }
}
