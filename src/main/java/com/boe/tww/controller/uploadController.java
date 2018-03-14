package com.boe.tww.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 唐万万
 * @create 2018-03-14 10:22
 */
@Controller
public class uploadController {
    /**
     * 跳转到upload页面
     * @return
     */
    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    /**
     * 上传单个文件
     * @param request
     * @param file
     * @return
     */
    @PostMapping("/uploadFile")
    public @ResponseBody String upload(HttpServletRequest request, MultipartFile file) {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //获取文件后缀名
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            //上传文件名 通过uuid保存文件名
            String filename = UUID.randomUUID()+suffix;

            ////上传文件名
            //String filename = file.getOriginalFilename();
            //服务器端保存的文件对象
            File serverFile = new File(uploadDir + filename);
            //将上传的文件写入到服务器端文件内
            file.transferTo(serverFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    /**
     * 上传多个文件
     * @param request
     * @param file
     * @return
     */
    @PostMapping("/uploadFileMore")
    public @ResponseBody String uploads(HttpServletRequest request,MultipartFile[] file) {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //遍历文件数组执行上传
            for(int i = 0; i<file.length; i++) {
                if (file[i] != null&&file[i].getSize()>0) {
                    //调用上传方法
                    executeUpload(uploadDir, file[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    private void executeUpload(String uploadDir, MultipartFile file) throws  Exception{
        //获取文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名 通过uuid保存文件名
        String filename = UUID.randomUUID()+suffix;

        ////上传文件名
        //String filename = file.getOriginalFilename();
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }
}
