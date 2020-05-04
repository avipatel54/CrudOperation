package com.Utilities;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.luv2code.springboot.cruddemo.entity.Employee;

public class PdfGen {
	public void generatePdf(List<Employee> theEmployees){
		Document report = new Document(PageSize.A3);
        report.addAuthor("Avi Patel");
        report.addTitle("Employee Attendance  Management System");        
        try{
            PdfWriter.getInstance(report, new FileOutputStream("E:\\generated1.pdf"));
            report.open();            
            Paragraph para = new Paragraph("");                      
            para.setIndentationLeft(20);
            para.setIndentationRight(10);
            para.setAlignment(Paragraph.ALIGN_CENTER);
            PdfPTable table = new PdfPTable(3);                                   
            table.addCell(new PdfPCell(new Paragraph("First name",new Font(Font.getFamily("Segoe UI"), 17.5f,Font.ITALIC))));
            table.addCell(new PdfPCell(new Paragraph("Last name",new Font(Font.getFamily("Segoe UI"), 17.5f,Font.ITALIC))));
            table.addCell(new PdfPCell(new Paragraph("Email",new Font(Font.getFamily("Segoe UI"), 17.5f,Font.ITALIC))));
            for (Employee employee : theEmployees) {
    			table.addCell(new PdfPCell(new Paragraph(employee.getFirstName()+"\n",new Font(Font.getFamily("Segoe UI"), 17.5f,Font.BOLD))));
    			table.addCell(new PdfPCell(new Paragraph(employee.getLastName()+"\n",new Font(Font.getFamily("Segoe UI"), 17.5f,Font.BOLD))));
    			table.addCell(new PdfPCell(new Paragraph(employee.getEmail()+"\n",new Font(Font.getFamily("Segoe UI"), 17.5f,Font.BOLD))));
    		}                                                       
            para.add(table);
            report.add(para);
          
        }catch(Exception e){}
        report.close(); 
    }
}
