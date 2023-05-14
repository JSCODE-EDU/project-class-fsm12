package com.jscode.spring.post.service;

import com.jscode.spring.exception.ErrorCode;
import com.jscode.spring.exception.exception.PostNotFoundException;
import com.jscode.spring.post.dto.PostDto;
import com.jscode.spring.post.entity.Post;
import com.jscode.spring.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor // 생성자 주입
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    @Transactional
    public Long createPost(PostDto postDto) {
        Post post = Post.toEntity(postDto);
        postRepository.save(post);
        return post.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PostDto> searchAllPost(Pageable pageable) {
        Page<Post> postPage = postRepository.findAllByOrderByIdDesc(pageable);
        return postPage.map(PostDto::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public PostDto searchById(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isEmpty()) {
            throw new PostNotFoundException(ErrorCode.POST_NOT_FOUND_ERROR, "해당 게시물은 존재하지 않습니다");
        }
        return PostDto.toDto(post.get());
    }

    @Override
    public Long updatePost(PostDto postDto, Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isEmpty()) {
            throw new PostNotFoundException(ErrorCode.POST_NOT_FOUND_ERROR, "해당하는 게시글이 존재하지 않습니다.");
        }
        Post post = optionalPost.get();
        post.update(postDto.getTitle(), postDto.getContent());
        return postId;
    }

    @Override
    public void deletePost(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isEmpty()) {
            throw new PostNotFoundException(ErrorCode.POST_NOT_FOUND_ERROR, "해당하는 게시글이 존재하지 않습니다.");
        }
        Post post = optionalPost.get();
        postRepository.delete(post);
    }
}
