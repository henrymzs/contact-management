from models.Contato import Contato
from models.ContatoPessoal import ContatoPessoal
from models.ContatoProfissional import ContatoProfissional
from services.Agenda import Agenda

class Main():
    def main():
        agenda = Agenda()
        continuar = True

        while continuar:
            print("\nEscolha uma opção: ")
            print("1. Adicionar Contato Pessoal: ")
            print("2. Adicionar Contato Profissional: ")
            print("3. Remover Contato: ")
            print("4. Buscar Contatos: ")
            print("5. Listar Contatos ")
            print("0. Sair")

            opcao = input("Digite o número da sua escolha: ")
            
            if opcao == '1':
                nome = input("Nome: ")
                telefone = input("Telefone: ")
                email = input("Email: ")
                data_aniversario = input("Data de aniversário: ")
                endereco = input("Endereço: ")
                contato_pessoal = ContatoPessoal(nome, telefone, email, data_aniversario, endereco)
                agenda.adicionar_contatos(contato_pessoal)
                print("Contato pessoal adicionado com sucesso! ")

            elif opcao == '2':
                nome = input("Nome: ")
                telefone = input("Telefone: ")
                email = input("Email: ")
                empresa = input("Empresa: ")
                cargo = input("Cargo: ")
                contato_profissional = ContatoProfissional(nome, telefone, email, empresa, cargo)
                agenda.adicionar_contatos(contato_profissional)
                print("Contato profissional adicionado com sucesso! ")

            elif opcao == '3':
                nome = input("Digite o nome do contato que deseja remover: ")
                agenda.remover_contato(nome)

            elif opcao == '4':
                termo_busca = input("Digite o nome, email ou telefone do contato que deseja buscar: ")
                contato = agenda.buscar_contato(termo_busca)
                if contato:
                    print("---------------")
                    print("Contato Encontrado: ")
                    contato.exibir_detalhes()
                else:
                    print("Contato não encontrado. ")

            elif opcao == '5':
                agenda.listar_contatos()

            elif opcao == '0':
                print("Saindo do programa... ")
                break

            else:
                print("Opção Inválida. Tente novamente. ")


if __name__ == "__main__":
    Main.main()


                