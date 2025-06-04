package ru.netology

fun main() {
    println(agoToText(60))
    println(agoToText(120))
    println(agoToText(60 * 60))
    println(agoToText(72 * 60 * 60))
    println(agoToText(60 * 60 * 4))
}

fun agoToText(seconds: Int) = when (seconds) {
    in 1..60 -> "был(а) только что"
    in 61 until (60 * 60) -> when {
        ((seconds / 60) % 10 == 1 && (seconds / 60) != 11) -> "был(а) " + (seconds / 60) + " минуту назад"
        ((seconds / 60) % 10 in 2..4 && (seconds / 60 !in 12..14)) ->
            "был(а) " + (seconds / 60) + " минуты назад"

        else -> "был(а) " + (seconds / 60) + " минут назад"
    }

    in (60 * 60) until (24 * 60 * 60) -> when {
        ((seconds / 60 / 60) % 10 == 1 && (seconds / 60 / 60) != 11) ->
            "был(а) " + (seconds / 60 / 60) + " час назад"

        (seconds / 60 / 60) % 10 in 2..4 && seconds / 60 / 60 !in 12..14 ->
            "был(а) " + (seconds / 60 / 60) + " часа назад"

        else -> "был(а) " + (seconds / 60 / 60) + " часов назад"
    }

    in (24 * 60 * 60) until (48 * 60 * 60) -> "был(а) вчера"
    in (24 * 60 * 60) until (72 * 60 * 60) -> "был(а) позавчера"
    else -> "был(а) давно"
}