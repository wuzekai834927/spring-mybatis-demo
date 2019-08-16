package com.wuzekai.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wuzekai.baiduapi.AdvancedGeneral;
import com.wuzekai.vo.GarbageInfoVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("fileUpAndDown")
public class FileUpAndDownController {

    @RequestMapping("fileUploadController")
    @ResponseBody
    public String fileUploadController(@RequestParam("m416") CommonsMultipartFile akm) throws IOException {

        //创建一个新文件
        File destFile = new File("D:\\" + new Date().getTime() + akm.getOriginalFilename());

        //将file中的内容通过transferTo方法保存到新文件中
        akm.transferTo(destFile);

        return "upload success (上传成功)";
    }


    @RequestMapping("testDownLoad")
    public ResponseEntity<byte[]> testDownLoad(@RequestParam(required = false,value = "fileName")String mk14) throws Exception {
        //创建文件
        File awm = new File("d://"+mk14);

        if(!awm.exists()){
            throw new FileNotFoundException("无法找到文件"+awm.getAbsolutePath());
        }
        //创建输入流(从硬盘读取数据)
        FileInputStream fis = new FileInputStream(awm);
        //创建字节数组并指定长度
        byte[] bt = new byte[fis.available()];
        //将数据从输入流导到输出流
        fis.read(bt);

        //定义一个响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename="+mk14);

        //设置HTTP响应状态
        //int status = 200;
        HttpStatus statusCode = HttpStatus.OK;
        //创建响应实体对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bt, headers, statusCode);

        return responseEntity;
    }


    //dropzone 上传文件
    @RequestMapping("upload")
    @ResponseBody
    public Map<String,Object> upload(MultipartFile dropzFile , HttpServletRequest request){
        //System.out.println("inner upload");
        Map<String,Object> result = new HashMap<String,Object>();

        //创建文件需要存储的路径(设置文件上传路径)
        String destPathName = request.getSession().getServletContext().getRealPath("/static/upload");
        File destPath = new File(destPathName);
        //如果目标文件夹不存在 那就创建一个
        if(!destPath.exists()){
            destPath.mkdirs();
        }

        //获取上传的原始文件名
        String fileName = dropzFile.getOriginalFilename();
        //获取文件后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        //通过UUID设置新的文件名 确保唯一
        String destFileName = UUID.randomUUID()+fileSuffix;
        //System.out.println(destFileName);
        //创建一个名为destFileName在文件夹destPath 下的文件路径
        File destFile = new File(destPath,destFileName);
        //如果目标文件不存在 就创建一个
        if(!destFile.exists()){
            try {
                destFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写入文件
        try {
            dropzFile.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.put("status",200);

        result.put("filePath","http://localhost:8080/spring_mybatis_demo/static/upload/"+destFileName);
        return result;
    }

//    @RequestMapping("upload")
//    @ResponseBody
//    public Map<String,Object> upload(MultipartFile dropzFile, HttpServletRequest request){
//        Map<String, Object> result = new HashMap<String, Object>();
//
//        String filePath = request.getSession().getServletContext().getRealPath("/static/upload");
//        File newPath = new File(filePath);
//        if(!newPath.exists()){
//            newPath.mkdirs();
//        }
//
//        String filename = dropzFile.getOriginalFilename();
//        String fileLast = filename.substring(filename.lastIndexOf("."));
//
//        String newName = UUID.randomUUID()+fileLast;
//        File newFilePath = new File(newPath,newName);
//        if(!newFilePath.exists()){
//            try {
//                newFilePath.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        try {
//            dropzFile.transferTo(newFilePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        result.put("status",200);
//        result.put("path","http://localhost:8080/spring_mybatis_demo/static/upload/"+newName);
//        return result;
//    }


    @RequestMapping("garbageDiscernController")
    @ResponseBody
    public Map<String,Object> garbageDiscernController(MultipartFile dropzFile , HttpServletRequest request){
        //System.out.println("inner upload");
        Map<String,Object> result = new HashMap<String,Object>();

        //创建文件需要存储的路径(设置文件上传路径)
        String destPathName = request.getSession().getServletContext().getRealPath("/static/upload");
        File destPath = new File(destPathName);
        //如果目标文件夹不存在 那就创建一个
        if(!destPath.exists()){
            destPath.mkdirs();
        }

        //获取上传的原始文件名
        String fileName = dropzFile.getOriginalFilename();
        //获取文件后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        //通过UUID设置新的文件名 确保唯一
        String destFileName = UUID.randomUUID()+fileSuffix;
        //System.out.println(destFileName);
        //创建一个名为destFileName在文件夹destPath 下的文件路径
        File destFile = new File(destPath,destFileName);
        //如果目标文件不存在 就创建一个
        if(!destFile.exists()){
            try {
                destFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写入文件
        try {
            dropzFile.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String resultStr = AdvancedGeneral.advancedGeneral(destFile.getAbsolutePath());
        //调用百度接口然后获取回传值
        result.put("status",200);
        //将json字符串转对象
        Gson gson = new Gson();
        Object o = gson.fromJson(resultStr, new TypeToken<GarbageInfoVO>() {
        }.getType());
        result.put("resultObj",o);
        result.put("filePath","http://localhost:8080/spring_mybatis_demo/static/upload/"+destFileName);
        return result;
    }


    //wangeditor
    static String UPLOAD_PATH = "/static/upload/";
    @ResponseBody
    @RequestMapping(value = "upload1", method = RequestMethod.POST)
    public Map<String, Object> upload1(MultipartFile editorFile, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();

        // 获取文件后缀
        String fileName = editorFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        // 文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        InetAddress ia=null;
        try {
            ia = ia.getLocalHost();
            System.out.println(ia.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // 判断路径是否存在，不存在则创建文件夹
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }

        // 将文件写入目标
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        try {
            editorFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取服务端路径
        String serverPath = String.format("%s://%s:%s%s%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), UPLOAD_PATH);
        System.out.println(serverPath);
        // 返回给 wangEditor 的数据格式
        result.put("errno", 0);
        result.put("data", new String[]{serverPath + file.getName()});
        return result;
    }

}
