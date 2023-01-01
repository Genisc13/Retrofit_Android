package edu.upc.dsa.retrofittracks.models;

    public class Map {
        String id;
        String name;
        String type;
        String size;

        public Map(){}

        public Map(String id, String name, String type, String size) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.size = size;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }
    }


