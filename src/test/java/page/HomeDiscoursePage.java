package page;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import suport.Library;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

public class HomeDiscoursePage {

	public WebDriver driver;
	private Library lib;
	private WebDriverWait wait;
	private String idTC;

	public HomeDiscoursePage(WebDriver driver, Library lib, WebDriverWait wait, String idTC) {
		super();
		this.driver = driver;
		this.lib = lib;
		this.wait = wait;
		this.idTC = idTC;
	}

	public void preencherCidade(String cidade) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("querytext")));
		driver.findElement(By.id("querytext")).sendKeys(cidade);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggestion-59274/200")));
		driver.findElement(By.id("suggestion-59274/200")).click();
	}

	public void selecionarQuartoIndividual() {
		driver.findElement(By.xpath("//*[@id=\"js-fullscreen-hero\"]/div[1]/div[2]/button[1]/span/span[2]/span[2]"))
				.click();
	}

	public void clicarPesquisar() {
		driver.findElement(By.className("search-button")).click();
	}

	public void OrdenarPorDistancia() throws InterruptedException {
		lib.selectCombobox("mf-select-sortby", "Distância e sugestões");
	}

	public void exibirPrimeiroItemLista() {

	}

	public void aguardarScroll() throws InterruptedException {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("scroll(0, 500);");
		Thread.sleep(5000);

	}

	public void acessarPagina() throws InterruptedException {
		driver.findElement(By.linkText("Demo")).click();
		Thread.sleep(500);
	}

	public void buscarElementos() {
		List<WebElement> elementList = driver.findElements(By.xpath("//*[@id='list-area']/div/table/tbody/tr"));

		List<String> listaElementosString = new ArrayList<String>();
		for (WebElement e : elementList) {
			listaElementosString.add(e.getText());
		}
		String texto[] = listaElementosString.get(0).split("\n");

		System.out.println(texto[2]);
	}

}
