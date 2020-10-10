package org.gitti_gidiyor.pages;

import org.junit.Test;

public class TestProductPage extends ProductPage{

    @Test
    public void urunAlAraVeTiklaTest() throws InterruptedException {
        urunAra("İşlemci");
        urunSepeteEkle();
    }
}
