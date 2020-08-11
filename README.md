# API em Java de Estados do IGBE
- Utilizado os frameworks spring boot, spring cloud;
- Utilizado conceito de circuit breaker para consulta da api do ibge;
- Logs na api com slf4j Logger;
- Testes na camadada de Api e Serviço utilizando spring boot test;
- Relatório em PDF com iText;
- Cache nos serviços;




# Execução
- Para rodar o projeto, restaure os pacotes do maven, build e rode;
- http://localhost:8080/app/
- Rotas expostas;
- http://localhost:8080/app/api/cidade/obter-todos
- http://localhost:8080/app/api/cidade/obter-por-estado/{uf}
- http://localhost:8080/app/api/cidade/gerar-pdf/{uf}
- http://localhost:8080/app/api/estado/obter-todos
- Pode ser usado o projeto de frontend em Vue junto com essa api https://github.com/dennyphilipp/vue-estados
