package se.iths.christoffer.labb2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        Ui uiScanner = new UiScanner();
        Ui uiJOption = new UiJOptionpane();
        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(
                mapper.getPolymorphicTypeValidator(),
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY
        );
        WebshopManager open = new WebshopManager(uiScanner, mapper);

        open.openShop();
    }
}
