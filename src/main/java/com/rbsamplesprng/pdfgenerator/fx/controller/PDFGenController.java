package com.rbsamplesprng.pdfgenerator.fx.controller;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.itextpdf.text.DocumentException;
import com.rbsamplesprng.pdfgenerator.service.GeneratePDF;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@FXMLController
public class PDFGenController {

	@FXML private TextField unitName;
	@FXML private TextField unitSize;
	
	public void onButtonClick(final ActionEvent e){
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(new GenPdf());
	}
	
	public class GenPdf implements Runnable{

		@Override
		public void run() {
			generatePDF(unitSize.getText(), unitName.getText());
		}		
	}
	
	public void generatePDF(String us, String un){
		GeneratePDF genpdf = new GeneratePDF();
		String unit = us+":"+un.toUpperCase();
		long sz = (long) genpdf.parse(unit);
		
		try{
			String fname = un + us + ".pdf";
			genpdf.genPdf(fname, sz);
		}catch(DocumentException | IOException e){
			e.printStackTrace();
		}
	}
}
