package app.core;

import app.core.services.OrderSystem;

import java.util.Calendar;

public class Run {

    public static void main(String[] args) {
        OrderSystem.getInstance().orderMenu();
    }
}
