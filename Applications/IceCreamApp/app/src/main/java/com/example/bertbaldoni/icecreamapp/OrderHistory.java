package com.example.bertbaldoni.icecreamapp;

import java.io.Serializable;

/**
 * Created by BertBaldoni on 3/8/17.
 */

public class OrderHistory implements Serializable {

    private Sundae[] sundaes;
    private int sundaeCount;

    public OrderHistory() {
        sundaes = new Sundae[100];
        sundaeCount = 0;
    }
    public void addSundae(Sundae sundae) {
        sundaes[sundaeCount] = sundae;
        sundaeCount++;
    }

    public Sundae getCurrentSundae() {
        return sundaes[sundaeCount - 1];
    }

    public Sundae[] getSundaes() {
        return sundaes;
    }

    public int getSundaeCount() {
        return sundaeCount;
    }

}
