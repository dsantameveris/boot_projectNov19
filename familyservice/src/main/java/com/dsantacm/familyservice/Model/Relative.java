package com.dsantacm.familyservice.Model;

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
@Document(collection = "family")
public class Relative {

    @Id
    public ObjectId id;

    public String firstName;
    public String lastName;
    public String dni;

    @Override
    public String toString()
    {
        return "Relative [id=" + id + ", name=" + firstName + ", surn=" + lastName +", dni=" + dni + "]";
    }

}