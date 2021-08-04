package com.example.friends.Model;

import java.util.ArrayList;
import java.util.List;

public class Friends_list_response {

    private List<Friends_response> results = new ArrayList<>();

    public List<Friends_response> getResults() {
        return results;
    }

    public void setResults(List<Friends_response> results) {
        this.results = results;
    }
}
