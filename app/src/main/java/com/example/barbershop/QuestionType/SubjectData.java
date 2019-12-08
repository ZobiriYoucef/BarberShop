package com.example.barbershop.QuestionType;

import android.content.res.Resources;

class SubjectData {
    String SubjectName;
    Resources ImageResources;
    public SubjectData(String subjectName, Resources image) {
        this.SubjectName = subjectName;
        this.ImageResources = image;
    }
}
