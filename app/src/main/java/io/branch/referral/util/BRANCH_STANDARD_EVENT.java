/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.io.branch.referral.util;

public final class BRANCH_STANDARD_EVENT
extends Enum<BRANCH_STANDARD_EVENT> {
    private static final /* synthetic */ BRANCH_STANDARD_EVENT[] $VALUES;
    public static final /* enum */ BRANCH_STANDARD_EVENT ACHIEVE_LEVEL;
    public static final /* enum */ BRANCH_STANDARD_EVENT ADD_PAYMENT_INFO;
    public static final /* enum */ BRANCH_STANDARD_EVENT ADD_TO_CART;
    public static final /* enum */ BRANCH_STANDARD_EVENT ADD_TO_WISHLIST;
    public static final /* enum */ BRANCH_STANDARD_EVENT CLICK_AD;
    public static final /* enum */ BRANCH_STANDARD_EVENT COMPLETE_REGISTRATION;
    public static final /* enum */ BRANCH_STANDARD_EVENT COMPLETE_TUTORIAL;
    public static final /* enum */ BRANCH_STANDARD_EVENT INITIATE_PURCHASE;
    public static final /* enum */ BRANCH_STANDARD_EVENT INVITE;
    public static final /* enum */ BRANCH_STANDARD_EVENT LOGIN;
    public static final /* enum */ BRANCH_STANDARD_EVENT PURCHASE;
    public static final /* enum */ BRANCH_STANDARD_EVENT RATE;
    public static final /* enum */ BRANCH_STANDARD_EVENT RESERVE;
    public static final /* enum */ BRANCH_STANDARD_EVENT SEARCH;
    public static final /* enum */ BRANCH_STANDARD_EVENT SHARE;
    public static final /* enum */ BRANCH_STANDARD_EVENT SPEND_CREDITS;
    public static final /* enum */ BRANCH_STANDARD_EVENT START_TRIAL;
    public static final /* enum */ BRANCH_STANDARD_EVENT SUBSCRIBE;
    public static final /* enum */ BRANCH_STANDARD_EVENT UNLOCK_ACHIEVEMENT;
    public static final /* enum */ BRANCH_STANDARD_EVENT VIEW_AD;
    public static final /* enum */ BRANCH_STANDARD_EVENT VIEW_CART;
    public static final /* enum */ BRANCH_STANDARD_EVENT VIEW_ITEM;
    public static final /* enum */ BRANCH_STANDARD_EVENT VIEW_ITEMS;
    private final String name;

    static {
        BRANCH_STANDARD_EVENT bRANCH_STANDARD_EVENT;
        ADD_TO_CART = new BRANCH_STANDARD_EVENT("ADD_TO_CART");
        ADD_TO_WISHLIST = new BRANCH_STANDARD_EVENT("ADD_TO_WISHLIST");
        VIEW_CART = new BRANCH_STANDARD_EVENT("VIEW_CART");
        INITIATE_PURCHASE = new BRANCH_STANDARD_EVENT("INITIATE_PURCHASE");
        ADD_PAYMENT_INFO = new BRANCH_STANDARD_EVENT("ADD_PAYMENT_INFO");
        PURCHASE = new BRANCH_STANDARD_EVENT("PURCHASE");
        SPEND_CREDITS = new BRANCH_STANDARD_EVENT("SPEND_CREDITS");
        SEARCH = new BRANCH_STANDARD_EVENT("SEARCH");
        VIEW_ITEM = new BRANCH_STANDARD_EVENT("VIEW_ITEM");
        VIEW_ITEMS = new BRANCH_STANDARD_EVENT("VIEW_ITEMS");
        RATE = new BRANCH_STANDARD_EVENT("RATE");
        SHARE = new BRANCH_STANDARD_EVENT("SHARE");
        COMPLETE_REGISTRATION = new BRANCH_STANDARD_EVENT("COMPLETE_REGISTRATION");
        COMPLETE_TUTORIAL = new BRANCH_STANDARD_EVENT("COMPLETE_TUTORIAL");
        ACHIEVE_LEVEL = new BRANCH_STANDARD_EVENT("ACHIEVE_LEVEL");
        UNLOCK_ACHIEVEMENT = new BRANCH_STANDARD_EVENT("UNLOCK_ACHIEVEMENT");
        INVITE = new BRANCH_STANDARD_EVENT("INVITE");
        LOGIN = new BRANCH_STANDARD_EVENT("LOGIN");
        RESERVE = new BRANCH_STANDARD_EVENT("RESERVE");
        SUBSCRIBE = new BRANCH_STANDARD_EVENT("SUBSCRIBE");
        START_TRIAL = new BRANCH_STANDARD_EVENT("START_TRIAL");
        CLICK_AD = new BRANCH_STANDARD_EVENT("CLICK_AD");
        VIEW_AD = bRANCH_STANDARD_EVENT = new BRANCH_STANDARD_EVENT("VIEW_AD");
        BRANCH_STANDARD_EVENT[] arrbRANCH_STANDARD_EVENT = new BRANCH_STANDARD_EVENT[]{ADD_TO_CART, ADD_TO_WISHLIST, VIEW_CART, INITIATE_PURCHASE, ADD_PAYMENT_INFO, PURCHASE, SPEND_CREDITS, SEARCH, VIEW_ITEM, VIEW_ITEMS, RATE, SHARE, COMPLETE_REGISTRATION, COMPLETE_TUTORIAL, ACHIEVE_LEVEL, UNLOCK_ACHIEVEMENT, INVITE, LOGIN, RESERVE, SUBSCRIBE, START_TRIAL, CLICK_AD, bRANCH_STANDARD_EVENT};
        $VALUES = arrbRANCH_STANDARD_EVENT;
    }

    private BRANCH_STANDARD_EVENT(String string3) {
        this.name = string3;
    }

    public static BRANCH_STANDARD_EVENT valueOf(String string2) {
        return (BRANCH_STANDARD_EVENT)Enum.valueOf(BRANCH_STANDARD_EVENT.class, (String)string2);
    }

    public static BRANCH_STANDARD_EVENT[] values() {
        return (BRANCH_STANDARD_EVENT[])$VALUES.clone();
    }

    public String getName() {
        return this.name;
    }
}

