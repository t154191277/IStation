package bistu.wmlove.istation.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import bistu.wmlove.istation.entity.Cart;
import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.entity.Goods;
import bistu.wmlove.istation.entity.Response;
import bistu.wmlove.istation.entity.User;
import bistu.wmlove.istation.entity.WordAndCount;
import bistu.wmlove.istation.service.ICartService;
import bistu.wmlove.istation.service.ICategoryService;
import bistu.wmlove.istation.service.IGoodsService;
import bistu.wmlove.istation.service.IImageService;
import bistu.wmlove.istation.service.IShopService;
import bistu.wmlove.istation.service.IWordCountService;

/**
 * 
 * @author wmlove
 * @date 2018年4月16日
 *
 */
@Controller
@RequestMapping(value = "/api")
public class ShopController extends BaseController{

	@Autowired
	private IShopService shopService;
	
	@Autowired
	private IGoodsService goodService;
	
	@Autowired
	private IImageService imageService;
	
	@RequestMapping(path="/shop", method=RequestMethod.GET)
	public String select(@RequestParam(name = "id", required = false) String id){
		return "shop";
	}
	
	@RequestMapping(path="/shop", method = RequestMethod.POST)
    public String save(@RequestParam(name = "shopName", required = true) String shopName
    		,@RequestParam(name = "shopId", required = true) String shopId
    		,@RequestParam(name = "catg1", required = true) String catg1
    		,@RequestParam(name = "catg2", required = true) String catg2
    		,@RequestParam(name = "goodId", required = true) String goodId
    		,@RequestParam(name = "goodName", required = true) String goodName
    		,@RequestParam(name = "goodDesc", required = true) String goodDesc
    		,@RequestParam(name = "goodPrice", required = true) String goodPrice
    		,@RequestParam(name = "goodSelect", required = true) String goodSelect) {
		mLogger.info(shopName + goodId + goodName + goodDesc + goodPrice);
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		DiskFileItemFactory fac = new DiskFileItemFactory();
        // 文件上传核心类对象
		
        ServletFileUpload upload = new ServletFileUpload(fac);
        String name = "";
        try {
            // 把请求数据封装为 List<FileItem>
            List<FileItem> list = upload.parseRequest(req);
            // 遍历，所有的上传文件项
            for (FileItem item : list) {
 
                // 普通文本项
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();// 普通文本，名称
                    String value = item.getString(); // 文本名称，对应的值
                    System.out.println(fieldName + ":" + value);
                } 
                 
                // 上传文件项
                else {
                    name = item.getName();    // 上传文件名称a.txt,或文件路径(IE)
                    String fieldName = item.getFieldName();// 文件域的名称
                    //String value = item.getString();    // 上传文件内容
                    String type = item.getContentType(); // 文件类型
                    InputStream in = item.getInputStream(); // 上传文件文件流
                     
                    // 上传到upload目录
//                    String basePath = "D:/360";
                    String basePath = "/home/ftpadmin/www/image/main";
                    System.out.println(basePath);
                    
                    // 上传文件
                    name = goodId + "." + name.split("\\.")[1];
                    mLogger.info("name--------------" + name);
                    System.out.println(name);
                    FileOutputStream out = new FileOutputStream(new File(basePath,name));
                    byte[] b = new byte[1024];
                    int len = -1;
                    while ((len = in.read(b))!= -1) {
                        out.write(b, 0, len);
                    }
                    // 关闭
                    out.close();
                    in.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String path = "/home/ftpadmin/www/image/main/" + name;
        try {
			Runtime.getRuntime().exec("chmod 644 " + path);
		} catch (IOException e) {
			e.printStackTrace();
		}  
		int code1 = shopService.create(shopName, shopId);
		int code2 = goodService.create(goodId, catg1, catg2, shopId, goodName, 0, goodDesc, goodPrice.trim(), goodSelect);
		int code3 = imageService.create(goodId, "main", path);
		return "redirect:/index.jsp";
    }	
}
