import java.io.File
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println("Welcome to Hangman")
    println("Would you like me to guess a word I am thinking of or would you like to choose a word and have me guess?")
    println("Enter 1 to have me guess your word, Enter 2 to guess my word")

    var dictionary : ArrayList<String> = popdictionary()

    val input = Scanner(System.`in`)

    val choice: Int = input.nextInt()

    if (choice == 1) {
        UserPicks(dictionary)
    } else if (choice == 2) {
        ProgramPicks()
    }

}

fun ProgramPicks () {
    println("incomplete")
}

fun UserPicks (dictionary: ArrayList<String>) {

    println("Please enter the word you would like to use to play")

    val input = Scanner(System.`in`)

    val rand = (1..26).random()

    val word = input.nextLine().toLowerCase()

    var numguesses : Int = 0

    println(word)

    println(word.length)

    var answer : CharArray = InitAns(word.length)

    var LengthDictionary : ArrayList<String> = WordsOfLen(dictionary, word.length)

    guesser(numguesses)

    println("println version" + guesser(numguesses))

}

fun popdictionary (): ArrayList<String> {
    val file = Scanner(File("src/dictionary.txt"))
    var list = ArrayList<String>()
    while (file.hasNext()) {
        list.add(file.next())
    }
    file.close()
    return list
}

fun WordsOfLen (original : ArrayList<String>, Length: Int): ArrayList<String> {

    var newdictionary = ArrayList<String>()

    println(original.size)

    for (x in original) {
        if (x.length == Length) {
           newdictionary.add(x)
        }
    }

    println(newdictionary.size)

    return newdictionary

}

fun guesser (attempt: Int) : Char {

    val letters : Array<Char> = arrayOf('e', 't', 'a', 'o', 'i', 'n', 's', 'h', 'r', 'd', 'l', 'c', 'u', 'm', 'w', 'f', 'g', 'y', 'p', 'b', 'v', 'k', 'j', 'x', 'q', 'z')
    var guess : Char
    if (attempt == 0) {
        println("Does your word contain " +letters[0] + "?")
    }

    guess = letters[0]
    return guess

}

//fun answer (answer : CharArray) : CharArray{
//
//}

fun InitAns (Len : Int) : CharArray {

    var AnsArr = CharArray(Len)

    return AnsArr
}