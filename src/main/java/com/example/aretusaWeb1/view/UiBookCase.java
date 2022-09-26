package com.example.aretusaWeb1.view;

import com.example.aretusaWeb1.model.BookCase;
import org.bson.types.ObjectId;

public class UiBookCase {

    public ObjectId bookcase;

    public UiBookCase(BookCase bookCase) {
        this.bookcase = bookCase.getIdBookcase();
    }

    public UiBookCase() {
    }

    public ObjectId getBookcase() {
        return bookcase;
    }

}

