package br.com.lucolimac.androidcore.domain

import java.io.Serializable

class Restaurante(val imagem: Int, var local: String, var endereco: String, val horario: String) :
    Serializable