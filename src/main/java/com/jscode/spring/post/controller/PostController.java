package com.jscode.spring.post.controller;

import com.jscode.spring.post.dto.PostDto;
import com.jscode.spring.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.Objects;

@RestController // request, response
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Long> createPost(@Valid @RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.createPost(postDto));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> searchById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.searchById(postId));
    }

    // @PageableDefault에서 주는건 딱 size만큼만 가져오는게 아니라 페이징단위를 size만큼, sort, direction정렬 단위로 가져오는 것
    @GetMapping("/search")
    public ResponseEntity<Page<PostDto>> searchPosts(@PageableDefault(size = 100, sort = "createDate",  direction = Sort.Direction.DESC) Pageable pageable, @Nullable @RequestParam String keyword){
        if (Objects.isNull(keyword)){
            return ResponseEntity.ok(postService.searchAllPost(pageable));
        }
        // 예시 : http://localhost:8080/post/search?keyword=1
        return ResponseEntity.ok(postService.searchPartPost(keyword, pageable));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Long> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Long postId) {
        return ResponseEntity.ok(postService.updatePost(postDto, postId));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }


}
