package de.aittr.g_31_2_shop.domain.interfaces;

public interface Customer<Cart> {

    int getId();
    boolean isActive();
    String getName();
    Cart getCart();
}
