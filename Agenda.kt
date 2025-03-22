class Contato(val nome: String, val endereco: String, val telefone: String) {
    override fun toString(): String {
        return "Nome: $nome, Endereço: $endereco, Telefone: $telefone"
    }
}

fun main() {
    val agenda = mutableListOf<Contato>()
    var opcao: Int

    do {
        println("\n--- Menu Agenda ---")
        println("1. Cadastrar 10 contatos")
        println("2. Pesquisar contato por nome")
        println("3. Classificar contatos por nome")
        println("4. Apresentar todos os contatos")
        println("5. Sair")
        print("Escolha uma opção: ")
        opcao = readln()?.toIntOrNull() ?: 5

        when (opcao) {
            1 -> {
                agenda.clear()
                for (i in 1..10) {
                    println("\nCadastro do contato $i:")
                    print("Nome: ")
                    val nome = readln() ?: ""
                    print("Endereço: ")
                    val endereco = readln() ?: ""
                    print("Telefone: ")
                    val telefone = readln() ?: ""
                    agenda.add(Contato(nome, endereco, telefone))
                }
                println("10 contatos cadastrados com sucesso!")
            }
            2 -> {
                print("Digite o nome para pesquisar: ")
                val nomePesquisa = readln() ?: ""
                val contatoEncontrado = agenda.find { it.nome == nomePesquisa }
                if (contatoEncontrado != null) {
                    println("Contato encontrado: $contatoEncontrado")
                } else {
                    println("Contato não encontrado.")
                }
            }
            3 -> {
                agenda.sortBy { it.nome }
                println("Contatos classificados por nome.")
            }
            4 -> {
                if (agenda.isEmpty()) {
                    println("Nenhum contato cadastrado.")
                } else {
                    println("\n--- Lista de Contatos ---")
                    agenda.forEach { println(it) }
                }
            }
            5 -> println("Saindo do programa...")
            else -> println("Opção inválida. Tente novamente.")
        }
    } while (opcao != 5)
}