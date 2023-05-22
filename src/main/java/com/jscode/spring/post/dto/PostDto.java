package com.jscode.spring.post.dto;

import com.jscode.spring.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private Long postId;

    /*
    @NotNull : Null만 허용하지 않음, "" 이나 " " 은 허용
    @NotEmpty : null 과 "" 둘 다 허용하지 않음, " " 은 허용
    @NotBlank : null 과 "" 과 " " 모두 허용하지 않음
    - 위와 같은 어노테이션을 쓸경우 Controller 단에서 해당 제한사항을 걸어줄 변수에 @Valid를 붙여주어야 함
     */

    @NotBlank(message = "제목은 공백으로만 이루어질 수는 없습니다.")
    @Size(min = 1, max = 15, message = "제목은 1글자 이상 15글자 이하여야 합니다.")
    @Column(length = 15)
    private String title;

    @NotBlank(message = "내용은 한글자 이상이어야 합니다.")
    @Size(min = 1, max = 1000, message = "내용은 1글자 이상 1000글자 이하여야 합니다.")
    @Column(length = 1000)
    private String content;
    private LocalDateTime createTime;

    @Builder
    public static PostDto toDto(Post post){
        return PostDto.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createTime(post.getCreateDate())
                .build();
    }

}
