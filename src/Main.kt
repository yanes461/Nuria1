//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.




open class Animal(
    val id: Int,
    val name: String,
    val species: String,
    val price: Double
) {
    open fun sound(): String {
        return "El animal hace un sonido"
    }

    override fun toString(): String {
        return "ID: $id, Nombre: $name, Especie: $species, Precio: $price"
    }
}


class Dog(
    id: Int,
    name: String,
    species: String,
    price: Double,
    val breed: String,
    val age: Int
) : Animal(id, name, species, price) {
    override fun sound(): String {
        return "¡Guau!"
    }

    override fun toString(): String {
        return super.toString() + ", Raza: $breed, Edad: $age"
    }
}


class Cat(
    id: Int,
    name: String,
    species: String,
    price: Double,
    val color: String,
    val isIndoor: Boolean
) : Animal(id, name, species, price) {
    override fun sound(): String {
        return "¡Miau!"
    }

    override fun toString(): String {
        return super.toString() + ", Color: $color, ¿Es de interior?: $isIndoor"
    }
}


class Bird(
    id: Int,
    name: String,
    species: String,
    price: Double,
    val canFly: Boolean,
    val wingSpan: Double
) : Animal(id, name, species, price) {
    override fun sound(): String {
        return "¡Pío!"
    }

    override fun toString(): String {
        return super.toString() + ", ¿Puede volar?: $canFly, Envergadura: $wingSpan m"
    }
}


class PetShop {

    private val animals: MutableList<Animal> = mutableListOf()

    fun addAnimal(animal: Animal) {
        animals.add(animal)
        println("${animal.name} ha sido añadido a la tienda.")
    }

    fun showAnimals() {
        if (animals.isEmpty()) {
            println("No hay animales en la tienda.")
        } else {
            println("Animales en la tienda:")
            for (animal in animals) {
                println("- ${animal.name}")

            }
        }
    }

    fun removeAnimal(id: Int): Boolean {
        return animals.removeIf { it.id == id }
    }

    fun displayAnimals() {
        if (animals.isEmpty()) {
            println("No hay animales en la tienda.")
        } else {
            animals.forEach { println(it) }
        }
    }

    fun buscarAnimalPorId(id: Int): Animal? {
        return animals.find { it.id == id }
    }


    fun calculateTotalValue(animals: List<Animal>): Double {
        return animals.sumOf { it.price }
    }

}








fun main() {
    val dog = Dog(1, "Rex", "Perro", 300.0, "Labrador", 5)
    val cat = Cat(2, "Miau", "Gato", 150.0, "Negro", true)
    val bird = Bird(3, "Tweety", "Pájaro", 80.0, true, 0.25)

    println(dog)
    println(dog.sound())

    println(cat)
    println(cat.sound())

    println(bird)
    println(bird.sound())


    val petShop = PetShop()

    val animales = listOf(

        Animal(1, "Felino", "dog",600.0),
        Animal(2, "Anfibio"," bird",100.0),
        Animal(3, "Canino", "cat",500.0)
    )

    petShop.addAnimal(dog)
    petShop.addAnimal(cat)
    petShop.showAnimals()
    petShop.removeAnimal(2)
    petShop.displayAnimals()
    petShop.calculateTotalValue(animales)




    val felinos = animales.filter { it.species == "Felino" }
    println("Felinos: $felinos")


    val nombresAnimales = animales.map { it.name }
    println("Nombres de animales: $nombresAnimales")


    val precioPromedio = animales.map { it.price }.average()
    println("Precio promedio de los animales: $precioPromedio")


}
