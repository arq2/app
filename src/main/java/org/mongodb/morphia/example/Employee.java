package org.mongodb.morphia.example;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.LinkedList;
import java.util.List;

@Entity("employees")
@Indexes(
        @Index(value = "salary", fields = @Field("salary"))
)
public class Employee {
    @Id
    private ObjectId id;
    private String name;
    @Reference
    private Employee manager;
    @Reference
    private List<Employee> directReports;
    @Property("wage")
    private Double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.directReports = new LinkedList<>();
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }
}
