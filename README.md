![image](https://github.com/HigorA/api-challenge-java/assets/87673337/b034cac1-9434-45f8-aa9c-a6f9c374c581)<h1>API Challenge NextIdea - Sprint 3 - Enterprise Application Development</h1>


<h2>ATENÇÂO!</h2>

<p>Antes de iniciar os testes, é importante ressaltar 3 pontos:</p>
<ul>
    <li>1. O Banco de Dados que a aplicação estava utilizando estava na nuvem, na plataforma da azure, por isso, agora é necessário configurar uma conexão com o banco de dados localmente. </li>
    <li>3. Esta aplicação também conta com a implementação do Swagger, ferramenta usada para documentação e para teste de API's.</li>
</ul>

<h2>Integrantes</h2>
<ul>
    <li>Nome: Higor Alves Santos | RM: 93359</li>
    <li>Nome: Karina Conceição Machado da Costa | RM: 96164</li>
    <li>Nome: Lucas Marques de Souza | RM: 95418</li>
</ul>

<h2>Objetivo</h2>
<p>O objetivo da aplicação é utilizar o chatGPT para 
aprimorar a expêriencia do usuário na busca e descoberta 
de produtos. O chatGPT irá funcionar como um 
assistente pessoal de compras que irá abstrair os termos 
complexos dos produtos tornando-os de fácil compreensão para
usuários leigos.</p>

<h2>Principais Funcionalidades</h2>
<table>
    <tr>
        <td>Componente</td>
        <td>Descrição</td>
    </tr>
    <tr>
        <td>Login</td>
        <td>O usuário é capaz de realizar login informando suas credenciais, username e password.</td>
    </tr>
    <tr>
        <td>Cadastro de Novo Usuário</td>
        <td>O usuário é capaz de realizar o cadastro informando os campos necessários. name, email e password.</td>
    </tr>
    <tr>
        <td>Desativa usuário</td>
        <td>O usuário é capaz de desativar o sua conta.</td>
    </tr>
    <tr>
        <td>Adiciona favorito</td>
        <td>O usuário é capaz de adicionar um favorito vinculado a sua conta.</td>
    </tr>
    <tr>
        <td>Deleta favorito</td>
        <td>O usuário é capaz de deletar um favorito vinculado a sua conta.</td>
    </tr>
    <tr>
        <td>Listar favoritos</td>
        <td>O usuário é capaz de listar todos os favoritos vinculados a sua conta.</td>
    </tr>
</table>


<h2>Escopo</h2>
<p>Para tornar está solução realidade, o projeto irá utilizar</p>
<ul>
    <li>Uma API back-end escrita em Java, resposável pela autenticação e operações do 
        usuário, tais como: login, cadastro, desativar conta,
        adicionar favorito, editar favorito e remover favorito
    </li>
    <li>Um banco de dados relacional, OracleSQL/MySQL, para armazenar
        os dados de persistêcia do usuário, tais como conta e favoritos.
    </li>
    <li>Uma interface front-end que irá consumir a API e ao mesmo 
        tempo consumir a API do chatGPT para realizar as pesquisas.
        Este front-end será um aplicativo mobile construido em 
        react-native e contará com a funcionalidade de STT (Speech-to-Text)
        e TTS (Text-to-Speech).
    </li>
</ul>

<h2>Arquitetura da Solução</h2>

![Diagrama](componentes-aplicacao.png)

<table>
    <tr>
        <td>Componente</td>
        <td>Descrição</td>
    </tr>
    <tr>
        <td>AuthController</td>
        <td>Expõe os endpoints correspondente a cada serviço contido no AuthServices. Se comunica com AuthServices.</td>
    </tr>
    <tr>
        <td>SecurityConfig</td>
        <td>Responsável pelas configurações de segurança, toda requisição que o AuthController recebe, passa por este arquivo de configuração.</td>
    </tr>
    <tr>
        <td>AuthServices</td>
        <td>Faz as operações do usuário incluindo a autenticação. Se comunica com UserRepository e com AuthController.</td>
    </tr>
    <tr>
        <td>UserRepository</td>
        <td>Faz as operações do usuário no banco de dados. Se comunica com AuthServices.</td>
    </tr>
    <tr>
        <td>User</td>
        <td>Representa a tabela de Usuários do banco de dados. Se comunica com Permission numa relação de muitos pra muitos e com também se comunica com Favorite em uma relação de um para muitos.</td>
    </tr>
    <tr>
        <td>Permission</td>
        <td>Representa a tabela de Permissões do banco de dados.</td>
    </tr>
    <tr>
        <td>Favorite</td>
        <td>Representa a tabela de Favorito do banco de dados.</td>
    </tr>
    <tr>
        <td>JwtTokenFilter</td>
        <td>Resposável por filtrar e validar se o token é valido. Se comunica com o JwtTokenProvider.</td>
    </tr>
    <tr>
        <td>JwtTokenProvider</td>
        <td>Faz as operações do JWT token, como validar token e gerar token.</td>
    </tr>
    <tr>
        <td>JwtConfigurer</td>
        <td>Faz as configurações do JWT. Se comunica com o JwtTokenProvider,</td>
    </tr>
</table>

<h2>Arquitetura da Solução - Macro</h2>

![se não aparecer a imagem abra o macro.png](macro.png)

<h3>Tecnologias</h3>
<p>Tecnologias usadas tanto no front-end como no back-end</p>
<ul>
    <li>Java | Spring Framework</li>
    <li>React Native</li>
    <li>Expo</li>
    <li>Google Cloud Plataform | Google Speech to Text API</li>
    <li>Azure MySQL</li>
    <li>API ChatGPT</li>
</ul>

<h2>Endpoints</h2>
<table>
    <tr>
        <td>method</td>
        <td>path</td>
        <td>body</td>
        <td>status codes</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>/auth/signin</td>
        <td>
            <code>
            {<br/>
                "username":string, 
                "password":string<br/>
            }
            </code>
        </td>
        <td>200, 400, 403, 500</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>/auth/signup</td>
        <td>
            <code>
            { <br/>
              "name": "string", <br/>
              "email": "string", <br/>
              "password": "string" <br/>
            }
            </code>
        </td>
        <td>200, 400, 401, 403, 500</td>
    </tr>
    <tr>
        <td>DELETE</td>
        <td>/auth/delete</td>
        <td>
            <code>
            { 
                "username": "string", <br/>
                "password": "string"
            }
            </code>
        </td>
        <td>200, 400, 401, 403, 404, 500</td>
    </tr>
    <tr>
        <td>GET</td>
        <td>/favorite</td>
        <td>
        </td>
        <td>200, 400, 401, 403, 404, 500</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>/favorite</td>
        <td>
            <code>
            { <br/>
                "idUser": "numeric", <br/>
                "name": "string", <br/>
                "url": "string" <br/>
            }
            </code>
        </td>
        <td>200, 400, 401, 403, 404, 500</td>
    </tr>
    <tr>
        <td>DELETE</td>
        <td>/favorite</td>
        <td>
            <code>
            { <br/>
                "idUser": "numeric", <br/>
                "idFavorite": "numeric", <br/>
            }
            </code>
        </td>
        <td>200, 400, 401, 403, 404, 500</td>
    </tr>
</table>


<h1>Passo a Passo – Processo de CI/CD<h1/>
    
<p>Para criação da pipeline de Build do projeto, acesse o portal do Azure Devops e a aba pipelines. Feito isso, clique em “New pipeline” para criar uma nova pipeline.</p>
 
Essa criação será feita através do modo clássico, então clique em “Use the classic editor” para seguir com a criação da pipeline.
 

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/09da9682-dc26-4acd-920a-f39cc45a9743)




