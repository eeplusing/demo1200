package com.eplusing.demo1200.base.util;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class PdfUtil {
    public static void main(String[] args) {
        new PdfUtil().generatePDFFile();
    }

    /**
     * 生成PDF文件
     *
     * @return
     */
    public byte[] generatePDFFile() {
        Map<String, String> pdfParams = new HashMap<>();
        pdfParams.put("bankName", "中国银行");
        pdfParams.put("tradeDate", "2022-09-08");
        pdfParams.put("phoneNumber", "13715268888");
        pdfParams.put("accountName", "时间的朋友");
        pdfParams.put("contractDate", "2022-09-08");
        pdfParams.put("accountNo", "65218888123456789");
        pdfParams.put("productName", "欧创发张基金");
        pdfParams.put("currency", "CNY");
        pdfParams.put("shareClasses", "10000.123456");
        pdfParams.put("isinCode", "CNY123456789");
        pdfParams.put("subscriptionAmount", "123456789.123456");
        pdfParams.put("quantity", "10000.123456");

        String pdfTemplate = this.getClass().getClassLoader().getResource("template/pdf_template.pdf").getPath();

        PdfReader reader = null;
        ByteArrayOutputStream bos = null;
        try {
            reader = new PdfReader(pdfTemplate);
            bos = new ByteArrayOutputStream();
            PdfStamper ps = new PdfStamper(reader, bos);
            AcroFields s = ps.getAcroFields();
            //使用中文字体 使用 AcroFields填充值的不需要在程序中设置字体，在模板文件中设置字体为中文字体 Adobe 宋体 std L
            String font = this.getClass().getClassLoader().getResource("fonts/front.ttf").getPath();
            BaseFont bfChinese = BaseFont.createFont(font, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            //设置编码格式
            s.addSubstitutionFont(bfChinese);
            // 遍历data 给pdf表单表格赋值
            for (Map.Entry<String, String> entry : pdfParams.entrySet()) {
                s.setField(entry.getKey(), entry.getValue());
            }
            // 如果为false,那么生成的PDF文件还能编辑，一定要设为true
            ps.setFormFlattening(true);
            // 一定要先关掉流. 后面才能写出来
            ps.close();
            //生成 byte数组
            byte[] bytes = bos.toByteArray();
            String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
            System.out.println(path);

            FileOutputStream fileOutputStream = new FileOutputStream("target.pdf");
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();

            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return null;
    }


    private void fillStaticPdf(String templateFilePath, String resultFilePath, Map<String, String> data) throws Exception {

        if (StringUtils.isEmpty(templateFilePath) || StringUtils.isEmpty(resultFilePath) || data == null) {
            System.out.println("[fillStaticPdf]params is empty");
            throw new Exception("eeee");
        }

        PdfReader reader = null;
        PdfStamper stamper = null;
        try {
            reader = new PdfReader(templateFilePath);
            stamper = new PdfStamper(reader, new FileOutputStream(resultFilePath));
            AcroFields acroFields = stamper.getAcroFields();

            //中文字体
            BaseFont font = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);

            //静态赋值
            for (Map.Entry<String, String> d : data.entrySet()) {
                acroFields.setFieldProperty(d.getKey(), "textfont", font, null);
                acroFields.setField(d.getKey(), d.getValue(), true);
            }

            //设置pdf为只读
            stamper.setFormFlattening(true);
        } catch (DocumentException e) {
            System.out.println("[fillStaticPdf]-文件异常!");
            throw new Exception("eeee");
        } catch (IOException e) {
            System.out.println("[fillStaticPdf]-生成PDF时IOException异常!");
            throw new Exception("eeee");
        } finally {
            if (stamper != null) {
                try {
                    stamper.close();
                } catch (Exception e) {
                    System.out.println("关闭stamper时遇到错误!");
                }
            }
            if (reader != null) {
                reader.close();
            }
        }
    }

}
