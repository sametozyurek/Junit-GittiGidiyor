package org.gitti_gidiyor.pages;

import org.junit.Test;

public class TestRegisterPage extends RegisterPage{

    @Test
    public void kullaniciKayitOlTest() throws InterruptedException {
        kullaniciKayit();
        kayitOl("Samet","Özyürek","samet.ozyurk@gmail.com","S123123","5328958239");
        callMainPage();
    }
}
