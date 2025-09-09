package PrototypePattern

abstract class Shape(open var color: String) {
    abstract fun cloneShape(): Shape
    abstract fun showDetails()
}

class Circle( color: String, var radius: Double) : Shape(color) {
    override fun cloneShape(): Shape {
        return Circle(color,radius)
    }

    override  fun showDetails(){
        println("$color -> $radius")
    }
}

class Rectangle(color: String,var width:Double, var height: Double) : Shape(color) {
    override fun cloneShape(): Shape {
        return Rectangle(color,width,height)
    }

    override fun showDetails(){
        println("$color -> $width x $height")
    }
}

fun main() {
    val originalCircle = Circle("red",32.0)
    val clonedCircle = originalCircle.cloneShape()

    originalCircle.showDetails()
    clonedCircle.showDetails()

    val originalRectangle = Rectangle("blue",32.0,24.0)
    val clonedRectangle = originalRectangle.cloneShape()

    originalRectangle.showDetails()
    clonedRectangle.showDetails()
}