package com.example.myapplication;

public class car {

        private String name;
        private String photo;
        private String id;
        private String seat_num;
        private String type;
        private String availability;
        private String year;


        public car (String id, String photo,String name, String seat_num, String type, String availability,String year) {
            this.id = id;
            this.name = name;
            this.photo = photo;
            this.seat_num = seat_num;
            this.type = type;
            this.availability = availability;
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSeat_num() {
            return seat_num;
        }

        public void setSeat_num(String seat_num) {
            this.seat_num = seat_num;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAvailability() {
            return availability;
        }

        public void setAvailability(String availability) {
            this.availability = availability;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }
    }

