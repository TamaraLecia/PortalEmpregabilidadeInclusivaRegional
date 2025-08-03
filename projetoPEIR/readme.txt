	O sistema PEIR - Portal de Empregabilidade Inclusiva Regional, foi desenvolvildo utilizando
	as seguintes tecnologias:
	
	Eclipse: Ide utilizada para realizar a codificação do sistema.
	
	Java: linguagem de desenvolvimeto. A versão do java jdk utilizada, foi a versão Jdk 21 Lts
	que é uma versão estavél.
	
	TomCat: foi utilizado o servidor TomCat para o desenvolvimeto do sistema, para que ele podesse ser
	executado na web.
	
	mysql: sistema de gerencimento de banco de dados mysql.
	
	HTML: Linguangem de marcação de texto.
	
	CSS: Linguagem de estilização.
	
	JSP: Páginas JavaServer, é utilizada para criar páginas dimânicas, onde pode misturar html com a linguagem
	java.
	
	JavaScript: Linguagem de programação.
	
	Instalações: 
	
	mysql: foi instalado o mysql para windows, na versão 8.0.37.0
	
	Eclipse:
	Baixar o arquivo zip do eclipse para windows, despois extrair esse arquivo para a disco local C do computador.
	
	Java : baixar o arquivo zip java jdk na versão 21 para o windows, e realizar a configuração das
	variáveis de ambiente Path no windows, ao acessar a variável de ambiente Path, pegue o endereco bin na 
	na pasta bin do arquivo, e cole nos Path para que o java jdk possa funcionar corretamente e ser reconhecido
	pela a máquina.
	
	TomCat:baixar um arquivo do TomCat do tipo core(nucleo) na versão 9.0.97,pois ele vai ser execultado de forma local e
	controlado pela a ide eclipse, após fazer o dowload do servidor tomCat é preciso extrair o arquivo zip e copiar a pasta
	extraída para a pasta disco local C do computador.
	
	Configuração do ambiente de desenvolvimento ecplise:
	
	Configuração do ambiente do eclipse para trabalhar com o servidor TomCat.
	
	1º verifica na ide eclipse se tem a aba Servers, se não tiver a aba servers, vá em help, selecione o
	Eclipse Marketplace e digite: Eclipse Enterprise Java and web Developer Toos 3.35, após a instalação desse plugin
	a aba Servers estará disponivel para ser utilizada.
	
	2º click na aba servers e depois click no link azul onde está escrito:No servers are available.Click this link to create a new sever...,
	para criar um novo servidor. Após clicar no link deve selecionar  a pasta Apache e escolher o TomCat v9.0 Server, por que foi a versão
	do tomCat que baixamos, logo após isso click em next, após clicar em proxímo irá ser solicitado o diretório de instalação do tomCat, para
	colocar esse diretório click no botão onde está escrito Browse, depois click em este computador, em seguida em disco local C e selecione a 
	pasta do servidor apache tomCat, que é aquela pasta que foi copiada para o disco local C, click em selecionar pasta.
	O jre deixa o padrão que é Workbench default JRE, e depois click em finish ou encerrar. Ao verificar a aba servers será visto o servidor TomCat
	na versão 9, ele criará uma pasta chamada servers, no project Explorer do eclipse.
	Click duas vezes no servidor tomCat na aba servers, irá abir uma janela, e em Server Locations, deve escolher a opção Use TomCat installation(
	takes control of TomCat installation), click no ícone de salvar, para salvar a configuração.
	
	Desenvolvimento do sistema
	
	1º - Criar um projeto no eclipse:
	Vá em File, click em new, e escolha a opção: Dynamic Web Project, se está opção não estiver visivél click em Other e expanda a pasta web e selecione
	a opção Dynamic Web Project, em seguida irá abrir uma janela onde será solicitado o nome do projeto, e as outras informações pode deixar padrão, click
	em finish e a estrutura do projeto será criada.
	
	VIEW - webapp
	
	2º - Click em cima do projeto que acabou de criar,click na setinha para expandir o projeto e click na pasta webapp, que é onde ficará a view
	do projeto, ou seja, o HTML,JSP,CSS e JavaScript.
	
	3º - Para criar uma página Html selecione a pasta webapp, click com o botão direito do mouse, irá abrir uma janela, click em new, e escolha a
	opção Html file, dê um nome para a página html, click em next, após isso escolha o template New HTML File(5) html5, click em finish,
	e assim será criado um arquivo do tipo html.
	
	4º - Para criar um arquivo Css segue o mesmo processo da criação da página Html, mudando só na hora de escolher o tipo do arquivo, escolha o arquivo 
	CSS file. (Para esse projeto foi criado uma pasta dentro da pasta webapp para colocar todos os arquivos css).
	Para criar uma pasta dentro da pasta webapp selecione a pasta webapp,click com o botão direito do mouse, irá abrir uma janela, click em new, 
	e escolha a opção Folder, dê um nome para a pasta e click em finish. E quando for criar um arquivo Css é só clicar na pasta que você criou
	e seguir o mesmo processo de como estivesse criando um arquivo Css na pasta webapp.
	 
	5º - Para criar um arquivo do tipo JSP segue o mesmo processo, mudando só na hora de escolher o tipo do arquivo, escolha o arquivo JSP file.
	dê um nome para a página jsp, click em next ou próximo, após isso escolha o template New JSP File(html5) JSP with html 5 markup, click em finish.
	
	6º - Para criar um arquivo JavaScript segue o mesmo processo dos anteriores mudando só na hora de escolher o tipo do arquivo, que deve ser escolhido
	o tipo JavaScript file, e irá ser solicitado o nome arquivo, após dá o nome para o arquivo click em finish.
	Nesse projeto foi criada uma pasta chamada scripts dentro da pasta webapp.
	
	Pacotes 
	
	1 º - Para criar um pacote vá na pasta Java Resources, dentro da pasta selecione a pasta src/main/java, click com o botão direito do mouse  e irá abrir
	uma janela selecione a opção Package, ao selecionar essa opção irá abrir uma janela para informar o nome do pacote, após informar o nome do pacote click
	em finish.
	 
	Para criar as classes que seviram como modelos para as outras classes. Criamos um pacote model nesse pacote ficará todas as classes modelos para a 
	execução do sistema. Essas classes modelo sao: Administrador, Empresa, Candidatura, Vaga, PessoaPCD, Pessoa.
	
	Para realizar a comunicação do backend com o banco de dados será criado um pacote com o nome dao, onde ficará todas as classes relacionadas a 
	comunicação com o banco de dados.Nesse pacote foi criada as classes: PessoaPCDDao, EmpresaDao, AdmDao, VagaDao.
	
	Para criar a regra de negócio foram criados controlles para cada classe. Esses controlles criados são do tipo servelet.
	Para criar um arquivo do tipo servelet, click com o botão direito do mouse no pacote controller, irá abrir uma janela, click em new e selecione servelt,
	será solicitado para informar o nome do servelet, após da um nome para o servelet click em next, click novamente em next e desmarque
	a caixinha doPost, e click em finish.
	
	foram criados também para o controlle do login, e um controlle específico para abrir a tela inicial com dados do banco de dados para mostrar as empresas
	cadastradas no sistema assim que o usuário entrar.
	
	Banco de dados
	
	1º Para o backend se comunicar o base de dados é necessário ter a biblioteca do mysql conector.
	Baixe o mysql-connector-j-8.4.0 e extraia o arquivo, após extração do arquivo pegue o arquivo mysql-connector-j-8.4.0 que tem o símbolo do java, e copie
	para a pasta lib do projeto, essa pasta fica dentro da pasta WEB-INF, e a Pasta WEB-INF fica dentro da pasta webapp.
	Após isso o projeto está pronto para se comunicar o banco de dados.
	 
	 Modelagem do banco de dados
	 
	 Para realizar a modelagem do banco de dados, foi utilizado o MySQL Workbench que é uma ferramenta para a criação e geranciamento do banco de dados MySql que
	 foi o banco o utilizado para armazemar os dados coletados.
	 A linguagem de utilizada para criar o banco de dados foi a linguagem sql. 
	
	Execução do Projeto
	 
	Para executar o projeto selecione o controllerTelaPrincipal.java, click no ícone do circulo verde com uma seta branca dentro, selecione:
	Tomcat v9.0 Server at localhost, click em next, selecione o nome projeto e click em finish.