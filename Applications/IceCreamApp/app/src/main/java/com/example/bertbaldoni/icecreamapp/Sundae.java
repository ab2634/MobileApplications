package com.example.bertbaldoni.icecreamapp;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by BertBaldoni on 3/8/17.
 */

public class Sundae implements Serializable {

    private double totalCost;

    private String[] flavor = {"Vanilla", "Chocolate", "Strawberry"};
    private int flavorIndex;
    private String[] size = {"Small", " Medium", "Large"};
    private int sizeIndex;
    private boolean peanuts, mAndMs, almonds, brownies, strawberries, oreos, gummyBears, marshmallows;
    private String[] hotFudge = {"none", "1 ounce", "2 ounces", "3 ounces"};
    private int hotFudgeIndex;
    private Date date;

    public Sundae() {
        flavorIndex = 0;
        sizeIndex = 0;
        peanuts = false;
        mAndMs = false;
        almonds = false;
        brownies = false;
        strawberries = false;
        oreos = false;
        gummyBears = false;
        marshmallows = false;
        hotFudgeIndex = 1;
        date = new Date();
        updatePrice();
    }

    // getters
    public int getSizeIndex() {
        return sizeIndex;
    }
    public boolean isPeanuts() {
        return peanuts;
    }
    public boolean ismAndMs() {
        return mAndMs;
    }
    public boolean isAlmonds() {
        return almonds;
    }
    public boolean isBrownies() {
        return brownies;
    }
    public boolean isStrawberries() {
        return strawberries;
    }
    public boolean isOreos() {
        return oreos;
    }
    public boolean isGummyBears() {
        return gummyBears;
    }
    public boolean isMarshmallows() {
        return marshmallows;
    }
    public int getFlavorIndex() {
        return flavorIndex;
    }
    public int getHotFudgeIndex() {
        return hotFudgeIndex;
    }
    public String[] getHotFudge() {
        return hotFudge;
    }
    public String[] getFlavor() {
        return flavor;
    }
    public String[] getSize() {
        return size;
    }
    public double getTotalCost() {
        return totalCost;
    }

    // setters
    public void setFlavorIndex(int flavorIndex) {
        this.flavorIndex = flavorIndex;
    }
    public void setSizeIndex(int sizeIndex) {
        this.sizeIndex = sizeIndex;
    }
    public void setPeanuts(boolean peanuts) {
        this.peanuts = peanuts;
    }
    public void setMAndMs(boolean mAndMs) {
        this.mAndMs = mAndMs;
    }
    public void setAlmonds(boolean almonds) {
        this.almonds = almonds;
    }
    public void setBrownies(boolean brownies) {
        this.brownies = brownies;
    }
    public void setStrawberries(boolean strawberries) {
        this.strawberries = strawberries;
    }
    public void setOreos(boolean oreos) {
        this.oreos = oreos;
    }
    public void setGummyBears(boolean gummyBears) {
        this.gummyBears = gummyBears;
    }
    public void setMarshmallows(boolean marshmallows) {
        this.marshmallows = marshmallows;
    }
    public void setHotFudgeIndex(int hotFudgeIndex) {
        this.hotFudgeIndex = hotFudgeIndex;
    }

    public void updatePrice() {
        totalCost = 0.0;
        if (sizeIndex == 0)
            totalCost += 2.99;
        else if (sizeIndex == 1)
            totalCost += 3.99;
        else
            totalCost += 4.99;
        if (peanuts)
            totalCost += .15;
        if (mAndMs)
            totalCost += .25;
        if (almonds)
            totalCost += .15;
        if (brownies)
            totalCost += .20;
        if (strawberries)
            totalCost += .20;
        if (oreos)
            totalCost += .20;
        if (gummyBears)
            totalCost += .20;
        if (marshmallows)
            totalCost += .15;
        if (hotFudgeIndex == 1)
            totalCost += .15;
        else if (hotFudgeIndex == 2)
            totalCost += .25;
        else if (hotFudgeIndex == 3)
            totalCost += .30;

    }

    public void theWorks() {
        peanuts = true;
        almonds = true;
        mAndMs = true;
        brownies = true;
        strawberries = true;
        oreos = true;
        marshmallows = true;
        gummyBears = true;
        hotFudgeIndex = 3;
        sizeIndex = 2;
    }

    public void reset() {
        peanuts = false;
        almonds = false;
        mAndMs = false;
        brownies = false;
        strawberries = false;
        oreos = false;
        marshmallows = false;
        gummyBears = false;
        flavorIndex = 0;
        hotFudgeIndex = 1;
        sizeIndex = 0;
    }

    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Locale locale = new Locale("en", "US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        return ("date: " + dateFormat.format(date) +
                "\nflavor: " + flavor[flavorIndex] +
                "\nsize: " + size[sizeIndex] +
                "\ncost: " + fmt.format(totalCost));
    }
}
