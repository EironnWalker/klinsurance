package com.ht.klinsurance.common;

import com.ht.klinsurance.briefing.model.BriefingLossImage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.*;
import java.util.*;

/**
 * 处理word工具类
 * @author feicy
 * @date 2016/8/8
 */
public class WordUtils {
    /**
     * 生成word
     * @param ftl 模板名
     * @param path 文件目录
     * @param infoMap 模板里面要替换的信息
     * @param imageInfo 要替换的图片信息
     * @throws Exception
     */
    public static void createWord(String ftl,String path,Map<String,Object> infoMap,Map<String, Object> imageInfo)
            throws Exception{
        String fakeFile=path+"temp.docx";
        String realFile=path+".docx";
        //创建配置实例
        Configuration configuration = new Configuration();

        //设置编码
        configuration.setDefaultEncoding("UTF-8");

        //ftl模板文件统一放至 com.lun.template 包下面
        configuration.setClassForTemplateLoading(WordUtils.class, "/");

        //获取模板
        Template template = configuration.getTemplate(ftl);

        //输出文件
        File outFile = new File(fakeFile);

        //如果输出目标文件夹不存在，则创建
        if (!outFile.getParentFile().getParentFile().getParentFile().exists()) {
            outFile.getParentFile().getParentFile().getParentFile().mkdirs();
        }
        //如果输出目标文件夹不存在，则创建
        if (!outFile.getParentFile().getParentFile().exists()) {
            outFile.getParentFile().getParentFile().mkdirs();
        }
        //如果输出目标文件夹不存在，则创建
        if (!outFile.getParentFile().exists()) {
            outFile.getParentFile().mkdirs();
        }

        //将模板和数据模型合并生成文件
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));

        //生成文件
        template.process(infoMap, out);

        //关闭流
        out.flush();
        out.close();

        //word转存
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(outFile);
        wordMLPackage.save(outFile);

        CustomXWPFDocument doc = WordUtils.generateWord(imageInfo, fakeFile);
        FileOutputStream fopts = new FileOutputStream(realFile);
        doc.write(fopts);
        fopts.close();
        doc.getPackage().close();

        //删除临时文件
        File file = new File(fakeFile);
        if(file.exists()){
            file.delete();
        }
    }
    /**
     * 根据指定的参数值、模板，生成 word 文档
     * @param param 需要替换的变量
     * @param template 模板
     */
    public static CustomXWPFDocument generateWord(Map<String, Object> param, String template) {
        CustomXWPFDocument doc = null;

        try {
            OPCPackage pack = POIXMLDocument.openPackage(template);
            doc = new CustomXWPFDocument(pack);
            if (param != null && param.size() > 0) {

                //处理段落
                List<XWPFParagraph> paragraphList = doc.getParagraphs();
                processParagraphs(paragraphList, param, doc);

                //处理表格
                Iterator<XWPFTable> it = doc.getTablesIterator();
                while (it.hasNext()) {
                    XWPFTable table = it.next();
                    List<XWPFTableRow> rows = table.getRows();
                    for (XWPFTableRow row : rows) {
                        List<XWPFTableCell> cells = row.getTableCells();
                        for (XWPFTableCell cell : cells) {
                            List<XWPFParagraph> paragraphListTable =  cell.getParagraphs();
                            processParagraphs(paragraphListTable, param, doc);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }
    /**
     * 处理段落
     * @param paragraphList
     */
    public static void processParagraphs(List<XWPFParagraph> paragraphList,Map<String, Object> param,CustomXWPFDocument doc){
        if(paragraphList != null && paragraphList.size() > 0){
            for(XWPFParagraph paragraph:paragraphList){
                List<XWPFRun> runs = paragraph.getRuns();
                for (XWPFRun run : runs) {
                    String text = run.getText(0);
                    if(text != null){
                        boolean isSetText = false;
                        for (Map.Entry<String, Object> entry : param.entrySet()) {
                            String key = entry.getKey();
                            if(text.indexOf(key) != -1){
                                isSetText = true;
                                Object value = entry.getValue();
                                if (value instanceof String) {//文本替换
                                    text = text.replace(key, value.toString());
                                } else if (value instanceof Map) {//图片替换
                                    text = text.replace(key, "");
                                    Map pic = (Map)value;
                                    int width = Integer.parseInt(pic.get("width").toString());
                                    int height = Integer.parseInt(pic.get("height").toString());
                                    int picType = getPictureType(pic.get("type").toString());
                                    byte[] byteArray = (byte[]) pic.get("content");
                                    ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteArray);
                                    try {
                                        int ind =doc.addPicture(byteInputStream, picType);
                                        byteInputStream.close();
                                        doc.createPicture(ind, width , height,paragraph);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        if(isSetText){
                            run.setText(text,0);
                        }
                    }
                }
            }
        }
    }
    /**
     * 根据图片类型，取得对应的图片类型代码
     * @param picType
     * @return int
     */
    private static int getPictureType(String picType){
        int res = CustomXWPFDocument.PICTURE_TYPE_PICT;
        if(picType != null){
            if(picType.equalsIgnoreCase("png")){
                res = CustomXWPFDocument.PICTURE_TYPE_PNG;
            }else if(picType.equalsIgnoreCase("dib")){
                res = CustomXWPFDocument.PICTURE_TYPE_DIB;
            }else if(picType.equalsIgnoreCase("emf")){
                res = CustomXWPFDocument.PICTURE_TYPE_EMF;
            }else if(picType.equalsIgnoreCase("jpg") || picType.equalsIgnoreCase("jpeg")){
                res = CustomXWPFDocument.PICTURE_TYPE_JPEG;
            }else if(picType.equalsIgnoreCase("wmf")){
                res = CustomXWPFDocument.PICTURE_TYPE_WMF;
            }
        }
        return res;
    }
    /**
     * 将输入流中的数据写入字节数组
     * @param in
     * @return
     */
    public static byte[] inputStream2ByteArray(InputStream in,boolean isClose){
        byte[] byteArray = new byte[0];
        try {
            byte[] temp = new byte[in.available()];
            int size = 0;
            while ((size = in.read(temp)) != -1) {
                byte[] readBytes = new byte[size];
                System.arraycopy(temp, 0, readBytes, 0, size);
                byteArray = WordUtils.mergeArray(byteArray, readBytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(isClose){
                try {
                    in.close();
                } catch (Exception e2) {
                    System.out.println("关闭流失败");
                }
            }
        }
        return byteArray;
    }
    /***
     * 合并字节数组
     * @param a
     * @return
     */
    public static byte[] mergeArray(byte[]... a) {
        // 合并完之后数组的总长度
        int index = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i].length;
        }
        byte[] result = new byte[sum];
        for (int i = 0; i < a.length; i++) {
            int lengthOne = a[i].length;
            if(lengthOne==0){
                continue;
            }
            // 拷贝数组
            System.arraycopy(a[i], 0, result, index, lengthOne);
            index = index + lengthOne;
        }
        return result;
    }
    /**
     * 拼装替换图片信息
     * @param webPath
     * @param image
     * @return
     * @throws Exception
     */
    public static Map<String,Object> addImageInfo(String webPath,BriefingLossImage image) throws Exception{

        Map<String,Object> header = new HashMap<String, Object>();
        header.put("width", KlConsts.WORD_IMAGE_WIDTH);
        header.put("height", KlConsts.WORD_IMAGE_HEIGHT);
        header.put("type","jpg");
        header.put("content",
                WordUtils.inputStream2ByteArray(new FileInputStream(webPath+"upload"+image.getImage()), true));

        return header;
    }
}
