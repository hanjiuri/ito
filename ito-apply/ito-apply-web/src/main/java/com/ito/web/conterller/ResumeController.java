package com.ito.web.conterller;

import com.ito.domain.Resume;
import com.ito.utils.OfficeUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.xmlbeans.XmlException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by 韩九日 on 2017/6/23.
 */

@Controller
@RequestMapping("/resume")
public class ResumeController {
    OfficeUtils officeUtils = new OfficeUtils();
    @RequestMapping("/upload")
    //上传文件到服务器
    //前台传入word文档，后台解析文档，并将数据返回前台；
    public String uploadFile(Resume resume, HttpServletRequest request) throws Exception {
        if(!resume.getR_name().equals("")&&
                !resume.getR_sex().equals("")&&
                resume.getR_resume().getSize()!=0&&
                !resume.getR_resume().getOriginalFilename().equals("")){
            String tempPath = request.getSession().getServletContext().getRealPath("/upload");//文件上传路径
            File files = new File(tempPath); //文件对象
            if (!files.isDirectory()) { //判断文件夹是否存在
                files.mkdirs(); //产生文件夹
            }
            //服务器路径
            try {
                resume.getR_resume().transferTo(new File(tempPath+"/" + resume.getR_resume().getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            throw new Exception("");
        }
        return "ddd";
        }
    //解析word文档
    @ResponseBody
    @RequestMapping("/word")
    public String getTextFromWord(HttpServletRequest request, HttpServletResponse response) throws IOException, OpenXML4JException, XmlException {
        String path = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(path);
        String result = null;
        result = officeUtils.getTextFromWord(path + "/" + "韩旭- Java2.doc");
        /*设置字符集为'UTF-8'*/
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        return result;
    }
    /**
     *
     * @Title: getTextFromPdf
     * @Description: 读取pdf文件内容
     * @return: 读出的pdf的内容
     */
    @ResponseBody
    @RequestMapping("/pdf")
    public String getTextFromPdf(HttpServletRequest request, HttpServletResponse response) {
        String result = null;
        String path = request.getSession().getServletContext().getRealPath("/upload");
        PDDocument helloDocument = null;
        try {
            result = officeUtils.getTextFromPdf(path + "/" + "nvidia-smi.1.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        return result;
    }
    @ResponseBody
    @RequestMapping("/excel")
    public String getTextFromExcel(HttpServletRequest request, HttpServletResponse response) {
        String result = null;
        String path = request.getSession().getServletContext().getRealPath("/upload");
        try {
            result = officeUtils.getTextFromExcel(path + "/" + "新建 Microsoft Excel 工作表.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        return result;
    }
    @RequestMapping("image")
    public String getImage(HttpServletRequest request, Model model){
        String path = request.getSession().getServletContext().getRealPath("/upload");
        model.addAttribute("path",path);
        return "sss";
    }
}
