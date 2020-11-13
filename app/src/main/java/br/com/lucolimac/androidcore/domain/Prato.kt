package br.com.lucolimac.androidcore.domain

import java.io.Serializable

class Prato(
    val imagem: Int,
    var nome: String,
    var descricao: String
) : Serializable