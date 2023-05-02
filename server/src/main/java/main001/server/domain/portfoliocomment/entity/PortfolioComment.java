package main001.server.domain.portfoliocomment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main001.server.audit.BaseTimeEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "portfoliocomments",
        indexes ={
        @Index(columnList = "user"),
        @Index(columnList = "portfolio")
})
@Getter
@Setter
@NoArgsConstructor
public class PortfolioComment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long portfolioCommentId;

    @NotBlank(message = "내용은 반드시 포함되어야 합니다.")
    private String content;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Portfolio portfolio;
}
