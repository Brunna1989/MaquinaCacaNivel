# Caça Níquel Gamer

Este é um jogo de caça-níquel simples implementado em Java, utilizando sockets para comunicação entre cliente e servidor. O jogo tem a funcionalidade de adicionar crédito, jogar, calcular ganhos e finalizar o jogo.

## Como Jogar

1. Execute a classe SecretKeyGenerator para gerar a chave secreta (utilizada no processo de criptografia).
2. Copie a chave secreta e cole-a na variável de ambiente **SECRET_KEY** das classes: **ClientHandler** e **Server**.
3. Execute a classe app.ClientMachine.
3. A interface do jogo será exibida.
4. Clique no botão "Add Money (R$10)" para adicionar crédito.
5. Clique no botão "PLAY (R$1)" para jogar.
6. Os números serão gerados aleatoriamente nos três slots.
7. Dependendo do resultado, o crédito será ajustado conforme as regras do jogo.
8. Clique em "End Game" para finalizar o jogo.

## Modificações Implementadas

- Adicionado funcionalidade de adicionar crédito (R$10 por clique) com o botão "Add Money".
- Cada jogada custa R$1, e o crédito é atualizado após cada jogada.
- Adicionado botão "End Game" para finalizar o jogo.
- Os ganhos são calculados com base nos resultados dos slots.
- Criptografia AES utilizada para proteger a comunicação entre cliente e servidor.

## Criptografia

A comunicação entre cliente e servidor é protegida usando criptografia AES. Cada mensagem é criptografada no lado do cliente antes de ser enviada e descriptografada no lado do servidor antes de ser processada. O mesmo processo é aplicado para as respostas do servidor para o cliente.

## Funcionamento Interno

- app.ClientMachine.java: Classe principal que cria a interface do jogo e lida com a interação do usuário. Também controla o crédito do jogador e as operações de jogo.
- servidor.Server.java e Client.java: Estabelecem a conexão entre cliente e servidor usando sockets. O servidor recebe as solicitações do cliente e executa o jogo, enquanto o cliente envia solicitações de jogar e recebe os resultados.
  Com estas modificações, o jogo de caça-níquel atende aos requisitos especificados e está pronto para ser executado e utilizado.