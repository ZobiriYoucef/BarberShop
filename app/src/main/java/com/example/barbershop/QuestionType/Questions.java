package com.example.barbershop.QuestionType;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import java.util.ArrayList;

class Questions implements Parcelable{
    private String Profile;

    private String Type;

    private int Number;

    public String getProfile() {
        return Profile;
    }

    public void setProfile(String profile) {
        Profile = profile;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getQuestionText() {
        return QuestionText;
    }

    public void setQuestionText(String questionText) {
        QuestionText = questionText;
    }

    public String getExepectedAnswerType() {
        return ExepectedAnswerType;
    }

    public void setExepectedAnswerType(String exepectedAnswerType) {
        ExepectedAnswerType = exepectedAnswerType;
    }

    public int getNumberOfAnswersChoice() {
        return numberOfAnswersChoice;
    }

    public void setNumberOfAnswersChoice(int numberOfAnswersChoice) {
        this.numberOfAnswersChoice = numberOfAnswersChoice;
    }

    public ArrayList<String> getAnswersChoice() {
        return answersChoice;
    }

    public void setAnswersChoice(ArrayList<String> answersChoice) {
        this.answersChoice = answersChoice;
    }

    public Boolean getTheAnswerRequierd() {
        return isTheAnswerRequierd;
    }

    public void setTheAnswerRequierd(Boolean theAnswerRequierd) {
        isTheAnswerRequierd = theAnswerRequierd;
    }

    private String QuestionText;

    private String ExepectedAnswerType;

    private int numberOfAnswersChoice;

    private ArrayList<String> answersChoice;

    private Boolean isTheAnswerRequierd;

    Questions(String profile, String type, int number, String questionText, String exepectedAnswerType, int numberOfAnswersChoice, @Nullable ArrayList<String> answersChoice, Boolean isTheAnswerRequierd) {
        Profile = profile;
        Type = type;
        Number = number;
        QuestionText = questionText;
        ExepectedAnswerType = exepectedAnswerType;
        this.numberOfAnswersChoice = numberOfAnswersChoice;
        this.answersChoice = answersChoice;
        this.isTheAnswerRequierd = isTheAnswerRequierd;
    }

    protected Questions(Parcel in) {
        Profile = in.readString();
        Type = in.readString();
        Number = in.readInt();
        QuestionText = in.readString();
        ExepectedAnswerType = in.readString();
        numberOfAnswersChoice = in.readInt();
        answersChoice = in.createStringArrayList();
        byte tmpIsTheAnswerRequierd = in.readByte();
        isTheAnswerRequierd = tmpIsTheAnswerRequierd == 0 ? null : tmpIsTheAnswerRequierd == 1;
    }

    public static final Creator<Questions> CREATOR = new Creator<Questions>() {
        @Override
        public Questions createFromParcel(Parcel in) {
            return new Questions(in);
        }

        @Override
        public Questions[] newArray(int size) {
            return new Questions[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Profile);
        dest.writeString(Type);
        dest.writeInt(Number);
        dest.writeString(QuestionText);
        dest.writeString(ExepectedAnswerType);
        dest.writeInt(numberOfAnswersChoice);
        dest.writeStringList(answersChoice);
        dest.writeByte((byte) (isTheAnswerRequierd == null ? 0 : isTheAnswerRequierd ? 1 : 2));
    }
}
