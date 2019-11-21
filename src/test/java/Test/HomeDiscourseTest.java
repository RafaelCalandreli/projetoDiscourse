package Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.HomeDiscoursePage;
import suport.Library;

public class HomeDiscourseTest {

	public WebDriver driver;
	private Library lib;
	private WebDriverWait wait;
	private String idTC;
	private HomeDiscoursePage page;

	@Before
	public void setupBeforeTest() {
		inicializacaoComponentes();
	}

	private void inicializacaoComponentes() {
		this.lib = new Library();
		this.driver = lib.getDriver();
		this.lib.acessar("https://www.discourse.org/");
		this.wait = lib.getWait();
		this.driver.manage().deleteAllCookies();
		this.driver.manage().window().maximize();
		this.page = new HomeDiscoursePage(driver, lib, wait, idTC);
	}

	@After
	public void setupAfterTest() {
		driver.quit();
	}

	@Test
	public void teste() throws InterruptedException {

		page.acessarPagina();
		page.buscarElementos();
	}

	

}
