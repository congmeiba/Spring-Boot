package cn.gzsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用RestController 注解 这个类的方法返回都是json格式数据,则不用再方法上加RESPONSTBODY
 */

@RestController
public class UploadImgController {

    /**
     * spring boot 帮我们得上传文件大小设置到10M
     *
     * 我们可以自己手动配置更大的上传文件大小
     *
     * 在resources下创建一个application.properties文件
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadImg")
    public Map<String,Object> up(@RequestParam("image") MultipartFile file){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name",file.getOriginalFilename());
        map.put("type",file.getContentType());

        try {
            file.transferTo(new File("E:/"+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return map;
    }

}
