package generics.question;// generics/MultipleInterfaceVariants.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

interface Payable<T> {
}

class Employee implements Payable {
}

class Hourly extends Employee implements Payable { }


interface Payable1<T> {
}

class Employee1 implements Payable1<Employee1> {
}
// error
// class Hourly1 extends Employee1 implements Payable1<Hourly1> { }