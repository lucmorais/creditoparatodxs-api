# creditoparatodxs-api
 
API que permite o cliente contratar um Crédito Pessoal.

Esta API tem as seguintes funcionalidades: 
    
    Cadastra o cliente;
    Lista as ofertas de Crédito Pessoal;
    Cadastra a oferta de Crédito Pessoal
    Detalha a oferta do usuário ao momento de escolha;
    Apresenta a revisão das informações da simulação;
    Permite que o cliente realize a contratação;


A partir da porta 8888 do localhost ou do endereço http://0.0.0.0:8888/ é possivel acessar a raiz da API

    POST - /client - Cadastrar um cliente

    Permite o cadastro de um cliente no sistema. Deve ser enviado um objeto do formato JSON, conforme exemplificado abaixo:

      {
          name: "teste teste teste do teste",
          cpf: "55557777333",
          dateBirth: "20/10/1990",
          mail: "teste@gmail.com",
          cellNumber: "00 99988-5566",
          incomeMonthly: 1000.502,
          profession: "Suporte técnico"
      }

    POST - /credit - Consultar usuário ativo

    Permite o cliente inserir a oferta de crédito. Após o envio da oferta, mostra na tela o crédito escolhido pelo cliente. É necessário que o cliente seja cadastrado antes de inserir a oferta de crédito, caso contrário o sistema não irá efetuar o regitro do crédito inserido. Deve ser enviado um objeto do formato JSON. O exemplo abaixo mostra como inserir uma oferta de crédito.
    
      {
          valueCredit: 2000.00,
          quantityPortion: 12,
          goal: "Reforma da casa"
      } 

    GET - /resume - Mostrar o detalhamento de uma simulação cadastrada.
    
      {
          cpfCliente: "55557777333"   
      }


    POST - /contract - Permite fazer a contratação do Crédito Pessoal

    Permite cadastrar o contrato da oferta de crédito enviada pelo cliente. Devem ser informados os dados exemplificados abaixo em um objeto do formato JSON:

      {
          regiao: "CO",
          siglaEstado: "DF"
      }


Para o desenvolvimento do projeto foi utilizada a linguagem de programação Kotlin e o framework Ktor. Para compilação, utilizou-se o Gradle com o Java JDK 1.8. Além disso, foram utilizadas as seguintes dependências do framework Ktor:

    io.ktor:ktor-server-core
    io.ktor:ktor-gson
    io.ktor:ktor-server-netty
    io.ktor:ktor-html-builder
    ch.qos.logback:logback-classic
    io.ktor:ktor-server-tests

Outras bibliotecas utilizadas:

    Jsoup - Versão 1.11.3
    Selenium-Java - Versão 3.141.59
    Selenium-Crhome-Driver - Versão 3.141.59
    Kotlin-Statistics - Versão 1.2.1
    Krangl - Versão 0.16.2