<p>Agora será necessário selecionar o software de versionamento no qual se encontra o projeto, no caso deste projeto é o Github. Logo, seleciona essa opção e informa o repositório para o qual iremos criar a pipeline e a branch Default para builds manuais e por trigger. Clique em “continue”.<p/>
![image](https://github.com/HigorA/api-challenge-java/assets/87673337/b2fc2d34-0de1-4519-b8fd-abd34bd285ac)

 
<p>Considerando que nossa aplicação se trata de uma API Java, iremos utilizar o maven para baixar as dependências do projeto. Por isso, procure por Maven e clique no botão “Apply”.</p>
 

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/9eefc9e1-514e-48b6-bafa-8dd4bdfc433a)


<p>Nesta etapa de configuração da Pipeline, selecione a Agent pool que seja e a Agent Specification, no qual a aplicação irá rodar. Nos parâmetros seleciona o arquivo pom do repositório.</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/4b3c85aa-9850-4483-9fa2-32511833527e)

 
<p>Em seguida, na configuração de “Get sources”, mantenha as informações dessa forma, selecionando o software no qual se encontra o repositório da aplicação, especificando a mesma e a branch Default.</p>>
 ![image](https://github.com/HigorA/api-challenge-java/assets/87673337/50e181a2-d567-43ba-8c44-fd7a98489cb5)


<p>
Na configuração do Agent job 1, seleciona a mesma Agent pool e Specification escolhidas anteriormente.
</p>
![image](https://github.com/HigorA/api-challenge-java/assets/87673337/d20e689a-88e5-4a22-a289-4772b4984e74)


<p>
Na mesma etapa, selecione novamente o arquivo pom.xml do projeto.
</p>
![image](https://github.com/HigorA/api-challenge-java/assets/87673337/c2964f5f-51ac-469a-a7eb-a5add85925df)


<p>
Ainda na configuração do Maven, um ponto bastante importante para essa etapa é a versão do Java que iremos utilizar para fazer a Build do projeto, pois a versão selecionada deve ser compatível com a usada na aplicação, caso contrário será apresentado um erro no download das dependências.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/e068a83d-e65f-409c-a1c1-53b9f3663254)


<p>
Em “Copy Files” deixe dessa forma, nessa etapa iremos copiar os arquivos que foram baixados na etapa anterior, isto é, a do Maven, na qual foram baixadas as dependências necessárias para rodar o projeto.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/3398375a-f489-4eeb-8f54-9762c602e3cc)


<p>
Para configuração da última “Task”, escolha um nome para o artefato que será gerado na Build e o nome que será mostrado durante a Build, no caso o “displayName”. Com relação ao path no qual o artefato será publicado, mantenha o mesmo apresentado abaixo.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/564881f1-18bd-441b-aa3f-3b69e0ff4be4)


