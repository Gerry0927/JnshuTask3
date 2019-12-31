package com.gerry.jnshu.pojo;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO implements Serializable {

    private Integer currentPage;
    private Long totalNum;
    private Integer totalPages;
    private List<Comment> lit;
}