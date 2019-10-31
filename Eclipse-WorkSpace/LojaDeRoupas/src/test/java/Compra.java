import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Compra extends QaDriver{
	
	// Adiciona um produto ao carrinho
	public void adicionar_ao_carrinho() {
		driver.get("http://automationpractice.com/index.php");
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")));
		
		WebElement card_roupa = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]"));
		//String produto = card_roupa.getText();
		card_roupa.click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.name("Submit")));
		
		WebElement btn_carrinho = driver.findElement(By.name("Submit"));
		btn_carrinho.click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[@class='btn btn-default button button-medium']")));
		
		WebElement btn_carrinho_confirmar = driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']"));
		btn_carrinho_confirmar.click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")));
		
		//carrinho_verificacao(produto);
		WebElement btn_carrinho_comprar = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]"));
		btn_carrinho_comprar.click();
	}
	
	// Verifica se o produto foi adicionado ao carrinho
	public void carrinho_verificacao(String _produto) {
		WebElement car_prod = driver.findElement(By.xpath("//td[@class='cart_description']//a[contains(text(),'Faded Short Sleeve T-shirts')]"));
		String prod = car_prod.getText();
		System.out.println(prod);
		System.out.println(_produto);
		if(prod == _produto) {
			System.out.print("----------TRUE------------");
			WebElement btn_carrinho_comprar = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]"));
			btn_carrinho_comprar.click();
		} else {
			System.out.print("-----------FALSE------------");
		}
	}
	
	//faz o cadastro do cliente
	public void cadastro_cliente() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("email_create")));
		
		WebElement inp_email = driver.findElement(By.id("email_create"));
		WebElement btn_criar_conta = driver.findElement(By.id("SubmitCreate"));
		
		
		Random random = new Random();
		inp_email.sendKeys(random.nextInt(999999) + "Patrick@dantas.com");
		btn_criar_conta.click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
				By.id("submitAccount")));
		
		WebElement sexo = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]"));
		WebElement inp_nome = driver.findElement(By.id("customer_firstname"));
		WebElement inp_sobrenome = driver.findElement(By.id("customer_lastname"));
		WebElement inp_pass = driver.findElement(By.id("passwd"));
		WebElement inp_data_dia = driver.findElement(By.name("days"));
		WebElement inp_data_mes = driver.findElement(By.name("months"));
		Select inp_data_ano = new Select(driver.findElement(By.name("years")));
		
		
		sexo.click();
		inp_nome.sendKeys("Patrick");
		inp_sobrenome.sendKeys("Dantas");
		inp_pass.sendKeys("1234Br@");
		inp_data_dia.sendKeys("5");
		inp_data_mes.click();
		inp_data_mes.sendKeys("n");
		inp_data_mes.sendKeys(Keys.ENTER);
		inp_data_ano.selectByValue("1999");
		
		WebElement endereco = driver.findElement(By.id("address1"));
		WebElement cidade = driver.findElement(By.id("city"));
		Select estado = new Select(driver.findElement(By.id("id_state")));
		WebElement cep = driver.findElement(By.id("postcode"));
		WebElement mobile = driver.findElement(By.id("phone_mobile"));
		WebElement endereco_alternativo = driver.findElement(By.id("alias"));
		
		endereco.sendKeys("Rua Madeira 337");
		cidade.sendKeys("Itapecerica");
		estado.selectByValue("1");
		cep.sendKeys("00000");
		mobile.sendKeys("999999999");
		endereco_alternativo.sendKeys("outro");
		
		WebElement cadastro_dados = driver.findElement(By.id("submitAccount"));
		cadastro_dados.click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.name("processAddress")));
		
		WebElement btn_checkout = driver.findElement(By.name("processAddress"));
		btn_checkout.click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//label[contains(text(),'I agree to the terms of service and will adhere to')]")));
		
		WebElement termos_de_servico = driver.findElement(By.xpath("//label[contains(text(),'I agree to the terms of service and will adhere to')]"));
		WebElement btn_checkout_go = driver.findElement(By.name("processCarrier"));
		
		termos_de_servico.click();
		btn_checkout_go.click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='cheque']")));
		
		WebElement pagamento = driver.findElement(By.xpath("//a[@class='cheque']"));
		pagamento.click();
		
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'I confirm my order')]")));
		
		WebElement confirmar = driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]"));
		confirmar.click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'I confirm my order')]")));
		
		WebElement confirmar_sucesso = driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]"));
		assertEquals("Your order on My Store is complete.", confirmar_sucesso.getText());
		
	}
	
	
	
	
	@Test
	public void comprar() {
		adicionar_ao_carrinho();
		cadastro_cliente();
	}
}
