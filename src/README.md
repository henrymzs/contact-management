# Sistema de Gerenciamento de Contatos

Este é um projeto em **JAVA** que implementa um sistema de gerenciamento de contatos, utilizando os conceitos de **herança** e **polimorfismo**. Ele permite adicionar, remover, buscar e listar contatos pessoais e profissionais de forma eficiente, com uma estrutura bem organizada.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

- **Adicionar Contato**: Adiciona um contato pessoal ou profissional à lista.
- **Remover Contato**: Remove um contato específico da lista pelo nome.
- **Buscar Contato**: Permite buscar contatos por nome, telefone ou e-mail.
- **Listar Contatos**: Exibe todos os contatos armazenados com seus detalhes.

## Estrutura do Projeto

### Classes

#### **1. Classe `Contacts`**
- Classe base para os contatos, que contém os atributos comuns.

  **Atributos**:
    - `name`: Nome do contato.
    - `telephone`: Telefone do contato.
    - `email`: E-mail do contato.

  **Métodos**:
    - `showDetails()`: Exibe os detalhes básicos do contato.

#### **2. Classe `PersonalContact`**
- Herda da classe `Contacts` e adiciona atributos específicos para contatos pessoais.

  **Atributos Adicionais**:
    - `birthday`: Data de aniversário do contato.
    - `address`: Endereço do contato.

  **Métodos**:
    - `showDetails()`: Sobrescreve o método da classe base para incluir detalhes pessoais.

#### **3. Classe `ProfessionalContact`**
- Herda da classe `Contato` e adiciona atributos específicos para contatos profissionais.

  **Atributos Adicionais**:
    - `enterprise`: Nome da empresa.
    - `jobPosition`: Cargo do contato na empresa.

  **Métodos**:
    - `showDetails()`: Sobrescreve o método da classe base para incluir detalhes profissionais.

#### **4. Classe `Agenda`**
- Gerencia a lista de contatos e oferece métodos para manipulação dos dados.

  **Atributos**:
    - `contacts`: Lista de objetos de contato.

  **Métodos**:
    - `addContacts(contact)`: Adiciona um contato à lista.
    - `removeContacts(name)`: Remove um contato pelo nome.
    - `searchContacts(searchTerm)`: Busca um contato por nome, telefone ou e-mail.
    - `listContacts()`: Lista todos os contatos armazenados.

#### **5. Arquivo `Main`**
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

1. **Instalar Java**:
    - Para instalar o Java no seu sistema, siga as instruções específicas para o seu sistema operacional.

2. **Clonar o repositório**:
   Clone este repositório para a sua máquina local:
   ```bash
   git clone https://github.com/henrymzs/contact-management.git
   ```


