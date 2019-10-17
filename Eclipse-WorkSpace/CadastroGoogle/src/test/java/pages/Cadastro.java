package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cadastro {
	static WebDriver driver;
	

	public Cadastro(WebDriver driver) {
		this.driver = driver;
	}
	
	public void preencherCampos() {
		WebElement nome = driver.findElement(By.id("firstName"));
		nome.sendKeys("Patrick");
		
		WebElement sobrenome = driver.findElement(By.name("lastName"));
		sobrenome.sendKeys("Dantas");
		
		//WebElement email = driver.findElement(By.id("username"));
		//email.sendKeys("Patrick0101");
		
		WebElement senha = driver.findElement(By.name("Passwd"));
		senha.sendKeys("OlaMundo1234");
		
		WebElement confirmarSenha= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/form/div[2]/div/div[1]/div[3]/div[1]/div[3]/div/div/div[1]/div/div[1]/input\r\n"));
		confirmarSenha.sendKeys("OlaMundo1234");
		
		WebElement btn_cadastrar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/form/div[2]/div/div[2]/div[1]/div/span/span\r\n"));
		btn_cadastrar.click();
		
	}
	
	public String validarMensagem() {
		return driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/form/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/div\r\n")).getText();
	}
	
}
