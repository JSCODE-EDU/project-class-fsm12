package com.jscode.spring.post.entity;

import com.jscode.spring.base.entity.BaseTimeEntity;
import com.jscode.spring.post.dto.PostDto;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "post")
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id; // postId 로 하면 오류남

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Builder
    public static Post toEntity(PostDto postDto) {
        return Post.builder()
                .id(postDto.getPostId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .build();
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
