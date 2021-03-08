package com.example.demo.application.commentapplication;


import com.example.demo.domain.commentdomain.Comment;
import com.example.demo.domain.commentdomain.CommentRepository;
import com.example.demo.domain.commentdomain.CommentService;
import com.example.demo.dto.commentdtos.CommentDTO;
import com.example.demo.dto.commentdtos.CreateCommentDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentApplicationImp implements CommentApplication {
   
         private final CommentRepository commentRepository;

        @Autowired
        public CommentApplicationImp(final CommentRepository commentRepository){
            this.commentRepository = commentRepository;
        }

        @Override
        public CommentDTO add(CreateCommentDTO dto){
            Comment comment = CommentService.create(dto);
            this.commentRepository.add(comment);
            return CommentService.createDTO(comment);
        }

}
