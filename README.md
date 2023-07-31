<h1>Api - Concessionária de veículos</h1>

<p>Esse projeto é uma API de uma concessionária, no sistema há carros a serem vendidos, clientes que poderão comprar os carros, e vendas que armazenam as informações desta.</p>

<h2>Descrição</h2>
<p>
    Esse sistema é uma concessionária de carros que podem ser
    vendidos, há opção de CRUD com os carros no sistema e opção
    de compra por parte do cliente.
    O cliente é outra entidade do sistema onde também pode ser
    realizado operações de CRUD, o cliente pode comprar carros
    que estão na concessionária, há uma relação de muitos para
    muitos entre as entidades de carros e clientes, e a ligação é
    justamente através da entidade venda, que armazena as
    informações da venda realizada.
</p>



<h2>Design e Arquitetura</h2>

<p>
    O projeto foi desenvolvido no padrão MVC com um pacote de
    entidades, um de serviços e outro de controladores, além de um
    pacote auxiliar de repositórios.
</p>

<p>
    No pacote service, há interfaces e classes com suas
    respectivas implementações, para realizar as regras de 
    negócio da aplicação
</p>

    


<h3>
    <p>Abaixo segue as entidades do Sistema:</p>
</h3>

<img src="src/main/resources/assets/entities.png" alt="entidades">

</br>

<p>No sistema há também classes de DTO para inserção das informações.</p>

<h3>Serviços</h3>

<p>
    O software também conta com classes de serviço que são responsáveis pela regra de negócio,
    segue a seguir as classes de serviço:
</p>

<img src="src/main/resources/assets/services.png" alt="serviços">

<h3>Repositórios</h3>

<p>Também há classes de comunicação com os repositórios, com o padrão do nome da classe seguida da palavra repository, segue a lista:</p>

<ul>
    <li>CarRepository</li>
    <li>ClientRepository</li>
    <li>SaleRepository</li>
</ul>

O projeto foi pensado com conexão ao banco de dados PostgreSQL, onde será armazenado os dados da aplicação.

<h3>Controller</h3>

<p>
    O sistema possui uma camada de controller responsável pela recepção dos dados,
    contendo métodos http como <b>get</b>, <b>post</b>, <b>put</b> e <b>delete</b>
</p>

<img src="src/main/resources/assets/controller.png" alt="controller">

<h2>Tecnologias Utilizadas:</h2>

<ul>
    <li>Java</li>
    <li>Spring Boot</li>
    <li>Spring JPA</li>
    <li>Hibernate</li>
    <li>Maven</li>
    <li>PostgreSQL</li>
    <li>JUnit</li>
    <li>Mockito</li>
</ul>

<h2>Pré-requisitos</h2>
<ul>
    <li>Java 11</li>
    <li>Maven</li>
    <li>PostgreSQL (recomendado)</li>
    <li>Git</li>
</ul>

<h2>Como executar:</h2>

<p>
    Você deve clonar o repositório através do Git, para isso crie uma pasta e abra o terminal
    do git nessa pasta, após isso digite:
</p>

```bash
git clone https://github.com/victorgarciadss/api-concessionaria.git
```

<p>Após isso é hora de configurar o seu banco de dados, recomendo que faça isso com o SGBD PostgreSQL, execute nele o seguinte comenando caso não tenha um banco de dados já criado:</p>

```sql
CREATE DATABASE <nome_banco_de_dados>;
```

<h3>Configuração arquivo.properties</h3>

<p>Você deve criar um arquivo com a extensão <b>.properties</b>, o nome desse arquivo você define, mas o padrão é "application.properties".

 Dentro do arquivo você deve inserir os códigos a seguir:

 Obs: o código dentro dos caracteres <> deve ser substituido pelas suas informações e do seu banco de dados.
</p>

```properties
spring.datasource.url=jdbc:postgresql://<nome_da_rede(localhost)>/<nome_do_banco_de_dados>
spring.datasource.username=<seu_usuario>
spring.datasource.password=<sua_senha>
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
```

<p>Quando realizar esse procedimento, vá no arquivo principal da aplicação, que é: <b>DealershipApplication.java</b> e execute a aplicação com o botão de executar da sua IDE</p>

<p>Para testar a aplicação, vá no seu navegador e digite <b>localhost:8080</b> e a API estará funcionando, lembrando que para acessar as rotas você deve adicionar o caminho da rota após esse endereço destacado. Para manipular os dados da API e fazer requições, recomendo usar o Postman</p>

<h2>Testes</h2>

<p>A aplicação tem a devida cobertura através de testes unitários, para realizar esses testes, foi utilizado o JUnit e o Mockito</p>




