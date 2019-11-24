# Designs Patterns 

[![Travis-CI](https://api.travis-ci.org/albertoiNET/designpatterns.svg?branch=master)](https://travis-ci.org/albertoiNET/designpatterns) 
[![SonarQube](https://sonarcloud.io/api/project_badges/measure?project=net.albertoi%3Adesign-patterns&metric=alert_status)](https://sonarcloud.io/dashboard?id=net.albertoi%3Adesign-patterns) 
[![codecov](https://codecov.io/gh/albertoiNET/designpatterns/branch/master/graph/badge.svg)](https://codecov.io/gh/albertoiNET/designpatterns)

  
Software Designs Patterns. Based on book **Design Patterns. Elements of Reusable Object-Oriented Software** by 
*Erich Gamma*, *Richard Helm*, *Ralph Johnson* and *John Vlissides*.  
  
- **Creational patterns**:
  - Singleton:  
    - Ensure a class has only one instance and provide a global point of access to it.
    
  - Factory Method:
    - Define an interface for creating an object,but let subclasses decide which class to instantiate. Factory Method 
    lets a class defer instantiation to subclasses.
    
  - Prototype:
    - Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this 
    prototype.
    
  - Builder:
    - Separate the construction of a complex object from its representation so that the same construction process can 
    create different representations.
    
  - Object Pool:
    - Creates a group of objects, that can be reused for boost performance. Usually this object are heavily and 
    expensive. We can restrict the number of this heavy objects are created, and force the reuse.



    