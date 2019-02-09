<div class="container">

	<!-- Breadcrumb  -->
	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Produits</a></li>
				<li class="active">${product.name}</li>

			</ol>

		</div>

	</div>

	<div class="row">

		<!--affichage de l'image du produit  -->
		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images}/${product.code}.jpg" class="img img-responsive" />

			</div>

		</div>

		<!--  affichage de la description du produit -->
		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			<hr />

			<p>${product.description}</p>
			<hr />

			<h4>
				Prix: <strong> ${product.unitPrice} F CFA /- </strong>
			</h4>
			<hr />

			<c:choose>

				<c:when test="${product.quantity < 1}">

					<h6>
						Quantité Disponible: <span style="color: red">En Rupture de
							Stock!</span>
					</h6>

				</c:when>
				<c:otherwise>

					<h6>Quantité Disponible: ${ product.quantity}</h6>

				</c:otherwise>

			</c:choose>


			<c:choose>

				<c:when test="${product.quantity < 1}">

					<a href="javascript:void(0)"
						class="btn btn-success disabled"><strike> <span
						class="glyphicon glyphicon-shopping-cart"></span> Ajouter au Panier</strike>
					</a>

				</c:when>
				<c:otherwise>

					<a href="${contextRoot}/cart/add/${product.id}/product"
						class="btn btn-success"> <span
						class="glyphicon glyphicon-shopping-cart"></span> Ajouter au
						Panier
					</a>

				</c:otherwise>

			</c:choose>

			<a href="${contextRoot}/show/all/products" class="btn btn-primary">
				Retour </a>

		</div>

	</div>


</div>

