<h1>API Challenge NextIdea - Sprint 2</h1>
<h2>Objetivo</h2>
<p>O objetivo da aplicação é utilizar o chatGPT para 
aprimorar a expêriencia do usuário na busca e descoberta 
de produtos. O chatGPT irá funcionar como um 
assistente pessoal de compras que irá abstrair os termos 
complexos dos produtos tornando-os de fácil compreensão para
usuários leigos.</p>

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

![DIagrama](componentes-aplicacao.png)



