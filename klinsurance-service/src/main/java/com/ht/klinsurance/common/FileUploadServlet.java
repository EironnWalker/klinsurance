package com.ht.klinsurance.common;

import com.ht.common.utils.DateUtils;
import com.ht.common.utils.UUIDGenerate;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * 文件上传用到的action
 */

public class FileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String path;

    public FileUploadServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        // 创建文件项目工厂对象
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // 设置文件上传路径(upload/pic)
        String upload = request.getSession().getServletContext().getRealPath("/")+"/upload/"+KlConsts.BASE_DIR_PIC;
        //日起文件夹
        String dateFolder = DateUtils.format(new Date(), "yyyyMMdd");
        //文件名称
        String name = UUIDGenerate.generate();
        File file = new File(upload);
        if(!file.exists() && !file .isDirectory())
        {
            file.mkdir();
        }
        upload = upload+"/"+dateFolder;
        file  = new File(upload);
        if(!file.exists() && !file .isDirectory())
        {
            file.mkdir();
        }
        // 获取系统默认的临时文件保存路径，该路径为Tomcat根目录下的temp文件夹
        String temp = System.getProperty("java.io.tmpdir");
        // 设置缓冲区大小为 5M
        factory.setSizeThreshold(1024 * 1024 * 5);
        // 设置临时文件夹为temp
        factory.setRepository(new File(temp));
        // 用工厂实例化上传组件,ServletFileUpload 用来解析文件上传请求
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

        // 解析结果放在List中
        try {
            List<FileItem> list = servletFileUpload.parseRequest(request);

            for (FileItem item : list) {

                InputStream is = item.getInputStream();
                    try {
                    path = upload+"\\"+name+".jpg";
                    inputStream2File(is, path);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
            out.write("/"+KlConsts.BASE_DIR_PIC+"/"+dateFolder+"/"+name+".jpg");  //这里我把服务端成功后，返回给客户端的是上传成功后路径
        } catch (FileUploadException e) {
            e.printStackTrace();
            System.out.println("failure");
            out.write("failure");
        }

        out.flush();
        out.close();
    }
    // 流转化成字符串
    public static String inputStream2String(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = -1;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }

    // 流转化成文件
    public static void inputStream2File(InputStream is, String savePath) throws Exception {
        System.out.println("文件保存路径为:" + savePath);
        File file = new File(savePath);
        InputStream inputSteam = is;
        BufferedInputStream fis = new BufferedInputStream(inputSteam);
        FileOutputStream fos = new FileOutputStream(file);
        int f;
        while ((f = fis.read()) != -1) {
            fos.write(f);
        }
        fos.flush();
        fos.close();
        fis.close();
        inputSteam.close();

    }
}
