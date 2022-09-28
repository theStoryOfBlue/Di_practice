package com.example.di_practice

fun main(){
    Pureum()
    RealPureum()
    _RealPureum()
    pu()
}

class Animal{
    fun eat(){}
}

class Person{
    private val animal:Animal = Animal()
    fun reason(){
        animal.eat()
    }
}

fun Pureum(){
    val person : Person = Person()
    person.reason()
}
// 다음 클레스들은 서로간의 의존성이 매우 커서  Pureum 함수를 쓰려면
// Animal 클레스와 persion 클레스를 생성해야 사용할 수 있게된다.
// 커플링이 과하게 발생



class RealAnimal{
    fun eat(){}
}

class RealPerson(private val realAnimal: RealAnimal){
    fun reason(){
        realAnimal.eat()
    }
}

fun RealPureum(){
    val realAnimal : RealAnimal = RealAnimal()
    val realPerson : RealPerson = RealPerson(realAnimal)
    realPerson.reason()
}
// 이런식으로 외부에서 객체를 생성해 주입하는 방식을 의존성 주입(DI) 라고 정의
// 이러한 방식을 통해 객체끼리 의존성을 줄이거나 없앨 수 있음.




class _RealAnimal{
    fun eat(){}
}

class _RealPerson(){
    lateinit var realAnimal : _RealAnimal
    fun reason(){
        realAnimal.eat()
    }
}

fun _RealPureum(){
    val realPerson : _RealPerson = _RealPerson()
    realPerson.realAnimal = _RealAnimal()
    realPerson.reason()
}
// 활동 및 프래그먼트 같은 프래임워크 클래스는 시스템에서 인스턴스화 되므로
// 생성자 주입이 불가능함 따라서 lateinit 을 통해 뒤늦은 객체 생성 후
// 주입을 시켜 사용함.




class Ani{
    fun eat(){}
}

object Service{
    fun aniMaker(): Ani = Ani()
}

class Per{
    private val ani:Ani = Service.aniMaker()
    fun reason(){
        ani.eat()
    }
}

fun pu(){
    val per :Per = Per()
    per.reason()
}




