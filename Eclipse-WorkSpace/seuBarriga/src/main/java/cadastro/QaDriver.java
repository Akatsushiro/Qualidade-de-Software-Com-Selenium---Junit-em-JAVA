package cadastro;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

// Est� classe deve ser estendia ao testes que ser�o realizados logo em seguida
public class QaDriver {
	// Inicia o driver de teste no sistema, o tipo ChromeDriver vem do Selenium
	public static  ChromeDriver driver;
	
	// Este m�todo inicia o navegador, tamb�m retorna o estado do driver
	public static ChromeDriver init() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		// Maximiza o navegador
		driver.manage().window().maximize();	
		return driver;
	}
	
	// � o que acontece antes de iniciar o teste
	@Before
	public void start() {
		// Usamos o m�todo init() que criamos assim, logo ele abre o navegador e o maximiza
		driver = init();
	}
	
	// � o que acontece depois do teste
	@After
	public void end() {
		// Aqui testamos se o navegador est� aberto, se estiver ele o fecha
		if(driver != null) {
			driver.close();
		}
	}
}
