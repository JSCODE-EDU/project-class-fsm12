package com.jscode.spring.post.dto;

import com.jscode.spring.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private Long postId;
    private String title;
    private String content;

    @Builder
    public static PostDto toDto(Post post){
        return PostDto.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

}
