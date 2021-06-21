package automation.bemoblaze.bdd;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
	
    public static final SelenideElement laptopsLink = $x("//a[contains(text(),'Laptops')]");
    public static final SelenideElement sonyLink = $x("//a[contains(text(),'Sony vaio i5')]");
    public static final SelenideElement sonyText = $x("//h2[contains(text(),'Sony vaio i5')]");
    public static final SelenideElement dellText = $x("//h2[contains(text(),'Dell i7 8gb')]");
    public static final SelenideElement addToCartButton =$x("//a[contains(text(),'Add to cart')]");
    public static final SelenideElement dellLink = $x("//a[contains(text(),'Dell i7 8gb')]");
    public static final SelenideElement cartLink = $x("//a[@id='cartur']");
    public static final SelenideElement laptopPrice = $(".price-container");
    public static final SelenideElement galaxyS6Link = $x("//a[contains(text(),'Samsung galaxy s6')]");
    public static final SelenideElement appleMonitorLink = $x("//a[contains(text(),'Apple monitor 24')]");
    public static final SelenideElement homeLink = $x("//a[contains(text(),'Home ')]");
    public static final SelenideElement monitorsLink = $x("//a[contains(text(),'Monitors')]");
    public static final SelenideElement phonesLink = $x("//a[contains(text(),'Phones')]");
}
