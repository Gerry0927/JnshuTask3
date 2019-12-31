package com.gerry.jnshu.controller;

import com.gerry.jnshu.pojo.BannerInfo;
import com.gerry.jnshu.response.Result;
import com.gerry.jnshu.service.BannerService;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("banner")
@RestController
@Validated
public class BannerController {

    @Resource
    private BannerService bannerService;

    @RequestMapping(method = RequestMethod.GET)
    public Result<List<BannerInfo>> getBannerInfos(){
        List<BannerInfo> bannerInfos = bannerService.getBannerList();
        return Result.success(bannerInfos,"查询成功");
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result<Integer> saveBannerInfo(BannerInfo bannerInfo,String imgUrl){

        List<String> imgUrls = new ArrayList<>();
        String[] imgArray= imgUrl.split(",");
        for (int i = 0; i < imgArray.length; i++) {
            imgUrls.add(imgArray[i]);
        }
        bannerInfo.setImgInfo(imgUrls);
        Integer bannerId = bannerService.saveBannerInfo(bannerInfo);

        return Result.success(bannerId,"保存成功");
    }

    @RequestMapping(value = "/{id}/{status}",method = RequestMethod.PUT)
    public Result<Object> updateBannerStatus(@NotNull @PathVariable Integer id, @Range(min=0,max = 1,message = "状态值只能为0或1") @PathVariable Integer status){
        int rowIds = bannerService.updateBanneStatus(id,status);
        if(rowIds<=0) {
            return Result.success(null,"更新失败,记录不存在");
        }
        return Result.success(null,"更新成功");
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result<Integer> deleteBannerInfo(@PathVariable Integer id){
        int rowIds = bannerService.deleteBannerInfo(id);
        if(rowIds<=0){
            return Result.success(null,"更新失败,记录不存在");
        }
        return Result.success(null,"删除成功");
    }

}
