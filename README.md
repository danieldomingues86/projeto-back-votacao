###### Desafio Técnico - Back-End Projeto de Votação

**Organização do código**

O Código foi devidamente organizado em pacotes (models que representam as entidades que são utilizadas dentro do sistema), 
classes (que contem a lógica de cada assunto que engloba o sistema) e métodos (responsáveis por cada ação no sistema) mantendo um alto nivel de coesão entre 
diferentes informações. 

**Arquitetura do projeto**

O Projeto é baseado em uma arquitetura bem leve com o uso do Spring Boot e APIs Rest (essas já providas pelo próprio Spring) evitando 
o uso excessivo de frameworks paralelos e também com o uso do Spring Boot evita-se o uso de web conteirs separados, diminuindo a complexidade de infraestrutura da aplicação, 
deixando toda essa responsabilidade para o próprio Spring e para o servidor/docker onde a aplicação será implantada. 
Assim o projeto pode subir de forma stand-alone e podendo ser usado como mencionada dentro de um docker por exemplo, facilitando assim a escalabilidade dela, caso necessário.

Logging: Também aproveitando a suite de ferramentas que o Spring oferece foi utilizado o próprio mecanismo de logs dele evitando adionar mais libs ao projeto,
por ser um projeto pequeno e leve não há a necessidade de um framework mais complexo de logs, sendo que o do proprio Spring já funciona bem nesse cenário.



**Boas práticas de programação**

A Manutenção se torna simples devido a separação entre diferentes camadas dentro de suas devidas classes (models, repository, resources).
Caso seja necessário adicionar mais Api's de serviços ou métodos novos, basta adicionar diretamente na classe responsável pela lógica.
Métodos e variaveis foram escritos com nomes claros e de clara identificação para facilitar futura manutenção.


**O porquê das escolhas tomadas durante o desenvolvimento da solução?**

O Objetivo foi criar uma aplicação bem leve e performática para rodar de forma stand-alone, por isso a escolha do Spring Bot que pode inciar de forma simples 
já fornecendo automaticamente uma solução embutida "Embedded" de webcontainer (Tomcat) fornecendo assim já toda a parte necessária de HTTP integrada
na qual facilita muito o uso de chamadas e repostas de APIs Rest que se basieam no protocolo HTTP.

Além disso com o Spring o Uso de Injeção de Dependências se torna transparente deixando com ele a responsabilidade de gerenciar as classes e "injetá-las"
no momento de comunicação entre as mesmas, diminuindo e muito a quantidade de codigo escrita, facilitando assim ainda mais a manutenção.


**Documentação do código e da API**

Métodos e classes principais foram documentadas dentro do código em seus respectivos locais e explicando sua finalidade, para facilitar ainda mais
o entendimento dos objetivos da aplicação.