<p>
Uma etapa importante para mantermos o processo de Continuous Integration e Continuous Delivery, vá na aba “Triggers” e selecione o check box “Enable continuous integration”. É necessário fazermos isso para que quando pegarmos o script yml da pipeline, ele informe que uma nova pipeline será iniciada no Azure Devops a cada novo commit para a branch especificada, nesse caso a main. Feito isso, salve e enfileire a aplicação.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/80d07bf3-18cb-4e91-b320-d06398f8b5f7)


<p>
Especifique a Agent pool e Specification com os mesmos valores de anteriormente, selecione a branch main e clique em “Run” para iniciar a pipeline de Build.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/f6da5c5e-1d9b-4517-ab85-56e06e9c854f)


<p>
A nova pipeline será mostrada assim, clique no “Agent job 1” para ver as tasks com maior nível de detalhamento.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/dff8fa53-37bf-4808-939f-2534d47ef8a6)


<p>
Os Steps serão apresentados dessa forma. Nesse caso, obtivemos uma build de sucesso.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/cb3335ae-0a18-49bf-af1e-95d0a656783f)


<p>
É possível identificar, ao voltarmos para a página na qual vemos a pipeline que rodou, que o artefato da build foi gerado, pois há “1 published”, que informa a criação de um artefato.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/fa90e614-7b08-4db1-9e20-db84acc3f2e8)


