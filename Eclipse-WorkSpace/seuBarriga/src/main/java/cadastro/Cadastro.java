package cadastro;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cadastro extends QaDriver{

	// É o teste em si, é aqui que escrevemos o que acontecerá no teste
	@Test
	public void cadastrar() {
		// Aqui dizemos a url da aplicação
		driver.get("https://seubarriga.wcaquino.me/login");
		
		//agora temos que esperar a pagina carregar, usamos o WebDriverWait para detectar quando esta pagina carregada atraves de um elemento
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")));
		
		// Pegamos o botão que nos leva para a parte de cadastro e clicamos nele
		WebElement novoUsuario = driver.findElementByXPath("/html/body/nav/div/div[2]/ul/li[2]/a");
		novoUsuario.click();
		
		// Esperamos o carregamento da pagina verificando quando o input do nome aparecer
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.id("nome")));
		
		// pegamos todos os inputs e colocamos em variaveis
		WebElement inp_nome = driver.findElement(By.id("nome"));
		WebElement inp_email = driver.findElement(By.id("email"));
		WebElement inp_senha = driver.findElement(By.id("senha"));
		
		// Colocamos valores nos inputs
		inp_nome.sendKeys("Patrick");
		inp_email.sendKeys("Patrick@franca.com");
		inp_senha.sendKeys("123456789Br@");
		
		// Pegamos e clicamos o botão de cadastro
		WebElement btn_cadastrar = driver.findElement(By.cssSelector("body.body-index:nth-child(2) div.jumbotron.col-lg-4:nth-child(3) form:nth-child(1) > input.btn.btn-primary:nth-child(4)"));
		btn_cadastrar.click();
		
		// Agora verificamos se o cadastro deu certo, para isso precisamos esperar a confirmação do aplicativo
		new WebDriverWait(driver, 30).until(ExpectedConditions.textToBePresentInElementLocated(
				By.cssSelector("body.body-index:nth-child(2) > div.alert.alert-success:nth-child(2)"), "Usuário inserido com sucesso"));
		
		//Com isso terminamos o teste
		
	}
	
}
