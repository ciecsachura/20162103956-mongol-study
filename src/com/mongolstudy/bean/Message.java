package com.mongolstudy.bean;

import java.io.Serializable;

    public class Message implements Serializable {
        private int mid;//id
        private String mname;//姓名
        private String title;
        private String telephone;//手机号
        private  String email;
        private String message;

        /**
         * 无参构造方法
         */
        public Message() {
        }
        public int getMid() {
            return mid;
        }
        public void setMid(int mid) {
            this.mid = mid;
        }
        public String getMname() { return mname; }
        public void setMname(String mname) { this.mname = mname; }
        public String getTelephone() {
            return telephone;
        }
        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "mid=" + mid +
                    ", mname='" + mname + '\'' +
                    ", title='" + title + '\'' +
                    ", telephone='" + telephone + '\'' +
                    ", email='" + email+ '\'' +
                    ", message='" + message+
                    '}';
        }


    }


