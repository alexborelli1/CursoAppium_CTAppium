package CursoAppium_CTAppium.page;

import org.openqa.selenium.By;

import CursoAppium_CTAppium.core.DSL;
import io.appium.java_client.MobileBy;

public class formularioPage {

	private DSL dsl = new DSL();
	
	public void escreverNome(String nome) {
		dsl.escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return dsl.obterTexto(MobileBy.AccessibilityId("nome"));
	}
	 
	public void selecionarCombo(String valor) {
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterValorCombo() {
		return dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public boolean isCheckMarcado() {
		return dsl.isCheckMarcado(MobileBy.AccessibilityId("check"));
	}
	
	public void clicarCheck() {
		dsl.clicar(MobileBy.AccessibilityId("check"));
	}
	
	public boolean isSwitchMarcado() {
		return dsl.isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	public void clicarSwitch() {
		dsl.clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public void clicarSalvar() {
		dsl.clicarPorTexto("SALVAR");
	}
	
	
	public String obterNomeCadastrado() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='12']"));	
	}
	
	public String obterConsoleCadastrado() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console')]"));
	}
	
	public String ObterSlideCadastrado() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='14']"));
	}

	public String obterSwitchCadastrado() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch')]"));
	}
	
	public String obterCheckCadastrado() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='16']"));
	}
	
	public String obterDataCadastro() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='17']"));
	}	
}
