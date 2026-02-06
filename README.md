Resolver o problema Conexão
Estratégica descrito no pdf anexo usando
programação dinâmica
* Desafios: Modelar um algoritmo usando
programação dinâmica e implementar ele
* Instruções para execuções:
a.Estando tudo certo pode-se executar via
terminal
b.java Conexoes < Ex01.in (Ex02, Ex03)
c.São fornecidos 3 arquivos de entradas (.in)
e as saídas esperadas (.out correspondente)
Prazo: 20 de Fevereiro
* Regras para Pontuação:
a.deve-se entregar os arquivos .java
produzidos
b.Código não compila via terminal (0,0 - zero)
- Senão compilar via terminal, nota zero;
  c.Código compila mas não funciona
  adequadamente. Nesse caso pontos serão
  descontados em proporção a quantidade de
  erros que atrapalham o funcionamento
  d.Código compila e funciona adequadamente -
  pontuação máxima


No jogo, Ada precisa comprar um casa por linha até formar um
caminho que conecte o topo do tabuleiro com a base dele. A primeira
casa a ser comprada deve ser na primeira linha, a segunda casa na
segunda linha e assim por diante. Na figura, o caminho construído
possui o custo de 9 ( 1 + 3 + 1 + 3 + 1).
Dado um tabuleiro, sua tarefa é descobrir o custo do caminho mais
barato que liga o topo do tabuleiro a sua base.
Especificação da Entrada:
A primeira linha da entrada contém um inteiro positivo, R. Ele indica o
número de linhas do tabuleiro. A segunda linha contém outro inteiro
positivo, C, indicando o número de colunas do tabuleiro. A terceira linha
tem um inteiro, M, onde M ≤ 100 000, que é o maior custo de uma casa.
Especificação da Saída
A saída é o número P, o menor custo de um caminho que liga o topo à
base do tabuleiro.
Exemplo de Entrada
3
5
7
Exemplo de Saída
6