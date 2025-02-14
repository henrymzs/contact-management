from models.Contato import Contato

class Agenda:
    def __init__(self):
        self.contatos = []

    def adicionar_contatos(self, contato):
        self.contatos.append(contato)

    def remover_contato(self, nome):
        contato_remover = None
        for contato in self.contatos:
            if contato.nome.lower() == nome.lower():
                contato_remover = contato
                break

        if contato_remover:
            self.contatos.remove(contato_remover)
            print(f"Contato removido: {nome}")
        else:
            print("Contato não encontrado.")

    def buscar_contato(self, termo_busca):
        for contato in self.contatos:
            if (contato.nome.lower() == termo_busca.lower() or
                contato.telefone == termo_busca or 
                contato.email.lower() == termo_busca.lower()):
                return contato
        return None
    
    def listar_contatos(self):
        if not self.contatos:
            print("A agenda está vazia.")
        else:
            print("Contatos na agenda:")
            for contato in self.contatos:
                contato.exibir_detalhes()
                print("---------------")