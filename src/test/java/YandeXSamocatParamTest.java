import ru.yandex.praktikum.pageobject.DriverFactory;
import ru.yandex.praktikum.pageobject.MainPage;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(JUnitParamsRunner.class) //запустил класс с параметрами
public class YandeXSamocatParamTest {
    @Rule // подключил DriverFactory
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    @Parameters({"0","1","2","3","4","5","6","7"}) // передал список значений  для переменной index
    public void shouldOpenContentForSelectedItem(int index){
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);// создали объект страницы MainPage
        mainPage.openSite();// открыли сайт
        mainPage.ClickDrop_down_list(index);//вызвали метод открывающий выпадающий список
        String actualText = mainPage.getAnswerText(index); // проверям текст открывающихся списков
        Assert.assertFalse(actualText.trim().isEmpty());




    }
}