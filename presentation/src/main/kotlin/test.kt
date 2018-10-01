import java.math.BigDecimal

fun main(args: Array<String>) {
    println("Hello, world!")

    stringInterpolation()
    nullExplicitType()
    automaticCast() //Implicit argument
    extensions()
    whenExample(Color.GREEN)

    val (result, color) = multiDeclarations()
}








data class Person (val name: String, var age: Int)  //age is mutable, name is not













val welcome = "Hey Everyone! "
var person = Person("Bob", 55)  //person is not final
val person2 = person
fun stringInterpolation(){
    person2.age=2
    //person2 = person  //doesn't work

    println("$welcome This dude's name is ${person.name}. He's ${person.copy(age=57).age} years old") //lombok @wither

}













fun ifAsExpression(): Boolean {
    val a = 1
    val eq = if(a == 1) true else false
    return eq;
}













fun getAPerson() = person2
fun nullExplicitType(){
    println("value: ${ifAsExpression().and(false)}")
    println("Initials: ${getAPerson().name.get(0)}")
}













fun automaticCast(obj: Any? = null){    //default value
    if(obj is Int){
        println("Adding: ${obj+1}")
    } else if (obj is Boolean){     //if(obj) here fails
        if(obj) println("true") else println("false")
    }
    println("Null checking ${obj?.hashCode()}. toString is fine ${obj.toString()}")
}













fun whileLoop(){
    do{
        val check = ifAsExpression();
    } while (check)
}













fun forLoop(){
    var i=1;
    //for(i=0; i<5; i++){} //doesn't compile
    for(i in 1..5){
        println("i: $i")
    }
}













enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}
fun whenExample(color: Color?): String{
    return when(color){
        Color.RED -> "r"
        Color.GREEN -> "g"
        Color.BLUE -> "b"   //show removing branch & ?
        else -> "."
    }
}













data class Result(val result: Int, val color: Color)
fun multiDeclarations(): Result{
    return Result(7, Color.GREEN)
}   //In main














data class Money(val amount: BigDecimal, val currency: String)
fun BigDecimal.percent(percentage: Int) = this.multiply(BigDecimal(percentage)).divide(java.math.BigDecimal(100))   //omitted return type
fun Int.percentOf(money:Money) = money.amount.multiply(BigDecimal(this)).divide(BigDecimal(100))    //infix
fun extensions(){
    println("7 percent of 100: ${BigDecimal(100).percent(7)}")

    val car = Money(BigDecimal(25000), "$")
    println("sales tax: ${5.percentOf(car)}")
    //println("sales tax: ${5 percentOf car}")
}











fun extensionProperty(){
    val bd1 = 100.bd
    println("${bd1.percent(11)}")
}

val Int.bd: BigDecimal
    get() = BigDecimal(this)









fun String.wut() = this + " lul"
fun String.toString() = ""
fun extensions2(){
    println("String is final".wut().toString())
}










operator fun Color.inc() = when(this){
    Color.RED -> Color.GREEN
    Color.GREEN -> Color.BLUE
    Color.BLUE -> Color.RED
}
fun overloadOperators(){
    var color = Color.BLUE
    println("Color: ${color++}")
} //https://kotlinlang.org/docs/reference/operator-overloading.html













fun javaInterop(){

}

//DSL examples

