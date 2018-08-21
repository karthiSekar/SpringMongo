package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tasks")
public class Test {
int id;
String a;
}
