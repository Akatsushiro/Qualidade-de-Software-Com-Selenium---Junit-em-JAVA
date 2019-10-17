package teste;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class abrirNavegador {
	
	//instanciando a classe webdriver
	static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// dizer onde está o executavel
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe"); //Para o firefox
		driver = new ChromeDriver();
		
		driver.get("http://www.youtube.com.br");
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// fecha somente a aba que ele usou
		driver.close();
		// fecha todas as abas
		//driver.quit();
	}


}
