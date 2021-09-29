<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consulta</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
	
	<!-- referência do JQuery DataTables CSS -->
<link
	href="//cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="/WEB-INF/components/menu.jsp" />

	<div class="container mt-3">

		<h4>Consulta o produto</h4>
		Consulta o formulário abaixo.
		<hr />

		<table id="consulta-produtos"
			class="table table-sm table-hover table-striped mt-5">

			<thead>

				<tr>
					<th>Código:</th>
					<th>Nome:</th>
					<th>Quantidade:</th>
					<th>Preço:</th>
					<th>Descrição:</th>
					<th>Operações</th>
				</tr>

			</thead>

			<tbody>

				<c:forEach items="${produtos}" var="t">

					<tr>
					    <td>${t.idProduto}</td>
						<td>${t.nome}</td>
						<td>${t.quantidade}</td>
						<td>${t.preco}</td>
						<td>${t.descricao}</td>
                     <td><a href="#" class="btn btn-primary btn-sm">Editar</a> 
                     <a href="#" class="btn btn-danger btn-sm">Excluir</a></td>
						
					</tr>

				</c:forEach>

			</tbody>
			
			<tfoot>
					<tr>
						<td colspan="6">Quantidade de produtos: ${produtos.size()}</td>
					</tr>

		</table>

	</div>
	<!-- referência do bootstrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
		
	<!-- referência do jquery JS -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<!-- referência do jquery DataTables JS -->
	<script src="//cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	
	<script>
		$(document).ready( function () {
	    	$('#consulta-produtos').DataTable({
		        language: {
		            url: '//cdn.datatables.net/plug-ins/1.10.24/i18n/Portuguese-Brasil.json'
		        }
		    });
		});
	</script>
</body>
</html>
