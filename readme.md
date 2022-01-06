
Projeto VotaçãoBackend


![VotacaoBackend](/imgs/Projeto_Design.png "Projeto e Design VotacaoBackend")


Arquitetura Hexagonal

Dependências:

1. Docker e Docker Compose
2. Kafka
3. Postgres
4. Spring Boot
5. CircutBreak
6. Makefile
7. Documentação Swagger



Como iniciar a aplicação.

Com o docker e docker compose instalados
1. mvn clean package spring-boot:build-image
2. docker-compose up -d


Com o makefile instalado executar os seguintes passos.

1. make build-mvn -- compliar e gerar as imagens dos microsservicos
2. make run -- iniciará os containers
3. make down  -- desligará os containers





Documentação da api:

Pauta-Service: http://localhost:8082/swagger-ui/
AbrirSessao-Service: http://localhost:8084/swagger-ui/
votacao-Service: http://localhost:8085/swagger-ui/
Contabilizacao-Service: http://localhost:8081/swagger-ui/
ExibeResultado-Service: http://localhost:8087/swagger-ui/




Pendências e Melhorias

1. Melhorias no tratamento de exceções
2. Adicionar testes de integração
3. Adicionar um gateway e um discobery
4. Integração com Elasticsearch
5. Configurar ferramentas de monitoramento (Prometheus)
6. Cache para consultar das pautas
7. Criar um serviço para validação do voto(Se ja computado, se o CPF do associado é valido e etc) dentro de um serviço para ser consumido por uma fila.
