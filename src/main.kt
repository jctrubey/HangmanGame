import java.io.File
import java.io.FileNotFoundException
import java.util.Scanner
import java.util.ArrayList

fun main() {
    println("Welcome to Hangman")
    println("Would you like me to guess a word I am thinking of or would you like to choose a word and have me guess?")
    println("Enter 1 to have me guess your word, Enter 2 to guess my word")

    var dictionary = popdictionary()

    val input = Scanner(System.`in`)

    val choice: Int = input.nextInt()

    if (choice == 1) {
        UserPicks()
    } else if (choice == 2) {
        ProgramPicks()
    }

}

fun ProgramPicks () {
    println("incomplete")
}

fun UserPicks () {

    println("Please enter the word you would like to use to play")

    val input = Scanner(System.`in`)

    val rand = (1..26).random()

    val word = input.nextLine().toLowerCase()

    println(word)

    val wordlength = word.length

    println(wordlength)

}

fun popdictionary (): ArrayList<String> {
    val s = Scanner(File("src/dictionary.txt"))
    var list = ArrayList<String>()
    while (s.hasNext()) {
        list.add(s.next())
    }
    s.close()
    return list
}