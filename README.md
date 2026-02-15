# 💱 Conversor de Moedas em Java

Projeto desenvolvido para consumir uma API de taxas de câmbio e realizar conversões entre diferentes moedas utilizando Java.

---

## 📌 Descrição

Este projeto realiza requisições HTTP para a API ExchangeRate e converte valores entre moedas utilizando dados atualizados em tempo real.

O sistema funciona via console, apresentando um menu interativo para o usuário escolher a conversão desejada.

---

## 🚀 Funcionalidades

- Consumo de API de câmbio
- Leitura e manipulação de JSON com Gson
- Menu interativo no console
- Conversão entre moedas:
  - USD ↔ BRL
  - USD ↔ ARS
  - USD ↔ COP
- Estrutura modular com método de conversão

---

## 🛠 Tecnologias Utilizadas

- Java 11+
- HttpClient
- Gson
- API ExchangeRate

---

## 📂 Estrutura do Projeto

- `ConversorApp.java` → Classe principal do sistema
- Método `converter()` → Responsável pelo cálculo de conversão

---

## ⚙️ Como Executar

1. Clone o repositório
2. Abra o projeto em uma IDE (IntelliJ, Eclipse, VSCode)
3. Certifique-se de estar usando Java 11 ou superior
4. Execute a classe `ConversorApp`

---

## 📷 Exemplo de Uso

=== CONVERSOR DE MOEDAS ===
1 - USD → BRL
2 - BRL → USD
3 - USD → ARS
4 - ARS → USD
5 - USD → COP
6 - COP → USD
0 - Sair
Escolha uma opção: 1

Digite o valor: 100

Resultado: 498.00 BRL