<p>
Pipeline de Release
</p>

<p>
Agora iremos configurar a pipeline de release, para que possamos fazer o deploy da aplicação. Vá para a aba “Releases” do menu lateral e clique em “new” para criar uma nova pipeline de release.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/e9629206-694a-4ce5-83be-fd3b1a2fea11)


<p>
Selecione um nome para o stage de release, clique no “X” após isso e clique em “+Add” para adicionar um artefato.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/0a02ade7-5dea-4b14-addd-44ffdcc74103)


<p>
Na etapa de configuração do artefato informa o nome do projeto no qual se encontra, o projeto no qual foi rodado a pipeline que gerou o artefato que será usado para fazer o deploy e deixe o Default version com o valor abaixo.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/3a77169c-ef9d-49eb-8521-3663bca89ccb)


<p>
Na aba Tasks, adicione o serviço abaixo para realizar o deploy do web  app. Na etapa de release, informe o nome do web app que foi criado na sua conta Azure e sua subscription.
![image](https://github.com/HigorA/api-challenge-java/assets/87673337/397c1583-4abb-4aa4-ad53-7f11f0bd361e)

<p>
Em Run on agent, seleciona novamente a Agent pool e Specification.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/33bb08bd-73bc-455b-85c8-0d92a0dede7d)


<p>
Ainda na mesma etapa de configuração, selecione o local no projeto no qual a pipeline de build gerou o artefato e especifique o caminho para esse artefato.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/d89a8166-9022-4f59-8ea9-9aacfe1ee544)


<p>
Na última etapa de configuração do serviço de deploy, informe os dados abaixo e mantenha o nome do mesmo web app informado anteriormente.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/edbbc84a-a64c-4551-bb9f-237e534e38f3)


<p>
Especifique novamente o caminho para o artefato gerado na pipeline de Build e clique em “create release”.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/b99604e2-3318-4ae8-9dc2-922d05ee1d83)


<p>
Clique em create para criar a pipeline de release.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/70ca5cf4-7039-41cf-8d7e-04119f2da56a)


<p>
Ela será apresentada dessa forma como a pipeline “Release 2” na aba de releases, que está em andamento.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/42848151-25c0-4770-99af-af33b4de612a)


<p>
Ao clicar naquela pipeline da página anterior, essa será aberta, informando que a etapa de release está em andamento.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/8ad58500-4105-40dc-a581-54c94db84a31)


<p>
Ao clicar no stage de release, essa página com o detalhamento dos Steps rodados para o deplouy será apresentada.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/446d6785-e7fa-4519-8578-5a56359d169a)


<p>
Ao clicar no step de deploy, após a finalização do processo da pipeline, ele mostrará a URL na qual o serviço está rodando.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/5ea1297d-8a59-4294-92f6-7a04d879dedb)


<h2>
Script yml
</h2>


<p>
Um ponto importante, é que escolhemos fazer a build do modo clássico, mas ainda é possível exportar essas configurações que fizemos e unir em um arquivo único de configuração de pipeline. Abaixo seguem os locais nos quais podemos pegar os scripts yaml:
</p>


<p>
Na pipeline de release, podemos pegar o do serviço de deploy ao clicar nesse “View YAML”
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/37faa832-8842-45e5-8365-9a8ba510ce87)

<p>
E no de build, ao clicarmos nesses três pontos haverá a mesma opção para exportar o script de build.
</p>

![image](https://github.com/HigorA/api-challenge-java/assets/87673337/7eca2ab9-b137-4ffc-9d06-1eb6447c5fb7)

<p>Após o deploy, utilizamos aquele link no qual a aplicação está rodando e adicionamos a rota do Swagger, posto que nosso backend possui essa integração. Desta forma, podemos testar a aplicação rodando no web app.</p>
![image](https://github.com/HigorA/api-challenge-java/assets/87673337/6b9fff96-966f-46b0-912e-0c9aa2bf6db0)


