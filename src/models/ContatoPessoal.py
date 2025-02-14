from .Contato import Contato

class ContatoPessoal(Contato):
    def __init__(self, nome, telefone, email, data_aniversario, endereco):
        super().__init__(nome, telefone, email)
        self.data_aniversario = data_aniversario
        self.endereco = endereco

    def exibir_detalhes(self):
        super().exibir_detalhes()
        print(f"Data de Aniversário: {self.data_aniversario}")
        print(f"Endereço: {self.endereco}")