package com.jretuerto.bootcamp.trabajofinal.data.entities.pokemon.pokemon.answer

data class Answer(
    var question:String,
    var lista:List<Answers>
)

data class Answers(
    var orden:String,
    var answer:String,
    var user:String,
    var date:String,
    var accept:Boolean
    )
