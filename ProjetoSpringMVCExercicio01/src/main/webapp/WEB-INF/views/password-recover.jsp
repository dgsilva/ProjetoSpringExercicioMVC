<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Esqueci minha senha</title>

<!-- referência do bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body class="bg-secondary">

	<div class="container mt-5">

		<div class="row">
			<div class="col-md-4 offset-md-4">

				<div class="card">
					<div class="card-body">

						<div class="text-center">
							<img
								src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Logo_NIKE.svg/2560px-Logo_NIKE.svg.png"
								class="img-fluid" />

							<h5>Recuperação de senha</h5>
							<hr />
						</div>

						<form>

							<label>Email de acesso:</label> <input type="email"
								class="form-control" required="required" /> <br />

							<div class="d-grid">
								<input type="submit" value="Recuperar Senha"
									class="btn btn-success" />
							</div>

						</form>

						<div class="text-center">
							<small><a href="/ProjetoSpringMVC01/">Acesso ao
									Sistema</a></small>
						</div>

					</div>
				</div>

			</div>
		</div>

	</div>

	<!-- referência do bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>




