$(function() {

	// Résolution de l'élément actif du menu
	switch (menu) {
	case 'A Propos':
		$('#about').addClass('active');
		break;
	case 'Nous Contacter':
		$('#contact').addClass('active');
		break;

	default:
		$('#home').addClass('active');
		break;
	}
	
});