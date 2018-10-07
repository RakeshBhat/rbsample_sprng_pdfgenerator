package com.rbsamplesprng.pdfgenerator.fx.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.rbsamplesprng.pdfgenerator.fx.view.PDFConverterView;
import com.rbsamplesprng.pdfgenerator.fx.view.PDFGenView;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

@FXMLController
public class MainController {

	@FXML
	Pane mainPane;
	
	@Autowired
	PDFGenView pdfGenView;
	
	@Autowired
	PDFConverterView pdfConverterView;
	
	public void showPDFGenView(final Event e){
		mainPane.getChildren().clear();
		mainPane.getChildren().add(pdfGenView.getView());
	}
	
	public void showPDFConverterView(final Event e){
		mainPane.getChildren().clear();
		mainPane.getChildren().add(pdfConverterView.getView());
	}
}
