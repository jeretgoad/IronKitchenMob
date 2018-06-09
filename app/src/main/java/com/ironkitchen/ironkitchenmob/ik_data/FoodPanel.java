package com.ironkitchen.ironkitchenmob.ik_data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FoodPanel {
    private String panelTitle;
    private int expandableIcon;
    public FoodPanel(String panelTitle, int expandableIcon){
        this.panelTitle = panelTitle;
        this.expandableIcon = expandableIcon;
    }

    public String getPanelTitle(){
        return panelTitle;
    }

    public int getExpandableIcon(){return expandableIcon;}
}
