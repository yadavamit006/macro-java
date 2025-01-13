**Factory Design Pattern**

Advantages
1. provides approach to code for interface rather than implementation.
2. removes the instantiation of actual implementation classes from client code. Factory pattern makes our code more robust, less coupled and easy to extend. For example, we can easily change PC class implementation because client program is unaware of this.
3. provides abstraction between implementation and client classes through inheritance.

Examples in JDK
1. java.util.Calendar, ResourceBundle and NumberFormat getInstance() methods.
2. valueOf() method in wrapper classes like Boolean, Integer etc.

**Abstract Factory Design Pattern**

Benefits
1. provides approach to code for interface rather than implementation.
2. It is “factory of factories” and can be easily extended to accommodate more products, for example we can add another sub-class Laptop and a factory LaptopFactory.
3. It is robust and avoid conditional logic of Factory pattern.

Examples: javax.xml.parsers.DocumentBuilderFactory#newInstance() or javax.xml.transform.TransformerFactory#newInstance()

**Decorator Design Pattern**
1. DP is helpful in providing runtime modification abilities and hence more flexible. Its easy to maintain and extend when the number of choices are more.
2. The disadvantage of decorator dp is that it uses a lot of similar kind of objects (decorators).
3. DP is used a lot in Java IO classes, such as FileReader, BufferedReader etc.