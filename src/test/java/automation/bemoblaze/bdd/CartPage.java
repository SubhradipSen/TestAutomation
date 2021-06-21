package automation.bemoblaze.bdd;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class CartPage {
	
    public static final SelenideElement addToCartButton =$x("//a[contains(text(),'Add to cart')]");
    public static final SelenideElement placeOrderButton = $x("//button[contains(text(),'Place Order')]");
    public static final SelenideElement nameEdit = $x("//input[@id='name']");
    public static final SelenideElement countryEdit = $x("//input[@id='country']");
    public static final SelenideElement cityEdit = $x("//input[@id='city']");
    public static final SelenideElement creditCardEdit = $x("//input[@id='card']");
    public static final SelenideElement monthEdit = $x("//input[@id='month']");
    public static final SelenideElement yearEdit = $x("//input[@id='year']");
    public static final SelenideElement purchaseButton = $x("//button[contains(text(),'Purchase')]");
    public static final SelenideElement cartValueText = $x("//h3[@id='totalp']");
    public static final SelenideElement purchaseInfoText = $x("//p[@class='lead text-muted ']");
    public static final SelenideElement sonyVaioText = $x("//td[contains(text(),'Sony vaio i5')]");
    public static final SelenideElement dellText = $x("//td[contains(text(),'Dell i7 8gb')]");
    public static final ElementsCollection rows = $$("#tbodyid");


}
