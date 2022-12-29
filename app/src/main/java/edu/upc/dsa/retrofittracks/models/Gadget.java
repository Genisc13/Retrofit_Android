package edu.upc.dsa.retrofittracks.models;

    public class Gadget {
        String id;
        int cost;
        String description;
        int unityShape;
        public Gadget(){}

        public Gadget(String id, int cost, String description, int unityShape) {
            this.id = id;
            this.cost = cost;
            this.description = description;
            this.unityShape = unityShape;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getUnityShape() {
            return unityShape;
        }

        public void setUnityShape(int unityShape) {
            this.unityShape = unityShape;
        }
    }


