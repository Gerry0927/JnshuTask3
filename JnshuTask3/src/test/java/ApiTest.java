import com.gerry.jnshu.pojo.BannerInfo;
import com.gerry.jnshu.service.BannerService;
import com.gerry.jnshu.service.ImageInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class ApiTest {

    @Resource
    BannerService bannerService;

    @Resource
    ImageInfoService imageInfoService;
    @Test
    public void getBannerInfos(){
        List<BannerInfo> bannerInfos = bannerService.getBannerList();
        for (BannerInfo info : bannerInfos) {
            System.out.println(info);
        }
    }

    @Test
    public void saveBanner(){
        BannerInfo bannerInfo = new BannerInfo();
        bannerInfo.setUserId(1);
        bannerInfo.setStatus(0);
        Integer bannerId = bannerService.saveBannerInfo(bannerInfo);
//        if(bannerId>0){
//            imageInfoService.saveImageInfo();
//        }
        System.out.println("插入成功--->"+bannerId);
    }
    @Test
    public void updateBannerStatus(){
        int rowIds = bannerService.updateBanneStatus(5,1);
        System.out.println("修改成功--->"+rowIds);
    }
    @Test
    public void deleteBannerInfo(){
        int rowIds = bannerService.deleteBannerInfo(1);
        System.out.println("删除成功--->"+rowIds);
    }


}
