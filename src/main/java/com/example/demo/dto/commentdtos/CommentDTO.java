package com.example.demo.dto.commentdtos;


import java.sql.Date;
import java.util.UUID;


//TO DO: Implementar user cuando esté disponible
public class CommentDTO {
    public UUID id;
    public String text;
    public Date date;
    public int score;
}
