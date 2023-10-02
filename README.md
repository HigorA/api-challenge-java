<h1>API Challenge NextIdea - Sprint 3 - Enterprise Application Development</h1>


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


