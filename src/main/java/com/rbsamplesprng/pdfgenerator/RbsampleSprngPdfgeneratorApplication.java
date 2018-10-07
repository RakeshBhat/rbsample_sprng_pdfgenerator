package com.rbsamplesprng.pdfgenerator;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rbsamplesprng.pdfgenerator.fx.view.MainView;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;

/**
 * 
 * @author Rakesh Bhat
 *
 */

@SpringBootApplication
public class RbsampleSprngPdfgeneratorApplication extends AbstractJavaFxApplicationSupport {

	public static void main(String[] args) {
		launch(RbsampleSprngPdfgeneratorApplication.class, MainView.class, args);
	}
}
