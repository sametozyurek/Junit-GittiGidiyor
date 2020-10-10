package org.gitti_gidiyor.pages;

import org.junit.Test;

public class TestLoginPage extends LoginPage{

    //girisBilgileri metot parametrelerine kendi login bilgilerinizi girmeniz gerekli
    //adresGir metot parametresine kendi password bilginizi girmelisiniz.
    @Test
    public void girisYapTest() throws InterruptedException {
        girisYap();
        girisBilgileri("yourUserNameOrEmail","yourPassword");
        adresGir("yourPassword");
        adresBilgileriGir("Ev", "Samet", "Özyürek", "İstanbul", "Hürriyet mah.", "Kartal", "34876", "Hürriyet mah. Saadetli sk. No: 12", "5327958239");
    }
}
