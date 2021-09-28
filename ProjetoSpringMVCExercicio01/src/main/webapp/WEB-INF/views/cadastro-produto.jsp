<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="/WEB-INF/components/menu.jsp" />

	<div class="container mt-3">

		<h4>Cadastro de produto</h4>
		Preencha o formulário abaixo para incluir um produto.
		<hr />

		<form method="post" action="cadastro-produto">
			<div class="row">
				<div class="col-md-6">
					<label>Nome:</label> 
					<form:input path="dto.nome" type="text" name="nome" id="nome"
						class="form-control" placeholder="Digite aqui" required="true" />
				</div>
				<div class="col-md-3">
					<label>Quantidade:</label> <form:input path="dto.quantidade" type="number" name="quantidade"
						id="quantidade" class="form-control" placeholder="Digite aqui"
						required="true"/>
				</div>

				<div class="col-md-3">
					<label>Preço:</label> <form:input path="dto.preco" type="text" name="preco" id="preco"
						class="form-control" placeholder="Digite aqui" required="true"/>
				</div>
			</div>

			<div class="row mt-3">
				<div class="col-md-12">
					<label>Descrição:</label>
					<form:textarea path="dto.descricao" name="descricao" id="descricao" class="form-control"
						required="true"></form:textarea>
				</div>


			</div>

			<div class="row mt-3">
				<div class="col-md-12">
					<input type="submit" value="Realizar Cadastro"
						class="btn btn-success" />
				</div>
			</div>

		</form>
		
		<h5>${mensagem}</h5>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js">
		
	</script>
</body>
</html>
