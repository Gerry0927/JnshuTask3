package com.gerry.jnshu.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO implements Serializable {

    private Integer currentPage;
    private Long totalNum;
    private Integer totalPages;
    private List<Reply> lit;
}