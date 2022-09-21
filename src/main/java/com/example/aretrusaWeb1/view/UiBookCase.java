package com.example.aretrusaWeb1.view;

import com.example.aretrusaWeb1.model.BookCase;
import org.bson.types.ObjectId;

public class UiBookCase {

    public ObjectId bookcase;

    public UiBookCase(BookCase bookCase) {
        this.bookcase = bookCase.getBookcase();
    }

    public UiBookCase() {
    }

    public ObjectId getBookcase() {
        return bookcase;
    }

}

