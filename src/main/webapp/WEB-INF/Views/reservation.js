
   /*function selectCity() {
		var murl = '/getHotels';
		$.getJSON(murl, function(result, status, xhr){
				var toAppend = '';
	            for(var i=0;i<result['response']['docs'].length;i++){
	            	if(JSON.stringify(result['response']['docs'][i]["pc"]) == '""'){
	            		var dist = JSON.stringify(result['response']['docs'][i]['dist']);
	            		toAppend += '<option>'+dist.substr(1,dist.length-2)+'</option>';
	            	}
	            }
	            $("#district").html(toAppend);
		});
	}*/
  

$('#cities').change(function() {
	   
	   //alert('cities');
	   /* $.ajax({
	        type:"GET",
	        url : "/getHotels",
	        data : { city: $('#cities').val()},
	        success : function(data) {
	            $('#hotels').empty(); //remove all child nodes
	            for(var i = 0; i < data.length; i++){
	                var newOption = $('<option value=data[i].value>data[i].text</option>');
	                $('#hotels').append(newOption);
	            }   
	        },
	        error: function() {
	            alert('Error occured');
	        }
	    });*/
	});
