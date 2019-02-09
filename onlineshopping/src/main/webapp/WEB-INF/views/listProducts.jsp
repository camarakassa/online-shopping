<div class="container">

	<div class="row">


		<!-- Pour afficher la barre latérale -->
		<div class="col-md-3">

			<%@ include file="./shared/sidebar.jsp"%>


		</div>


		<!-- pour afficher les produits actuels -->
		<div class="col-md-9">

			<!--  ajouter le composant bootstrap de breadcrumb pour tester notre page -->
			<div class="row">

				<div class="col-md-12">


					<c:if test="${userClickAllProducts == true}">

						<script>
							window.categoryId = '';
						</script>
						
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Tous les Produits</li>

						</ol>
					</c:if>



					<c:if test="${userClickCategoryProducts == true}">
					
						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Catégorie</li>
							<li class="active">${category.name}</li>

						</ol>
					</c:if>


				</div>


			</div>


			<div class="row">

				<div class="col-xs-12">

					<table id="productListTable" class="table table-striped table-borderd">
					
					
						<thead>
						
							<tr>
								<th></th>
								<th>Nom</th>
								<th>Marque</th>
								<th>Prix</th>
								<th>Quantité Dispo</th>
								<th></th>
							
							</tr>
							
						</thead>
						
						
						<tfoot>
						
							<tr>
							
								<th>Nom</th>
								<th>Marque</th>
								<th>Prix</th>
								<th>Quantité Dispo</th>
								<th></th>
							
							</tr>
							
						</tfoot>
						
						
					</table>

				</div>


			</div>




		</div>



	</div>

</div>