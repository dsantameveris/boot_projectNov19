package com.dsantacm.studentservice.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "students")
public class Student {

    @Id
    public ObjectId id;

    public String firstName;
    public String lastName;
    public String dni;

    @Override
    public String toString()
    {
        return "Student [id=" + id + ", name=" + firstName + ", surn=" + lastName +", dni=" + dni + "]";
    }

}