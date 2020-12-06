package org.restheart.graphql;
import graphql.language.StringValue;
import graphql.schema.GraphQLScalarType;
import org.restheart.graphql.BSONCoercing.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class BsonScalars {

    public static final GraphQLScalarType GraphQLBsonObjectId = GraphQLScalarType.newScalar()
            .name("ObjectId").description("BSON ObjectId scalar").coercing(new GraphQLBsonObjectIdCoercing()).build();

    public static final GraphQLScalarType GraphQLBsonDecimal128 = GraphQLScalarType.newScalar()
            .name("Decimal128").description("BSON Decimal128 scalar").coercing(new GraphQLBsonDecimal128Coercing()).build();

    public static final GraphQLScalarType GraphQLBsonTimestamp = GraphQLScalarType.newScalar()
            .name("Timestamp").description("BSON Timestamp scalar").coercing(new GraphQLBsonTimestampCoercing()).build();

    public static final GraphQLScalarType GraphQLBsonObject = GraphQLScalarType.newScalar()
            .name("BsonObject").description("BSON Object scalar").coercing(new GraphQLBsonObjectCoercing()).build();

    public static final GraphQLScalarType GraphQLBsonArray = GraphQLScalarType.newScalar()
            .name("BsonArray").description("BSON Array scalar").coercing(new GraphQLBsonArrayCoercing()).build();

    public static final GraphQLScalarType GraphQLBsonDate = GraphQLScalarType.newScalar()
            .name("DateTime").description("BSON DateTime scalar").coercing(new GraphQLBsonDateCoercing()).build();

    public static Map<String, GraphQLScalarType> getBsonScalars() throws IllegalAccessException {
        Field[] scalarFields =  BsonScalars.class.getDeclaredFields();
        Map<String, GraphQLScalarType> bsonScalars = new HashMap<>();
        for(Field scalar: scalarFields){
            bsonScalars.put(scalar.getName(), (GraphQLScalarType) scalar.get(null));
        }
        return bsonScalars;
    }

    public static String getBsonScalarHeader() throws IllegalAccessException {
        Field[] scalarFields = BsonScalars.class.getDeclaredFields();
        String header = "";
        for (Field scalar: scalarFields){
            header += "scalar " + ((GraphQLScalarType) scalar.get(null)).getName() +" ";
        }
        return header;
    }

}
