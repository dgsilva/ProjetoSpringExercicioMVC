<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Sistema de Agenda de tarefas</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/ProjetoSpringMVCExercicio01/">P?gina Inicial</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						Gerenciar Minhas Tarefas </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="/ProjetoSpringMVCExercicio01/cadastro-produto">Cadastro Produto</a></li>
						<li><a class="dropdown-item" href="/ProjetoSpringMVCExercicio01/consulta-produto">Consultar Produtos</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="/ProjetoSpringMVCExercicio01/relatorio-tarefa">Relat?rio de Produtos</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>

<div class="row container mt-2">
	<div class="col-md-12 text-end">
		Usu?rio autenticado: <strong>${usuario_autenticado.nome}</strong>, 
		email: <strong>${usuario_autenticado.email}</strong>
		&nbsp;&nbsp; 
		<a href="/ProjetoSpringMVCExercicio01/" class="btn btn-outline-danger btn-sm">Sair do Sistema</a>
	</div>
</div>