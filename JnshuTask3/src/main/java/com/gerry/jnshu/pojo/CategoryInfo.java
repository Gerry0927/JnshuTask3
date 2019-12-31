package com.gerry.jnshu.pojo;

import lombok.*;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Table(name = "category")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name="create_time")
    private String createTime;

    @Column(name = "update_time")
    private String updateTime;

    @Transient
    private List<CategoryInfo> seCategories;



}