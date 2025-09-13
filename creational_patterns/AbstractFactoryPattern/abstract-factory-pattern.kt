package creational_patterns.AbstractFactoryPattern

import creational_patterns.FactoryPattern.Document
import creational_patterns.FactoryPattern.ExcelDocument
import creational_patterns.FactoryPattern.WordDocument

// Abstract Factory Interface
interface DocumentAbstractFactory{
    fun createDocument(): Document
}


// Concrete Factories
class WordDocumentFactory:DocumentAbstractFactory{
    override fun createDocument(): Document {
        return WordDocument()
    }
}

class ExcelDocumentFactory : DocumentAbstractFactory {
    override fun createDocument(): Document {
        return ExcelDocument()
    }
}

class Client(factory: DocumentAbstractFactory){
    private val document: Document = factory.createDocument()

    fun openDocument(){
        document.open()
    }
}


abstract class Vehicle {
    abstract fun drive()
}

class Car : Vehicle() {
    override fun drive() {
        println("Driving a car.")
    }
}

class Bike : Vehicle() {
    override fun drive() {
        println("Riding a bike.")
    }
}

interface VehicleAbstractFactory {
    fun createVehicle():Vehicle
}

class CarFactory : VehicleAbstractFactory {
    override fun createVehicle(): Vehicle {
        return Car()
    }
}

class BikeFactory : VehicleAbstractFactory {
    override fun createVehicle(): Vehicle {
        return Bike()
    }
}

object VehicleFactory {
    fun createVehicle(factory: VehicleAbstractFactory): Vehicle {
        return factory.createVehicle()
    }
}


fun main(){
    val wordFactory:DocumentAbstractFactory = WordDocumentFactory()
    val client1 = Client(wordFactory)
    client1.openDocument() // Outputs: Opening Word creational_patterns.Document

    val excelFactory: DocumentAbstractFactory = ExcelDocumentFactory()
    val client2 = Client(excelFactory)
    client2.openDocument() // Outputs: Opening Excel creational_patterns.Document


    val carFactory:VehicleAbstractFactory = CarFactory()
    val car = VehicleFactory.createVehicle(carFactory)
    car.drive() //  Output: Driving a car.

    val bikeFactory:VehicleAbstractFactory = BikeFactory()
    val bike = VehicleFactory.createVehicle(bikeFactory)
    bike.drive() // Output: Riding a bike.
}