package com.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;

public class TakeScreenShots extends TestBase {

	public static void main(String[] args) throws IOException {
		
		// Take sreenshot(.getScreenshotAs method) and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// Now copy the screenshot to desired location using .copyFile method
		FileUtils.copyFile(src, new File("C:\\Users\\User\\Desktop\\eclipse\\TFTonlineStore\\src\\ScreenShots\\TFT.png"));
		
		System.out.println("Screenshots taken");

	}

}
