$(function() {

	// Résolution de l'élément actif du menu
	switch (menu) {
	case 'A Propos':
		$('#about').addClass('active');
		break;
	case 'Nous Contacter':
		$('#contact').addClass('active');
		break;
	case 'Tous Produits':
		$('#listProducts').addClass('active');
		break;

	default:
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}

});