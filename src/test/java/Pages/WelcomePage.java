package Pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    @FindBy(how = How.LINK_TEXT, using="Nouveau dossier")
    public WebElement btnNouveauDossier;

    //@FindBy(how = How.XPATH, using="/html/body/div[3]/div/div/div[2]/div/div/div/table/tbody/tr[1]/td[10]/table/tbody/tr/td[2]/a/div")
    public WebElement btnArchiver;

    //@FindBy(how = How.XPATH, using="/html/body/div[3]/div/div/div[2]/div/div/div/table/tbody/tr[1]/td[10]/table/tbody/tr/td[1]/a/div")
    public WebElement btnDuplicquer;

    //@FindBy(how = How.XPATH, using="/html/body/div[3]/div/div/div[2]/div/div/div/table/tbody/tr[2]/td[10]/table/tbody/tr/td[3]/a/div")
    public WebElement btnSupprimer;



    public WelcomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }

    public void goToNouveauDossier(){
        btnNouveauDossier.click();

    }
    public void archiver(WebDriver driver) throws InterruptedException 
    {
        Thread.sleep(1000);
        
        List<WebElement> lst_btnArchiver= driver.findElements(By.className("archiverDoc"));    
        btnArchiver= lst_btnArchiver.size() > 0 ?  lst_btnArchiver.get(0) : null;
        
        if(btnArchiver != null)
        	btnArchiver.click();
        
        
        
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

    }

    public void desarchiver(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);


        List<WebElement> lst_btnArchiver= driver.findElements(By.className("archiverDoc"));    
        btnArchiver= lst_btnArchiver.size() > 0 ?  lst_btnArchiver.get(0) : null;
        
        if(btnArchiver != null)
        	btnArchiver.click();
        
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

    }
    public void dupliquer(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        
        
        List<WebElement> lst_btnDuplicquer= driver.findElements(By.className("CopyDoc"));
        
        btnDuplicquer= lst_btnDuplicquer.size() > 0 ?  lst_btnDuplicquer.get(0) : null;
        
        if(btnDuplicquer != null)
        btnDuplicquer.click();
        
        Thread.sleep(1000);
        
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }
    public void supprimerDuplicated(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        
        
        List<WebElement> lst_btnSupprimer= driver.findElements(By.className("deleteDoc"));
        
        btnSupprimer= lst_btnSupprimer.size() > 0 ?  lst_btnSupprimer.get(0) : null;
        
        if(btnSupprimer != null)
        	btnSupprimer.click();
                
        Thread.sleep(1000);
        
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

    }


}
