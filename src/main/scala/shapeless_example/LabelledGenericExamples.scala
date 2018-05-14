package shapeless_example

import enumeratum.{Enum, EnumEntry}
import shapeless.{LabelledGeneric, Witness, record}

/**
  * LabelledGeneric examples.
  *
  * @author Miles Sabin
  */
object LabelledGenericExamples extends App {
  import record._

  sealed abstract class FileType extends EnumEntry

  object FileType extends Enum[FileType] {
    val values = findValues
    case object Tuning extends FileType
    case object Viewing extends FileType
  }

  case class Book(author: String, title: String, id: Int, price: Double, fileType: FileType)
//  case class ExtendedBook(author: String, title: String, id: Int, price: Double, fileType: FileType, inPrint: Boolean)

  val tapl = Book("Benjamin Pierce", "Types and Programming Languages", 262162091, 44.11, FileType.Tuning)

  def changeParam(c: Book, paramName: Witness, paramValue: Any): Book = {

    val bookGen = LabelledGeneric[Book]
    //  val bookExtGen = LabelledGeneric[ExtendedBook]

    val rec = bookGen.to(c)

    // Read price field
//    val paramWitness = Witness(paramName)
    val param = Witness('price)
    val currentPrice = rec.get(param) // Static type is Double
    println("Current price is " + currentPrice)
    println

    // Update price field, relying on static type of currentPrice
//    val updated = bookGen.from(rec.updateWith(paramValue))
//    println(updated)
//    println
//    updated

    // Add a new field, map back into ExtendedBook
//    val extended = bookExtGen.from(rec + ('inPrint ->> true)) // Static type is ExtendedBook
//    println(extended)
//    println
    c
  }

  changeParam(tapl, Witness('price), 5000.0)

  // internationalization Shapeless style?
//  case class Libro(autor: String, `título`: String, id: Int, precio: Double, fileTipo: FileType)
//
//  val libroGen = LabelledGeneric[Libro]
//  val libroKeys = Keys[libroGen.Repr]
//  val libroRec = rec.values.zipWithKeys(libroKeys())
//  val libro = libroGen.from(libroRec) // static type is Libro
//  println(libro)
//  println
}
