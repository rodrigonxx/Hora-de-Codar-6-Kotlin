class Aluno(val nome: String, val notas: List<Double>) {
    fun calcularMedia(): Double {
        return notas.average()
    }

    override fun toString(): String {
        val media = calcularMedia()
        return "Nome: $nome, Média: $media, Situação: ${if (media >= 5) "Aprovado" else "Reprovado"}"
    }
}

fun main() {
    val alunos = mutableListOf<Aluno>()
    var opcao: Int

    do {
        println("\n--- Menu Notas ---")
        println("1. Cadastrar 20 alunos")
        println("2. Pesquisar aluno por nome")
        println("3. Apresentar todos os alunos")
        println("4. Sair")
        print("Escolha uma opção: ")
        opcao = readLine()?.toIntOrNull() ?: 4

        when (opcao) {
            1 -> {
                alunos.clear()
                for (i in 1..20) {
                    println("\nCadastro do aluno $i:")
                    print("Nome: ")
                    val nome = readLine() ?: ""
                    val notas = mutableListOf<Double>()
                    for (j in 1..4) {
                        print("Nota $j: ")
                        notas.add(readLine()?.toDoubleOrNull() ?: 0.0)
                    }
                    alunos.add(Aluno(nome, notas))
                }
                alunos.sortBy { it.nome }
                println("20 alunos cadastrados e classificados por nome.")
            }
            2 -> {
                print("Digite o nome para pesquisar: ")
                val nomePesquisa = readLine() ?: ""
                val alunoEncontrado = alunos.find { it.nome == nomePesquisa }
                if (alunoEncontrado != null) {
                    println(alunoEncontrado)
                } else {
                    println("Aluno não encontrado.")
                }
            }
            3 -> {
                if (alunos.isEmpty()) {
                    println("Nenhum aluno cadastrado.")
                } else {
                    println("\n--- Lista de Alunos ---")
                    alunos.forEach { println(it) }
                }
            }
            4 -> println("Saindo do programa...")
            else -> println("Opção inválida. Tente novamente.")
        }
    } while (opcao != 4)
}