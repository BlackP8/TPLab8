package sample.Transport;

import sample.Interface.Calculations;

//Класс оболочка
public class Wrapper {

    //Главный общий класс
    public static class Autotransport {
        /*private int Id;
        public void setId(int id) { Id = id; }
        public int getId() { return Id; }*/

        private int Power;
        public void setPower(int power) { Power = power; }
        public int getPower() { return Power; }

        private String Mark;
        public void setMark(String mark) { Mark = mark; }
        public String getMark() { return Mark; }

        public Autotransport(int power, String mark) {
            //this.Id = id;
            this.Power = power;
            this.Mark = mark;
        }

        public String info() {
            return null;
        }
    }

    //Класс грузовиков
    public static class Truck extends Autotransport implements Calculations {
        private double Capacity;
        public void setCapacity(double capacity) { Capacity = capacity; }
        public double getCapacity() { return Capacity; }

        public Truck(int power, String mark, double capacity) {
            super(power, mark);
            this.Capacity = capacity;
        }

        @Override
        public double weighttopower() {
            return getPower() / (getCapacity() / 1000);
        }

        @Override
        public String info() {
            String data = String.format("Грузовик: " + getMark() + ". \nМощность двигателя: " + getPower() + " лс. \nГрузоподъемность: " + getCapacity() + " кг. \nУдельная мощность: %.2f " + " лс/т.", weighttopower());
            return data;
        }
    }

    //Класс автобусов
    public static class Bus extends Autotransport implements Calculations {
        private int Passengers;
        public void setPassengers(int passengers) { Passengers = passengers; }
        public int getPass() { return Passengers; }

        private double Busmass;
        public void setBusmass(double busmass) { Busmass = busmass; }
        public double getBusmass() { return Busmass; }

        public Bus(int power, String mark, int passengers, double busmass) {
            super(power, mark);
            this.Passengers = passengers;
            this.Busmass = busmass;
        }

        @Override
        public double weighttopower()
        {
            return getPower()/(getBusmass()/1000);
        }

        @Override
        public String info () {
            String data = String.format("Автобус: " + getMark() + ". \nМощность двигателя: " + getPower() + " лс. \nПассажировместимость: " + getPass() + " чел.\nОбщая масса всех пассажиров: " + getBusmass() + " кг\nУдельная мощность: %.2f " + " лс/т.", weighttopower());
            return data;
        }
    }

}

