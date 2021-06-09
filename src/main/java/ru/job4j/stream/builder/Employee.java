package ru.job4j.stream.builder;

public class Employee {
    private String name;
    private String surname;
    private byte age;
    private String gender;
    private String specialization;

    static class Builder {
        private String name;
        private String surname;
        private byte age;
        private String gender;
        private String specialization;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Builder buildSpecialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        Employee build() {
            Employee employee = new Employee();
            employee.name = name;
            employee.surname = surname;
            employee.age = age;
            employee.gender = gender;
            employee.specialization = specialization;
            return employee;
        }
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", gender='" + gender + '\''
                + ", specialization='" + specialization + '\''
                + '}';
    }

    public static void main(String[] args) {
        Employee employee = new Builder().buildName("Jon")
                .buildSurname("Snow")
                .buildAge((byte) 20)
                .buildGender("male")
                .buildSpecialization("bastard")
                .build();
        System.out.println(employee);
    }
}
