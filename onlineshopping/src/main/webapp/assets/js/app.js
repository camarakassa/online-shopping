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
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// code pour jquery dataTable
	
	var $table = $('#productListTable');
	
	// On execute le code ci-dessous uniquement lorsque nous avons cet table
	if($table.length) {
		//console.log('La table');
		
		var jsonUrl = '';
		if(window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else {
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}
		
		
		
		$table.DataTable({
			
			lengthMenu: [[3,5,10, -1], ['3 Enregistrements', '5 Enregistrements', '10 Enregistrements', 'Tous']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns:[
					{
						data: 'code',
						mRender: function(data, type, row) {
							
							return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
						}
					},
				
					{
						data: 'name'
					},
					{
						data: 'marque'
					},
					{
						data: 'unitPrice',
						mRender: function(data, type, row) {
							return  data + ' F CFA';
						}
					},
					{
						data: 'quantity',
						mRender: function(data, type, row) {
								
							if(data < 1) {
								return '<span style="color:red">En Rupture de Stock! </span>';
							}
							
							return data;
						}
					},
					{
						data: 'id',
						bSortable: false,
						mRender: function(data, type, row) {
							
							var str = '';
							str += '<a href="'+ window.contextRoot +'/show/'+ data +'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
							
							if(row.quantity < 1) {
								str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}
							
							else{
								str += '<a href="'+ window.contextRoot +'/card/add/'+ data +'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}
														
							return str;
						}
					}
					
					
					]
			
			
			
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
});
