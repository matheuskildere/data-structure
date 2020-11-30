# Estrutura de Dados

## Trabalho Prático – TP

As diferentes implementações de estruturas de dados (vetores, listas, conjuntos, mapas, pilhas, filas e árvores) possuem aplicações distintas. Assim, em determinados contextos, uma estrutura de dados mostra-se mais adequada que outra por conta de funcionalidades, características ou desempenho.
Esse trabalho enuncia uma série de experiências de medição que devem ser feitas em duplas ou trios para determinar o desempenho de armazenamento de dados e de operações sobre essas estruturas.

## 1. Aplicação
Deve ser desenvolvida uma aplicação para manipular estudantes armazenados em um Mapa, em que o número de matricula é usado como chave. O TAD mapa é representado pela interface Map disponível em [TAD MAPA](https://docs.oracle.com/javase/7/docs/api/java/util/Map.html). Essa interface deve ser implementada pela dupla ou trio usando três estruturas de dados: Vetor (ordenado), Lista duplamente encadeada (ordenada) e Árvore Binária.

Para cada estrutura de dados deve ser medido o tempo total gasto para cada uma das seguintes operações (usar o método System.nanoTime() para ser mais preciso):

* Inserir 100.000 (cem mil) estudantes;
* Apresentar todos os estudantes em ordem crescente de número de matricula;
* Verificar quantos estudantes realizam o curso Engenharia de Software;
* Remover todos os estudantes com número de matricula igual ou inferior à 202050000.

Os estudantes devem ser gerados usando a classe Estudante.
