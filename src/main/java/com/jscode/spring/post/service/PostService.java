package com.jscode.spring.post.service;

import com.jscode.spring.post.dto.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    /* 게시글 작성 기능
    - 게시글은 제목, 내용을 포함
    - 게시글이 저장될 때, postId(PK, primary key)도 같이 Auto-increment 형식으로 저장
    - 게시글 작성에 성공했을 때, 응답값으로 작성된 게시글에 대한 정보를 보여주어야 함 */
    Long createPost(PostDto postDto);

    /* 게시글 전체 조회
    - 조회할 때 postId, 제목, 내용의 값이 포함 */
    Page<PostDto> searchAllPost(Pageable pageable);

    /* 특정 게시글 조회
    - 게시글의 postId(PK, primary key)로 특정 게시글을 조회
    - 조회할 때 postId, 제목, 내용의 값이 포함 */
    PostDto searchById(Long postId);

    /* 특정 게시글 수정
    - postId(PK, primary key)로 특정 게시글을 수정
    - 게시글의 제목, 내용을 수정
    - 수정에 성공했을 때, 응답값으로 수정된 게시글에 대한 정보를 보여주어야 함 */
    Long updatePost(PostDto postDto, Long postId);

    /* 특정 게시물 삭제
    - 게시글의 postId(PK, primary key)로 특정 게시글을 삭제 */
    void deletePost(Long postId);
}
