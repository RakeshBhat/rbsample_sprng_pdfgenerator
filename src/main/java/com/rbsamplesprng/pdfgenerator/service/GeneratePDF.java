package com.rbsamplesprng.pdfgenerator.service;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF {

	private final static long KB_FACTOR = 1000;
	private final static long KIB_FACTOR = 1024;
	private final static long MB_FACTOR = 1000 * KB_FACTOR;
	private final static long MIB_FACTOR = 1024 * KIB_FACTOR;
	private final static long GB_FACTOR = 1000 * MB_FACTOR;
	private final static long GIB_FACTOR = 1024 * MIB_FACTOR;

	public double parse(String u) {
		int spaceNdx = u.indexOf(":");
		double ret = Long.parseLong(u.substring(0, spaceNdx));
		switch (u.substring(spaceNdx + 1)) {
		case "GB":
			return ret * GB_FACTOR;
		case "GiB":
			return ret * GIB_FACTOR;
		case "MB":
			return ret * MB_FACTOR;
		case "MiB":
			return ret * MIB_FACTOR;
		case "KB":
			return ret * KB_FACTOR;
		case "KiB":
			return ret * KIB_FACTOR;
		}
		return -1;
	}

	public void genPdf(String f, long sz) throws DocumentException, IOException{
		
        Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();
		document.setMarginMirroring(true);
		document.setMargins(36, 72, 108, 180);
		document.topMargin();

		BaseFont courier = BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1252, BaseFont.EMBEDDED);
		Font myfont = new Font(courier);
		Font bold_font = new Font();
		bold_font.setStyle(Font.BOLD);
		bold_font.setSize(10);
		myfont.setStyle(Font.NORMAL);
		myfont.setSize(9);

		document.add(new Paragraph("\n"));
		document.add(new Paragraph("PDF title: Live Life Full", myfont));
		String strLine = "Enjoy!!";
        int so = writer.getCurrentDocumentSize();

		do  {
						
			document.add(new Paragraph("Its auto Generated PDF!"));

			Paragraph para = new Paragraph(strLine + "\n", myfont);
			para.setAlignment(Element.ALIGN_JUSTIFIED);

			document.add(para);
			
			so = writer.getCurrentDocumentSize();
		}while( so <= sz);		

		document.add(new Paragraph("owned by Rakesh Bhat", myfont));
		
		document.close();
	}

}
