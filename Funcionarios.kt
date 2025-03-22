class Funcionario(val matricula: Int, val nome: String, val salario: Double) {
    override fun toString(): String {
        return "Matrícula: $matricula, Nome: $nome, Salário: R$$salario"
    }
}

fun main() {
    val funcionarios = mutableListOf<Funcionario>()
    var opcao: Int

    do {
        println("\n--- Menu Funcionários ---")
        println("1. Cadastrar 20 funcionários")
        println("2. Pesquisar funcionário por matrícula")
        println("3. Apresentar funcionários com salário > R$1000")
        println("4. Apresentar funcionários com salário < R$1000")
        println("5. Apresentar funcionários com salário = R$1000")
        println("6. Sair")
        print("Escolha uma opção: ")
        opcao = readln()?.toIntOrNull() ?: 6

        when (opcao) {
            1 -> {
                funcionarios.clear()
                for (i in 1..20) {
                    println("\nCadastro do funcionário $i:")
                    print("Matrícula: ")
                    val matricula = readln()?.toIntOrNull() ?: 0
                    print("Nome: ")
                    val nome = readln() ?: ""
                    print("Salário: ")
                    val salario = readln()?.toDoubleOrNull() ?: 0.0
                    funcionarios.add(Funcionario(matricula, nome, salario))
                }
                funcionarios.sortBy { it.matricula }
                println("20 funcionários cadastrados e classificados por matrícula.")
            }
            2 -> {
                print("Digite a matrícula para pesquisar: ")
                val matriculaPesquisa = readln()?.toIntOrNull() ?: 0
                val funcionarioEncontrado = funcionarios.find { it.matricula == matriculaPesquisa }
                if (funcionarioEncontrado != null) {
                    println(funcionarioEncontrado)
                } else {
                    println("Funcionário não encontrado.")
                }
            }
            3 -> {
                val filtro = funcionarios.filter { it.salario > 1000 }
                if (filtro.isEmpty()) {
                    println("Nenhum funcionário encontrado.")
                } else {
                    println("\n--- Funcionários com salário > R$1000 ---")
                    filtro.forEach { println(it) }
                }
            }
            4 -> {
                val filtro = funcionarios.filter { it.salario < 1000 }
                if (filtro.isEmpty()) {
                    println("Nenhum funcionário encontrado.")
                } else {
                    println("\n--- Funcionários com salário < R$1000 ---")
                    filtro.forEach { println(it) }
                }
            }
            5 -> {
                val filtro = funcionarios.filter { it.salario == 1000.0 }
                if (filtro.isEmpty()) {
                    println("Nenhum funcionário encontrado.")
                } else {
                    println("\n--- Funcionários com salário = R$1000 ---")
                    filtro.forEach { println(it) }
                }
            }
            6 -> println("Saindo do programa...")
            else -> println("Opção inválida. Tente novamente.")
        }
    } while (opcao != 6)
}