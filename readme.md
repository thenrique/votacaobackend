
Projeto VotaçãoBackend


![VotacaoBackend](/imgs/Projeto_Design.png "Projeto e Design VotacaoBackend")


Dependências:

1. Docker e Docker Compose
2. Kafka
3. Postgres
4. Spring Boot 2.6.1
5. CircutBreak
6. Makefile



Como iniciar a aplicação.

Com o makefile instalado executar os seguintes passos.

1. make build-mvn -- compliar e gerar as imagens dos microsservicos
2. make run -- iniciará os containers
3. make down  -- desligará os containers

ou

Com o docker e docker compose instalados

1. docker-compose up -d


Pendências e Melhorias

1. Documentação - Swagger (Bug na versão Spring 2.6.1 e Swagger 3.0.0)
2. Melhorias no tratamento de exceções
3. Adicionar testes de integração
4. Adicionar um gateway e um discobery
5. Integração com Elasticsearch
6. Configurar ferramentas de monitoramento (Prometheus)
