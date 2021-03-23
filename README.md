<h1 align="center">
    <a href="http://guardioesmc.netlify.app/">GUARDIÕES M.C.</a>
</h1> 

<h4 align="center"> 
	🚧  App Guardiões M.C. 🚀 Em construção...  🚧
</h4>

<p align="center">
 <a href="#introdução">Introdução</a> •
 <a href="#objetivos-do-trabalho">Objetivos do Trabalho</a> • 
 <a href="#conteúdo-do-trabalho">Conteúdo do Trabalho</a> • 
 <a href="#fundamentação-técnica">Fundamentação Técnica</a> • 
 <a href="#rotas">Rotas</a> • 
</p>

# Introdução 

 O Guardiões Moto Clube foi fundado em 1998, pelos amigos André e Lincon, o significado do brasão é que o cão cibernético é um guardião que olha e cuida de nossas motos. O Guardiões M. C. conta com uma filial em Santa Catarina e uma filial na Bahia alem da sede em São José dos Campos, a sede conta atualmente 38 membros sendo 8 deles membros da diretoria e 3 membros Old Dogs que já são membros a mais de 15 anos.
 Atualmente o moto clube organiza toda a sua agenda de reuniões e eventos através de um grupo no whatsapp, a tesouraria é registrado em um caderno de social e um caderno de mensalidade. A partir dessas dificuldades, surgiu a ideia de desenvolver um app para gerir os dados financeiros dos membros e gerenciar a agenda de eventos e reuniões.

# Objetivos do Trabalho

 O objetivo geral deste projeto visa desenvolver um app mobile capaz de gerenciar os dados financeiros dos integrantes e gerenciar a agenda de eventos e reuniões.
 Para a consecução deste objetivo foram estabelecidos os objetivos específicos:
*	Gerenciamento da agenda: (Insert/Delete/Update - Diretoria; Read - All) Cadastro de reuniões, eventos, aniversários e encontros.]
*	Gerenciamento financeiro: (View integrantes) visualização do estado da mensalidade, do social e do bar do proprio integrante.
*	Gerenciamento financeiro: (View Diretoria) visualização do estado da mensalidade, do social e do bar de todos os integrantes.
*	Aba de noticias: Visualização do resumo de atividades registradas na agenda.
*	Gerenciamento de integrantes: (Insert/Update/Delete - Diretoria; Read - All) visualização de informações gerais do integrante.

# Conteúdo do Trabalho

 O presente trabalho está estruturado em seis Capítulos, cujo conteúdo é sucintamente apresentado a seguir:
 No Capítulo 2 é feita a fundamentação das tecnologias...
 O Capítulo 3 apresenta o desenvolvimento da solução...
 No Capítulo 4 são apresentados os resultados ...
 O Capítulo 5 apresenta as considerações finais  deste trabalho a partir da análise dos resultados obtidos...

# Fundamentação Técnica

 A linguagem de programação utilizada para desenvolver o back-end da aplicação foi o JAVA, através do Spring Framework. E para o front-end foi utilizada a linguagem de programação Javascript através da biblioteca React.
 O banco de dados de dados utilizado foi o PostgreSQL.

# Rotas

* Get de todos os integrantes: https://guardioes-mc.herokuapp.com/members
* Get dos integrantes com pendencia financeira: https://guardioes-mc.herokuapp.com/members/financial
* Get dos integrantes da diretoria: https://guardioes-mc.herokuapp.com/members/diretor
* Get dos integrantes in memorian: https://guardioes-mc.herokuapp.com/members/memorian
* Get dos integrantes nômades: https://guardioes-mc.herokuapp.com/members/nomad
* Put atualização financeira positiva:  https://guardioes-mc.herokuapp.com/members/:id/allright
* Put atualização financeira negativa: https://guardioes-mc.herokuapp.com/members/:id/delayed
* Post de um novo integrante: https://guardioes-mc.herokuapp.com/members
* Post de um novo evento: https://guardioes-mc.herokuapp.com/events

### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Expo](https://expo.io/)
- [Node.js](https://nodejs.org/en/)
- [React Native](https://reactnative.dev/)
- [TypeScript](https://www.typescriptlang.org/)
