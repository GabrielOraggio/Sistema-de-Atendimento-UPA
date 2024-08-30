
# Sistema de Atendimento UPA

## Descrição do Projeto
Este projeto foi desenvolvido como parte do segundo semestre da minha formação universitária. O sistema tem como objetivo gerenciar o fluxo de atendimento em uma Unidade de Pronto Atendimento (UPA), automatizando o processo desde o cadastro inicial do paciente até o atendimento final pelo médico.

## Funcionalidades

### Recepcionista
**Cadastro de Pacientes:** O recepcionista é responsável pelo primeiro contato com o paciente. Ele realiza o cadastro inicial, inserindo informações como nome, CPF e outros dados pessoais.
**Geração de Senha:** Após o cadastro, o recepcionista gera uma senha para o paciente, que será utilizada para chamá-lo nas próximas etapas.

### Enfermeiro
**Chamado de Pacientes para Triagem:** O enfermeiro chama o próximo paciente na fila usando a senha gerada pela recepção.
**Triagem:** Durante a triagem, o enfermeiro coleta informações adicionais, como pressão arterial, batimentos cardíacos, e outros dados relevantes. Estas informações são então enviadas e armazenadas no banco de dados.

### Médico
**Acesso a Dados do Paciente:** O médico pode acessar todos os dados coletados nas etapas anteriores.
**Registro de Sintomas e Prescrição:** Com base nas informações disponíveis, o médico registra os sintomas do paciente e prescreve o tratamento necessário.

### Administrador
**Gestão de Usuários:** O administrador tem a capacidade de criar e deletar usuários do sistema, incluindo recepcionistas, enfermeiros e médicos.

## Tecnologias Utilizadas
**Linguagem de Programação:** Java
**Banco de Dados:** MySQL (utilizando o MySQL Workbench)
**IDE Utilizada:** NetBeans
