package com.telran.testTask.tests;

import com.telran.testTask.models.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {

    @Test
    public void searchItemTest(){
        app.getHomePage().selectMarket();
        app.getHomePage().switchToNextTab(1);
        app.getCategory().selectDepartment("Экспресс");
        app.getCategory().acceptCookies();
        app.getCategory().selectCatalog("elektronika/23282330");
        app.getCategory().selectCategoryType("smartfony-i-aksessuary/23282379");
        app.getItem().filterItem(new Item().setPriceFrom("20000")
                    .setPriceTo("35000")
                    .setBrand("Apple"));
        app.getItem().pause(30000);
        String itemName = app.getItem().getItemNameFromListByNumber(3);
        System.out.println(itemName);
        app.getItem().typeInSearchInputField(itemName);
        app.getItem().pause(40000);
        String foundItemName = app.getItem().getItemNameFromListByNumber(2);
        System.out.println(foundItemName);
        Assert.assertEquals(foundItemName,itemName);

        //wd.findElement(By.xpath("//span[contains(.,'Экспресс')]")).click();
    }


}

   /* Автоматизировать следующий сценарий

        1.Открыть браузер и развернуть на весь экран
        2.Зайти на yandex.ru
        3.Перейти на Яндекс Маркет
        4.Выбрать раздел Экспресс
        5.Выбрать раздел Электроника
        6.Выбрать раздел Смартфоны
        Зайти в расширенный поиск
        Задать параметр поиска от 20000 до 35000 рублей.
        Выбрать производителя “Apple”
        Применить условия поиска
        Запомнить второй элемент в результатах поиска
        В поисковую строку ввести запомненное значение.
        Найти и проверить, что наименование товара соответствует заполненному значению.*/
