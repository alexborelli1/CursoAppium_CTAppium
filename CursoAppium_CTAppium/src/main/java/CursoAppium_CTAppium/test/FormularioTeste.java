package CursoAppium_CTAppium.test;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import CursoAppium_CTAppium.core.DSL;
import CursoAppium_CTAppium.core.DriverFactory;
import CursoAppium_CTAppium.page.formularioPage;
import CursoAppium_CTAppium.page.menuPage;

public class FormularioTeste {

	private DSL dsl = new DSL();
	private menuPage menuPage = new menuPage(); 
	private formularioPage formularioPage = new formularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
	    //driver = DriverFactory.getDriver();		
	}
	
	@Test
	public void deveVerificarNomeCursoEmAbout() throws MalformedURLException {
		menuPage.acessarAbout();

		Assert.assertEquals("Testes funcionais de aplicações Android com Appium", dsl.obterTexto(By.xpath("//android.widget.TextView[@index='2']")));
	}
	

	@Test
	public void deveEscreverNomeFormulario() {
		menuPage.acessarFormulario();
		formularioPage.escreverNome("Alex");

		Assert.assertEquals("Alex", formularioPage.obterNome());
	}
	
	
	@Test
	public void deveInterragirCombo() {
		menuPage.acessarFormulario();
		formularioPage.selecionarCombo("PS4");

		Assert.assertEquals("PS4", formularioPage.obterValorCombo());	
	}
	
	
	@Test
	public void deveInterragirCheckbox() {
		menuPage.acessarFormulario();		
		Assert.assertFalse(formularioPage.isCheckMarcado());

		formularioPage.clicarCheck();
		Assert.assertTrue(formularioPage.isCheckMarcado());
	}
	
	
	@Test
	public void deveInterragirSwitch() {
		menuPage.acessarFormulario();
		Assert.assertTrue(formularioPage.isSwitchMarcado());
		
		formularioPage.clicarSwitch();
		Assert.assertFalse(formularioPage.isSwitchMarcado());
	}


	@Test
	public void deveValidarCadastro() {
		menuPage.acessarFormulario();
		formularioPage.escreverNome("Alex");
		formularioPage.selecionarCombo("PS4");
		formularioPage.clicarCheck();
		formularioPage.clicarSwitch();
		
		formularioPage.clicarSalvar();
		
		Assert.assertEquals("Alex", formularioPage.obterNome());
		Assert.assertEquals("Console: ps4", formularioPage.obterConsoleCadastrado());		
		Assert.assertEquals("Slider: 25", formularioPage.ObterSlideCadastrado());
		Assert.assertTrue(formularioPage.obterSwitchCadastrado().endsWith("Off"));
		Assert.assertEquals("Checkbox: Marcado", formularioPage.obterCheckCadastrado());
		Assert.assertEquals("Data: 01/01/2000", formularioPage.obterDataCadastro());
	}
	
		
	@After
	public void fechar() {
		DriverFactory.killDriver();
	}
	
}