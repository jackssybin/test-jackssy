package com.qding.test.xmltransfer;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

public class XmlToTtransferTest {

    public static void main(String[] args) throws DocumentException, UnsupportedEncodingException {
//        1.将字符串转化为XML
        String text = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><out><head><Version>1.0.1</Version><InstId>888000000000020</InstId><AnsTranCode>BJCEBQBIRes</AnsTranCode><TrmSeqNum>n20181017135138-4I5xmT</TrmSeqNum></head><tout><billKey>104704</billKey><companyId>022006802</companyId><item1>282839</item1><item2></item2><item3></item3><item4>20181017020103267744</item4><item5></item5><item6></item6><item7></item7><totalNum></totalNum><Data><contractNo>104704</contractNo><customerName>侯小晶</customerName><balance>0</balance><payAmount>1050</payAmount><beginDate>2018-10-11</beginDate><endDate>2018-11-30</endDate><filed1></filed1><filed2></filed2><filed3></filed3><filed4>光大测试192</filed4><filed5>60019215392502364771</filed5></Data></tout></out>";
        Document document = DocumentHelper.parseText(text);
//        2.将文档或节点的XML转化为字符串.
        SAXReader reader = new SAXReader();
//        Document   document = reader.read(new File("csdn.xml"));
        Element root=document.getRootElement();
//        String docXmlText=document.asXML();
        String docXmlText=formatXML(document,"utf-8");
        System.out.println(docXmlText);
        System.out.println(new String(document.asXML().getBytes(),"utf-8"));


    }

    public static String formatXML(Document document, String charset) {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding(charset);
        StringWriter sw = new StringWriter();
        XMLWriter xw = new XMLWriter(sw, format);
        try {
            xw.write(document);
            xw.flush();
            xw.close();
        } catch (IOException e) {
//            log.error("格式化XML文档发生异常，请检查！", e);
        }
        return sw.toString();
    }
}
