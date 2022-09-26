# Projeto RH - POO (Em desenvolvimento)

<br />

<div align="center">
   <img src="https://i.imgur.com/IaD4lwg.png" title="source: imgur.com" width="25%"/>
</div>

<br /><br />

## Diagrama de Classes

```mermaid
classDiagram
class Colaborador {
  - id : int
  - nome : String
  - email : String
  - cargo : int
  - salario : float
  + int getId()
  + String getNome()
  + String getEmail()
  + int getCargo()
  + float getSalario()
  + void setId(int id)
  + void setNome(String nome)
  + void setEmail(String email)
  + void setCargo(int cargo)
  + void setSalario(float salario)
  + void aumentarSalario(float percentual)
  + void visualizar()
}
class Gerente {
  - bonificacao : float
  + float getBonificacao()
  + void setBonificacao(float bonificacao)
  + void aumentarSalario(float percentual)
  + void visualizar()
}
class Vendedor {
  - comissao : float
  + float getComissao()
  + void setComissao(float comissao)
  + void visualizar()
}
Gerente --> Colaborador
Vendedor --> Colaborador
```

<br /><br />

## Print da Tela

<div align="center">
   <img src="https://i.imgur.com/uvRQV5k.png" title="source: imgur.com" />
</div>
