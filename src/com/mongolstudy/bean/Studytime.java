package com.mongolstudy.bean;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

public class Studytime {
    private int tid;
    private Time studytimestart;
    private Time studytimeend;
    private Time reviewtimestart;
    private Time reviewtimeend;
    private String datein;
    private int wordId;
    private Double timel;
    private int uid;
    public Studytime() {
    }

    public Studytime(Time studytimestart, Time studytimeend, Time reviewtimestart, Time reviewtimeend, String datein,int wordId,Double timel,int uid) {
        this.studytimestart = studytimestart;
        this.studytimeend = studytimeend;
        this.reviewtimestart = reviewtimestart;
        this.reviewtimeend = reviewtimeend;
        this.datein = datein;
        this.wordId=wordId;
        this.timel=timel;
        this.uid=uid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int id) {
        this.tid = tid;
    }

    public Time getStudytimestart() {
        return studytimestart;
    }

    public void setStudytimestart(Time studytimestart) {
        this.studytimestart = studytimestart;
    }

    public Time getStudytimeend() {
        return studytimeend;
    }

    public void setStudytimeend(Time studytimeend) {
        this.studytimeend = studytimeend;
    }

    public Time getReviewtimestart() {
        return reviewtimestart;
    }

    public void setReviewtimestart(Time reviewtimestart) {
        this.reviewtimestart = reviewtimestart;
    }

    public Time getReviewtimeend() {
        return reviewtimeend;
    }

    public void setReviewtimeend(Time reviewtimeend) {
        this.reviewtimeend = reviewtimeend;
    }

    public String getDatein() {
        return datein;
    }

    public void setDatein(String datein) {
        this.datein = datein;
    }

    public int getWordId(){
        return wordId;
    }

    public void setWordId(int wordId){
        this.wordId=wordId;
    }

    public Double getTimel() {
        return timel;
    }

    public void setTimel(double timel){
        this.timel=timel;
    }

    public int getUid(){
        return uid;
    }

    public void setUid(int uid){
        this.uid=uid;
    }


    @Override
    public String toString() {
        return "Studytime{" +
                "studytimestart=" + studytimestart +
                ", studytimeend='" + studytimeend + '\'' +
                ", reviewtimestart=" + reviewtimestart +
                ", reviewtimeend=" + reviewtimeend +
                ", datein=" + datein +
                ", timel='" + timel + '\'' +
                ", wordId=" + wordId +
                ", uid='" + uid + '\'' +
                '}';
    }
}
