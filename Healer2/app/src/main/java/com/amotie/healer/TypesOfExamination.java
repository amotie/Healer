package com.amotie.healer;

public class TypesOfExamination {
    String examin;
    boolean chiecked=false;

    public TypesOfExamination(String examin, boolean chiecked) {
        this.examin = examin;
        this.chiecked = chiecked;
    }

    public TypesOfExamination(String examin) {
        this.examin = examin;

    }
}
