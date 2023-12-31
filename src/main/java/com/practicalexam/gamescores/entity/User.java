package com.practicalexam.gamescores.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;

    //one user can have multiple game scores
    @OneToMany(mappedBy = "user")
    private List<GameScore> gameScores = new ArrayList<>();


}


/*Notes

what is the use of @Entity
ChatGPT
In Java Persistence API (JPA), the @Entity annotation is used to mark a Java class as an
entity, indicating that instances of this class will be persisted to a database.
An entity in JPA corresponds to a database table, and instances of the entity class
represent rows in that table.

Here's why the @Entity annotation is used:

Persistence Mapping: By marking a class with @Entity, you are defining that instances
of this class should be stored in a database table. This annotation is a way of
 JPA that this class should be mapped to a database entity.

Database Table Creation: When you use JPA with an underlying database, the @Entity
annotation helps generate the appropriate database schema based on the annotated class.
It defines how the class's properties are mapped to columns in the database table.

CRUD Operations: Once an entity is defined, JPA provides mechanisms for performing
standard CRUD (Create, Read, Update, Delete) operations on the associated database
table using the entity objects.

Querying: JPA allows you to query the database using JPQL (Java Persistence Query
Language) which operates on the entity objects directly.

Relationships: The @Entity annotation is also used when defining relationships
between entities, such as one-to-one, one-to-many, or many-to-many relationships.

In summary, the @Entity annotation is a fundamental building block in JPA that
defines the mapping between Java objects and database tables, enabling you to work
with persistent data using object-oriented programming concepts.

==================================================================

actually who are we letting know that its an entity by using an annotation. is it the complier we are letting know that this class  is an entity
ChatGPT
Yes, you're correct. Annotations in Java, including the @Entity annotation, are primarily used to provide metadata to the compiler and runtime environment. In the case of JPA's @Entity annotation, you're informing the JPA framework that a particular class should be treated as
an entity and managed accordingly.

Here's how it works:

Compiler: When you use the @Entity annotation on a class, you're telling the Java
compiler that this class should be treated as a special type of class, i.e., an entity
class. The compiler doesn't necessarily know the detailed semantics of what an entity
is in the context of JPA, but it recognizes the annotation as a special marker.

Runtime Environment (JPA Framework): The JPA framework, which includes various
components for handling database interactions, relies on these annotations to
understand how to persist and retrieve objects from the database. When the application
runs, the JPA framework scans the classpath, finds the classes marked with @Entity,
and uses the information from these annotations to generate SQL queries, manage database
operations, and maintain the object-to-database mapping.

So, in a way, you are informing both the compiler and the runtime JPA framework
that a particular class should be treated as an entity. The compiler just recognizes
it as an annotation, and the JPA framework understands its implications and uses it
to manage database interactions.

==================================================================================

What does this mean, @GeneratedValue(strategy = GenerationType.IDENTITY)
what is strategy, what is IDENTITY, tell me everything
ChatGPT
The @GeneratedValue annotation in JPA (Java Persistence API) is used to specify how the
primary key value of an entity is generated. The strategy attribute within this
annotation indicates the strategy that should be used to generate the primary key,
and GenerationType.IDENTITY is one of the strategies available.

Here's a breakdown of the terms:

@GeneratedValue: This annotation is used to indicate that the value for the annotated
field (usually a primary key) will be automatically generated by the underlying
database or the JPA provider.

strategy: This attribute is used to specify the strategy for generating the
primary key. It can take various values, each representing a different strategy.

GenerationType.IDENTITY: This is one of the strategies available for generating
primary keys. When you use GenerationType.IDENTITY, it means that the primary key
values are generated by an auto-incrementing column provided by the database.

Here's how it works:

When you insert a new record into a table, the database automatically generates
a new value for the primary key column, incrementing it from the last used value.
This is particularly common in databases like MySQL, PostgreSQL, and SQL Server,
where you can define a column with an auto-increment feature.

With GenerationType.IDENTITY, you're telling the JPA framework to delegate the
primary key generation to the underlying database system. This is a convenient
strategy, as you don't need to worry about generating unique primary key values
manually in your Java code. The database takes care of it for you.

In summary, @GeneratedValue(strategy = GenerationType.IDENTITY) is used to
indicate that the primary key value of an entity should be generated by an
auto-incrementing column provided by the database. The JPA framework will
use this strategy to handle primary key generation when inserting new records
into the database.

=================================================================


what is a REST API
ChatGPT
A REST API, or Representational State Transfer Application Programming Interface, is a
standardized way for software applications to communicate and interact with each other
over the internet. It follows a set of architectural principles and constraints that
enable the creation of web services that are scalable, maintainable, and interoperable.

In simple terms, a REST API serves as a bridge between different software systems,
allowing them to exchange data and perform actions seamlessly. It is often used to
build web services that provide data and functionalities to other applications,
whether they are web-based, mobile apps, or even IoT devices.

The key characteristics of a REST API include:

Stateless: Each API request is self-contained, and the server doesn't need to
remember previous interactions. This simplifies the architecture and improves
scalability.

HTTP Methods: REST APIs use standard HTTP methods such as GET (retrieve data),
POST (create data), PUT (update data), and DELETE (remove data) to perform
various actions on resources.

Resources: Data entities are exposed as resources, each identified by a unique URL.
For example, /users might represent a collection of user data.

Uniform Interface: REST APIs use a consistent set of rules for interacting with
resources, making it easy for developers to understand and use them.

Representation: Data is exchanged in various formats, commonly JSON or XML, allowing
applications to understand and process the data regardless of their platforms.

Hypermedia as the Engine of Application State (HATEOAS): This principle suggests that
API responses should include links to related resources, guiding the client
application on further actions.

Caching: REST APIs support caching mechanisms, which improve performance by
allowing clients to reuse previously fetched responses.

Layered System: The architecture can include multiple
layers (proxies, gateways, load balancers), making it more flexible and scalable.

In essence, a REST API provides a standardized way for different applications to
communicate, allowing developers to build versatile, interoperable, and efficient systems that can share and manipulate data seamlessly.
* */