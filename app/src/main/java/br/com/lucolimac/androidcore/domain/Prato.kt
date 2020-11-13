import java.io.Serializable

class Prato(
    val imagem: Int,
    var nome: String,
    var descricao: String,
    var restaurante: Restaurante
) : Serializable