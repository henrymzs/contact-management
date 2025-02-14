from .Contato import Contato

class ContatoProfissional(Contato):
    def __init__(self, nome, telefone, email, empresa, cargo):
        super().__init__(nome, telefone, email)
        self.empresa = empresa
        self.cargo = cargo

    def exibir_detalhes(self):
        super().exibir_detalhes()
        print(f"Empresa: {self.empresa}")
        print(f"Cargo: {self.cargo}")