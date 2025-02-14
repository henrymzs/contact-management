# Sistema de Gerenciamento de Contatos

Este é um projeto em **Python** que implementa um sistema de gerenciamento de contatos, utilizando os conceitos de **herança** e **polimorfismo**. Ele permite adicionar, remover, buscar e listar contatos pessoais e profissionais de forma eficiente, com uma estrutura bem organizada.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

- **Adicionar Contato**: Adiciona um contato pessoal ou profissional à lista.
- **Remover Contato**: Remove um contato específico da lista pelo nome.
- **Buscar Contato**: Permite buscar contatos por nome, telefone ou e-mail.
- **Listar Contatos**: Exibe todos os contatos armazenados com seus detalhes.

## Estrutura do Projeto

### Classes

#### **1. Classe `Contato`**
- Classe base para contatos, que contém os atributos comuns.
  
  **Atributos**:
  - `nome`: Nome do contato.
  - `telefone`: Telefone do contato.
  - `email`: E-mail do contato.

  **Métodos**:
  - `exibir_detalhes()`: Exibe os detalhes básicos do contato.

#### **2. Classe `ContatoPessoal`**
- Herda da classe `Contato` e adiciona atributos específicos para contatos pessoais.

  **Atributos Adicionais**:
  - `data_aniversario`: Data de aniversário do contato.
  - `endereco`: Endereço do contato.

  **Métodos**:
  - `exibir_detalhes()`: Sobrescreve o método da classe base para incluir detalhes pessoais.

#### **3. Classe `ContatoProfissional`**
- Herda da classe `Contato` e adiciona atributos específicos para contatos profissionais.

  **Atributos Adicionais**:
  - `empresa`: Nome da empresa.
  - `cargo`: Cargo do contato na empresa.

  **Métodos**:
  - `exibir_detalhes()`: Sobrescreve o método da classe base para incluir detalhes profissionais.

#### **4. Classe `Agenda`**
- Gerencia a lista de contatos e oferece métodos para manipulação dos dados.

  **Atributos**:
  - `contatos`: Lista de objetos de contato.

  **Métodos**:
  - `adicionar_contato(contato)`: Adiciona um contato à lista.
  - `remover_contato(nome)`: Remove um contato pelo nome.
  - `buscar_contato(termo_busca)`: Busca um contato por nome, telefone ou e-mail.
  - `listar_contatos()`: Lista todos os contatos armazenados.

#### **5. Arquivo `Main.py`**
- Ponto de entrada do sistema que apresenta um menu interativo no console para o usuário.

## Exemplo de Uso

Ao executar o programa, o menu interativo é exibido:

```bash
--- MENU ---
1. Adicionar contato pessoal: 
2. Adicionar contato profissional:
3. Remover contato:
4. Buscar contato:
5. Listar contatos:
0. Sair
Escolha uma opção: 1
Nome: João
Telefone: 12345678
Email: joao@email.com
Data de aniversário: 01/01/2000
Endereço: Rua A
```
- Exemplo de saída:
```bash
Contatos na agenda:
Nome: João
Telefone: 12345678
Email: joao@email.com
Data de Aniversário: 01/01/2000
Endereço: Rua A
-------------------
```
## Como Clonar o Repositorio

1. **Instalar Python**:
   - Para instalar o Python no seu sistema, siga as instruções específicas para o seu sistema operacional.

2. **Clonar o repositório**:
   Clone este repositório para a sua máquina local:
   ```bash
   git clone https://github.com/henrymzs/contact-management.git
   ```
   
3. **Execute o programa principal no Terminal Windows**
    ```bash
   python src/main.py
   ```
   ou linux
   ```bash
   python3 src/main.py
   ```
