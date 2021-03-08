package com.example.demo.infraestructure.commentinfraestructure;

import java.util.UUID;
import com.example.demo.domain.commentdomain.Comment;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJPARepository extends JpaRepository<Comment, UUID> {
}
