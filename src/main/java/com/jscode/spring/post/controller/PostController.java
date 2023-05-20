package com.jscode.spring.post.controller;

import com.jscode.spring.post.dto.PostDto;
import com.jscode.spring.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController // request, response
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Long> createPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.createPost(postDto));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> searchById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.searchById(postId));
    }

    @GetMapping("/all")
    // @PageableDefault에서 주는건 딱 size만큼만 가져오는게 아니라 페이징단위를 size만큼, sort, direction정렬 단위로 가져오는 것
    public ResponseEntity<Page<PostDto>> searchAll(@PageableDefault(size = 100, sort = "createDate",  direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(postService.searchAllPost(pageable));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Long> updatePost(@RequestBody PostDto postDto, @PathVariable Long postId) {
        return ResponseEntity.ok(postService.updatePost(postDto, postId));
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<Page<PostDto>> searchPartPost(@PageableDefault(size = 100, sort = "createDate",  direction = Sort.Direction.DESC) Pageable pageable, @PathVariable String keyword){
        return ResponseEntity.ok(postService.searchPartPost(keyword, pageable));
    }
}
