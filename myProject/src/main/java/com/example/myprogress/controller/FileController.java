package com.example.myprogress.controller;
import com.example.myprogress.domain.filedownload;
import com.example.myprogress.domain.fileinfo;
import com.example.myprogress.repository.filedownRepository;
import com.example.myprogress.repository.fileinfoRepository;
import com.example.myprogress.utils.time;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;
/**
 * 文件管理控制类
 */
@Controller
public class FileController {
    // 向文件上传页面跳转
    @GetMapping("/toUpload")
    public String toUpload(){
        return "upload";
    }

    @Autowired
    private fileinfoRepository up;
    @Autowired
    private filedownRepository dp;
    @Autowired
    private time ut;

    // 文件上传管理
    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile[] fileUpload, Model model) throws UnknownHostException {
        // 默认文件上传成功，并返回状态信息
        model.addAttribute("uploadStatus", "上传成功！");
        for (MultipartFile file : fileUpload) {
            // 获取文件名以及后缀名
            String fileName = file.getOriginalFilename();
            // 指定上传文件本地存储目录，不存在需要提前创建
            String dirPath = "D:/file/";
            File filePath = new File(dirPath);
            //时间
            String time=ut.getTime();
            //获取ip
            InetAddress ar = InetAddress.getLocalHost();
            String ip = ar.getHostAddress();
            // 获取文件大小
            String filesize = ut.modifyCompany(file.getSize());
            // 获取文件后缀
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
            if(!filePath.exists()){
                filePath.mkdirs();
            }
            try {
                file.transferTo(new File(dirPath+fileName));
            } catch (Exception e) {
                e.printStackTrace();
                // 上传失败，返回失败信息
                model.addAttribute("uploadStatus","上传失败： "+e.getMessage());
            }
            up.insertfile(fileName,time,fileType,ip,filesize);
        }
        // 携带上传状态信息回调到文件上传页面
        return "upload";
    }

    // 向文件下载页面跳转
    @GetMapping("/toDownload")
    public String toDownload(Model model){
        //先查询上传数据
        List<fileinfo> query = up.select();
        model.addAttribute("fileinfo",query);
        return "download";
    }
    // 所有类型文件下载管理
    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request, HttpServletResponse response,
                                               String filename) throws Exception{
        // 指定要下载的文件根路径
        String dirPath = "D:/file/";
        // 创建该文件对象
        File file = new File(dirPath + File.separator + filename);
        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        // 获取文件IP
        InetAddress address = InetAddress.getLocalHost();
        String ip = address.getHostAddress();
        // 时间
        String downtime = ut.getTime();
        dp.addfileinfo(filename, ip, downtime);
        // 通知浏览器以下载方式打开（下载前对文件名进行转码）
        filename=getFilename(request,filename);
        headers.setContentDispositionFormData("attachment",filename);
        // 定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        try {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    // 根据浏览器的不同进行编码设置，返回编码后的文件名
    private String getFilename(HttpServletRequest res, String filename) throws UnsupportedEncodingException {
        String[] IEBrowserKeyWords = { "MSIE", "Trident", "Edge" };
        String header = res.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWords) {
            if (header.contains(keyWord)) {
                return URLEncoder.encode(filename, "UTF-8").replace("+", " ");
            }
        }
        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }

    // 显示上传信息
    @GetMapping("/List")
    public String list( Model model) {
        List<fileinfo> select = up.select();
        model.addAttribute("fileinfo",select);
        return "list";
    }


    // 显示下载信息
    @GetMapping("/downlist")
    public String downlist(Model model) {
        List<filedownload> query = dp.query();
        model.addAttribute("filedownload",query);
        return "downlist";
    }

    //删除
    @GetMapping("/deleteFile")
    public String deleteFile(String filename,Model model){
        String dirPath = "D:/file/";
        File file = new File(dirPath + File.separator + filename);
        file.delete();
        up.deleteById(up.findByFilename(filename));
        model.addAttribute("deleteStatus","删除成功");
        model.addAttribute("list",up.findAll());
        List<fileinfo> select = up.select();
        model.addAttribute("fileinfo",select);
        return "list";
    }
}

