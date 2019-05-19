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

    var num_guesses = 0

    var correct_letters = 0

    println(word)

    println(word.length)

    var answer : CharArray = initAns(word.length)

    var Updated_Dict : ArrayList<String> = WordsOfLen(dictionary, word.length)

    val letters : ArrayList<Char> = arrayListOf('e', 't', 'a', 'o', 'i', 'n', 's', 'h', 'r', 'd', 'l', 'c', 'u', 'm', 'w', 'f', 'g', 'y', 'p', 'b', 'v', 'k', 'j', 'x', 'q', 'z')

    guesser(letters, Updated_Dict, answer)

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

fun guesser (letters : ArrayList<Char>, updated_dict : ArrayList<String>, answer : CharArray) : Char {

    var num_guesses = 0

    var num_correct = 0

    var guess = 'e'
    if (num_correct == 0) {
        guess = letters[num_guesses]
    }

    ask_if_contains(guess, answer)

    for (x in answer) {
        println(x)
    }

    //continue here

    return guess

}

//fun answer (answer : CharArray) : CharArray{
//
//}

fun initAns (Len : Int) : CharArray {

    var AnsArr = CharArray(Len)

    return AnsArr
}

fun insert_vals (Ans_Arr : CharArray, loc : ArrayList<Int>, letter: Char) : CharArray {

    for (x in loc) {
        Ans_Arr[x-1] = letter
    }
    return Ans_Arr
}

fun rem_letter (letter : Char, dictionary : CharArray) : CharArray {

    //continue here

    return dictionary
}

fun ask_if_contains (letter : Char, answer: CharArray) : CharArray {

    val input = Scanner(System.`in`)

    println("does your word contain " +letter + "? input yes or no")

    var result = true

    val choice : String = input.nextLine()

    if (choice == "yes") {
        result = true
        println("word contains this letter")
        val locations : ArrayList<Int> = ask_location(answer.size)
        return insert_vals(answer, locations, letter)
    } else if (choice == "no") {
        result = false
    }
    return answer
}

fun ask_location (ans_len : Int) : ArrayList<Int> {

    var loc_array : ArrayList<Int> = arrayListOf()

    val input = Scanner(System.`in`)

    println("Enter 1 location in the word where the letter is contained (from 1 - $ans_len)")

    loc_array.add(input.nextInt())

    var contains_more : String = "yes"

    while (contains_more == "yes") {
        println("does the word contain more of this letter? respond yes or no")

        val stringinput = Scanner(System.`in`)

        contains_more = stringinput.nextLine()

        if (contains_more == "yes") {
            println("Please input the next location")
            loc_array.add(input.nextInt())
        }
    }

    val itr = loc_array.iterator()

    while (itr.hasNext()) {
        println(itr.next())
    }

    return loc_array
}