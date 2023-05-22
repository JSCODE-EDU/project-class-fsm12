package com.jscode.spring.post.service;

import com.jscode.spring.post.dto.PostDto;
import com.jscode.spring.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Long createPost(PostDto postDto);
    Page<PostDto> searchAllPost(Pageable pageable);
    PostDto searchById(Long postId);
    Long updatePost(PostDto postDto, Long postId);
    String deletePost(Long postId);
    Page<PostDto> searchPartPost(String keyword, Pageable pageable);

}
