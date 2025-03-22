class Pessoa(val nome: String, val altura: Double) {
    override fun toString(): String {
        return "Nome: $nome, Altura: $altura"
    }
}

fun main() {
    val pessoas = mutableListOf<Pessoa>()
    var opcao: Int

    do {
        println("\n--- Menu Altura ---")
        println("1. Cadastrar 15 pessoas")
        println("2. Apresentar pessoas <= 1.5m")
        println("3. Apresentar pessoas > 1.5m")
        println("4. Apresentar pessoas > 1.5m e < 2.0m")
        println("5. Apresentar média das alturas")
        println("6. Sair")
        print("Escolha uma opção: ")
        opcao = readln()?.toIntOrNull() ?: 6

        when (opcao) {
            1 -> {
                pessoas.clear()
                for (i in 1..15) {
                    println("\nCadastro da pessoa $i:")
                    print("Nome: ")
                    val nome = readln() ?: ""
                    print("Altura: ")
                    val altura = readln()?.toDoubleOrNull() ?: 0.0
                    pessoas.add(Pessoa(nome, altura))
                }
                println("15 pessoas cadastradas com sucesso!")
            }
            2 -> {
                val filtro = pessoas.filter { it.altura <= 1.5 }
                if (filtro.isEmpty()) {
                    println("Nenhuma pessoa encontrada.")
                } else {
                    println("\n--- Pessoas <= 1.5m ---")
                    filtro.forEach { println(it) }
                }
            }
            3 -> {
                val filtro = pessoas.filter { it.altura > 1.5 }
                if (filtro.isEmpty()) {
                    println("Nenhuma pessoa encontrada.")
                } else {
                    println("\n--- Pessoas > 1.5m ---")
                    filtro.forEach { println(it) }
                }
            }
            4 -> {
                val filtro = pessoas.filter { it.altura > 1.5 && it.altura < 2.0 }
                if (filtro.isEmpty()) {
                    println("Nenhuma pessoa encontrada.")
                } else {
                    println("\n--- Pessoas > 1.5m e < 2.0m ---")
                    filtro.forEach { println(it) }
                }
            }
            5 -> {
                val media = pessoas.map { it.altura }.average()
                println("Média das alturas: $media")
            }
            6 -> println("Saindo do programa...")
            else -> println("Opção inválida. Tente novamente.")
        }
    } while (opcao != 6)
}