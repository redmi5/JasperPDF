import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.view.JasperViewer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws JRException {
       // int fisrst= Integer.parseInt(args[0]);
       // int second=Integer.parseInt(args[1]);
        //int third=Integer.parseInt(args[2]);
        int first= 1;
        int second=2;
        int third=3;
        new PDF().generatePDF(first,second,third);
    }
}
