package com.gerry.jnshu.pojo;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BannerDTO implements Serializable {

    private String imgUrls;
    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

}
