package com.gerry.jnshu.controller;

import com.gerry.jnshu.pojo.BannerInfo;
import com.gerry.jnshu.response.Result;
import com.gerry.jnshu.service.BannerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("banner")
@RestController
public class BannerController {

    @Resource
    private BannerService bannerService;

    @RequestMapping(method = RequestMethod.GET)
    public Result<List<BannerInfo>> getBannerInfos(){
        List<BannerInfo> bannerInfos = bannerService.getBannerList();
        return Result.success(bannerInfos,"查询成功");
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result<Integer> saveBannerInfo(BannerInfo bannerInfo){

        List<String> imgUrls = new ArrayList<>();
        String[] imgArray= bannerInfo.getImgUrls().split(",");
        for (int i = 0; i < imgArray.length; i++) {
            imgUrls.add(imgArray[i]);
        }
        bannerInfo.setImgUrlInfo(imgUrls);
        Integer bannerId = bannerService.saveBannerInfo(bannerInfo);

        return Result.success(bannerId,"保存成功");
    }

    @RequestMapping(value = "/{id}/{status}",method = RequestMethod.PUT)
    public Result<Object> updateBannerStatus(@PathVariable Integer id,@PathVariable Integer status){
        int rowIds = bannerService.updateBanneStatus(id,status);
        return Result.success(null,"更新成功");
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result<Integer> deleteBannerInfo(@PathVariable Integer id){
        Integer bannerId = bannerService.deleteBannerInfo(id);
        return Result.success(null,"删除成功");
    }

}
