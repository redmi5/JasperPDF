import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PDF {

    public void generatePDF(int firstPage, int  secondPage, int thirdPage) throws JRException {

        ArrayList<Integer> listOfPage=new ArrayList<Integer>();
        listOfPage.add(firstPage);
        listOfPage.add(secondPage);
        listOfPage.add(thirdPage);

        JRPdfExporter exp = new JRPdfExporter();
        List<Object> list = new ArrayList<Object>();

        String pathImage=this.getClass().getResource("imageBulleten.jpg").getPath();
        JasperReport jasperReport = JasperCompileManager
                .compileReport(this.getClass().getResource("bulletin.jrxml").getPath());

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("document.number", "ZR6457659574");
        parameters.put("voting.type", "заочного");
        parameters.put("voting.form", " годовом");
        parameters.put("image.bulleten",pathImage);
        parameters.put("organization.name","АО 'БАНК АСТАНЫ'");
        parameters.put("voting.initiator","Cовет директоров акционерного общества");
        parameters.put("voting.endDate","05 июня 2016 года");
        parameters.put("organization.address","05 июня 2016 года");
        parameters.put("voting.startDate","06 июня 2016 года");
        parameters.put("voter.name","ТОО Транс строй монтаж");
        parameters.put("voter.totalShares","1000060 штук");
        parameters.put("question.number","01");
        parameters.put("question.text","Утверждение годовой финансовой отчетности АО 'Банк Астаны' за 2015 г");

        JRDataSource dataSource = new JREmptyDataSource();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                parameters, dataSource);



        JasperReport jasperReport2 = JasperCompileManager
                .compileReport(this.getClass().getResource("question_simple.jrxml").getPath());

        Map<String, Object> parameters2 = new HashMap<String, Object>();
        parameters2.put("image.bulleten",pathImage);
        parameters2.put("question.number","01");
        parameters2.put("decision.comments","Очень хороший и своевременный опрос. Голосую двумя  руками");
        parameters2.put("voter.name","ТОО  Транс строй монтаж");
        parameters2.put("decision.count","100557");
        parameters2.put("voter.childVoter.name","Иванов Иван иванович");
        parameters2.put("voter.iin","747454767");
        parameters2.put("voter.documentNumber","5695689");
        parameters2.put("voter.documentDate","12.12.2012");
        parameters2.put("voter.documentIssuer","МВД РК");
        parameters2.put("proxyCard.number","333");
        parameters2.put("proxyCard.date","19 декабря 2017 года");
        parameters2.put("document.hash","Цифровая подпись");
        parameters2.put("document.number","01");
        parameters2.put("question.from","X");
        parameters2.put("question.against","");
        parameters2.put("question.notanswer","");
        parameters2.put("question.text","Утверждение годовой финансовой отчетности  АО Банк Астаны за 2015 год");
        parameters2.put("question.description","Утвердить годовую финансовую отчетность Банка за 2015 год");

        JRDataSource dataSource2 = new JREmptyDataSource();
        JasperPrint jasperPrint2 = JasperFillManager.fillReport(jasperReport2,
                parameters2, dataSource2);

        JasperReport jasperReport3 = JasperCompileManager
                .compileReport(this.getClass().getResource("question_comulative.jrxml").getPath());

        Map<String, Object> parameters3 = new HashMap<String, Object>();
        parameters3.put("image.bulleten",pathImage);
        parameters3.put("question.number","01");
        parameters3.put("answer.serialNumber","1");
        parameters3.put("answer.text","Иван Иванов");
        parameters3.put("answer.score","10000");
        parameters3.put("decision.comments","Очень хороший совет директоров");
        parameters3.put("voter.name","ТОО ТРАНС СТРОЙ МОНТАЖ");
        parameters3.put("decision.count","100006");
        parameters3.put("voter.childVoter.name","Иванов Иван Иванович");
        parameters3.put("voter.iin","4534534534");
        parameters3.put("voter.documentNumber","4564564");
        parameters3.put("voter.documentDate","12.12.2012");
        parameters3.put("voter.documentIssuer","MBD РК");
        parameters3.put("proxyCard.number","333");
        parameters3.put("proxyCard.date","19 декабря 2017 год");
        parameters3.put("document.hash","Цифровая подпись");
        parameters3.put("document.number","01");
        parameters3.put("question.text","Об избрании членов Совета директоров АО Банк Астаны");
        parameters3.put("question.count","3");

        JRDataSource dataSource3 = new JREmptyDataSource();

        JasperPrint jasperPrint3 = JasperFillManager.fillReport(jasperReport3,
                parameters3, dataSource3);
        list.clear();
        for(int i= 0; i<listOfPage.size();i++) {

            switch (listOfPage.get(i)) {
                case 1:
                    list.add(jasperPrint);
                    break;
                case 2:
                    list.add(jasperPrint2);
                    break;
                case 3:
                    list.add(jasperPrint3);
                    break;
                default:
                    break;
            }
        }

        File outDir = new File("C:/jasperoutput");
        outDir.mkdirs();
        exp.setParameter(JRPdfExporterParameter.JASPER_PRINT_LIST, list);

        exp.setParameter(JRPdfExporterParameter.OUTPUT_FILE, new File("C:/jasperoutput/test.pdf"));
        exp.exportReport();
        System.out.println("done!");




    }


}
