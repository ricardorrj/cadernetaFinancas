 Informações sobre a API
 
 
                                                ENDPOINTS -> CATEGORIAS

Consulta geral (GET)
http://localhost:8080/categorias


Consulta por ID (GET)
http://localhost:8080/categorias/1


Novo cadastro (POST)
http://localhost:8080/categorias

Exemplo:
{
    "descricao": "Despesas de casa"
}




Atualizar cadastro (PUT)
http://localhost:8080/categorias/4

Exemplo:
{
    "descricao": "Desp. de casa"
}


Deletar cadastro (DELETE)
http://localhost:8080/categorias/4

-----------------------------------------------------------------------



                                                ENDPOINTS -> BANCOS

Consulta geral (GET)
http://localhost:8080/bancos


Consulta por ID (GET)
http://localhost:8080/bancos/1


Novo cadastro (POST)
http://localhost:8080/bancos

Exemplo:
{
    "descricao": "NuBank"
}


Atualizar cadastro (PUT)
http://localhost:8080/bancos/4

Exemplo:
{
    "descricao": "Banco NuBank"
}


Deletar cadastro (DELETE)
http://localhost:8080/bancos/4

-----------------------------------------------------------------------


                                                ENDPOINTS -> LANCAMENTOS

Consulta geral de Lançamentos por bancos (GET)
http://localhost:8080/lancamentos?banco=1


Consulta por ID (GET)
http://localhost:8080/lancamentos/1


Novo cadastro, passando banco e categoria por parametro (POST)
http://localhost:8080/lancamentos?banco=1&categoria=1

{
    "tipo": "S",
    "descricao": "Mercado",
    "situacao": 0
}



Atualizar cadastro Passando id do lançamento e categoria a alterar(PUT)
http://localhost:8080/lancamentos/4?categoria=2

{
    "tipo": "S",
    "descricao": "Desp. Mercado",
    "situacao": 1
}



Deletar cadastro (DELETE)
http://localhost:8080/lancamentos/4
