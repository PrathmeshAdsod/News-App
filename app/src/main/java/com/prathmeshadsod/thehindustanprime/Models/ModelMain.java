package com.prathmeshadsod.thehindustanprime.Models;

import java.util.ArrayList;

public class ModelMain {

    // We are crating arraylist becoz our all data
    // like description,link,title etc. are present in results array which is in form of list
    // from Model class
    private int page;
    private ArrayList<Model> results;   // name must be results becoz it is on newsdata.io

    public ModelMain(ArrayList<Model> results , int page) {
        this.results = results;
        this.page = page;
    }

    public ArrayList<Model> getResults() {
        return results;
    }

    public void setResults(ArrayList<Model> results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
