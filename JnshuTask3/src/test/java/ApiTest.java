import com.gerry.jnshu.pojo.BannerInfo;
import com.gerry.jnshu.pojo.CategoryInfo;
import com.gerry.jnshu.pojo.Comment;
import com.gerry.jnshu.service.BannerService;
import com.gerry.jnshu.service.CategoryService;
import com.gerry.jnshu.service.CommentService;
import com.github.pagehelper.PageInfo;
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
    CategoryService categoryService;

    @Resource
    CommentService commentService;
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

    @Test
    public void queryCategoryByParentId(){
        List<CategoryInfo> categoryList = categoryService.getCategoryList();
        for (CategoryInfo info : categoryList) {
            System.out.println(info);
        }

    }

    @Test
    public void deleteCategoryInfo(){
        Integer id = 2;
        int rowIds = categoryService.deleteCategoryInfo(id);
        System.out.println(rowIds);
    }

    @Test
    public void updateCategoryInf(){
        CategoryInfo categoryInfo = new CategoryInfo();
        categoryInfo.setId(1);
        categoryInfo.setCategoryName("AA");
//        categoryService.updateCategoryInfo()
    }

    @Test
    public void getCommentList(){
        PageInfo<Comment> commentInfo = commentService.getCommentList(2, 10, 100);
        for (Comment comment : commentInfo.getList()) {
            System.out.println(comment);
        }
    }


}
