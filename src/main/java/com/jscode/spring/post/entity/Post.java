package com.jscode.spring.post.entity;

import com.jscode.spring.post.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "post")
public class Post {
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
