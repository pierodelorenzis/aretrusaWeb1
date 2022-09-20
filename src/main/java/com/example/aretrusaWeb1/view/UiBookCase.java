package com.example.aretrusaWeb1.view;

import com.example.aretrusaWeb1.model.BookCase;

public class UiBookCase {

    public int bookcase;

    public UiBookCase(BookCase bookCase) {
        this.bookcase = bookCase.getBookcase();
    }

    public UiBookCase() {
    }

    public int getBookcase() {
        return bookcase;
    }

}

