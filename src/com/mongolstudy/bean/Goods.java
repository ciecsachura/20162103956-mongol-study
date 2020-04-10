package com.mongolstudy.bean;
    public class Goods {
        private int id;
        private String name;
        private double price;
        private int sales;
        private int stock;
        private String detail;

        public Goods() {
        }

        public Goods(String name, double price, int sales, int stock, String detail) {
            this.name = name;
            this.price = price;
            this.sales = sales;
            this.stock = stock;
            this.detail = detail;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getSales() {
            return sales;
        }

        public void setSales(int sales) {
            this.sales = sales;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        @Override
        public String toString() {
            return "Goods{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", sales=" + sales +
                    ", stock=" + stock +
                    ", detail='" + detail + '\'' +
                    '}';
        }
    }
