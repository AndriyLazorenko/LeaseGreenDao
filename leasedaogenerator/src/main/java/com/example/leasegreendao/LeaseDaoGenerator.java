package com.example.leasegreendao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class LeaseDaoGenerator {
    public static void main(String args[]) throws Exception {
        //Main mapping magic
        Schema schema = new Schema(1, "com.example.leasegreendao.model");
        //First entity and fields
        Entity person = schema.addEntity("Person");
        person.addIdProperty();
        person.addStringProperty("name");
        person.addStringProperty("comment");
        //Second entity and fields
        Entity lease = schema.addEntity("Lease");
        lease.addIdProperty();
        lease.addStringProperty("item");
        lease.addStringProperty("comment");
        lease.addLongProperty("leasedate");
        lease.addLongProperty("returndate");
        //Map between second and first entity using new property and
        //method addToOne()
        Property personId = lease.addLongProperty("personId").getProperty();
        lease.addToOne(person,personId);
        //Map between first and second entity
        ToMany personToLease = person.addToMany(lease,personId);
        personToLease.setName("leases");
        //Outputting classes
        new DaoGenerator().generateAll(schema, "../app/src/main/java");


    }
}
