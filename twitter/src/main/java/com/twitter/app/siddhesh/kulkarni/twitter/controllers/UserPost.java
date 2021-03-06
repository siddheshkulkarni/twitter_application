package com.twitter.app.siddhesh.kulkarni.twitter.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.app.siddhesh.kulkarni.twitter.jpa.PostRepository;
import com.twitter.app.siddhesh.kulkarni.twitter.pojo.Follower;
import com.twitter.app.siddhesh.kulkarni.twitter.pojo.Post;

@RestController
public class UserPost {
  ArrayList<Post> list = new ArrayList<Post>();
  
  @Autowired
  PostRepository p;
  
  @PostMapping("/post")
  public List<Post> postMessage(@RequestBody Post post) {
    p.save(post);
    list.add(post);
     return list;
  }
  
  @GetMapping("/post")
  public List<Post> getUserPosts() {
    return list;  
  }
}
