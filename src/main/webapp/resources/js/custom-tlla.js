$( document ).ready(function() {
    registerUiEvents();  
});

function registerUiEvents(){
	$("#srch-btn").click(function (){
		runQuery();
	});
	
	$("#srch-term").keypress(function (e){
		if(e.which == 13) {
			runQuery();
	    }
	});
	
	$("#help-btn").click(function (){
		openHelpDialog();
	});
}

function runQuery() {
	var term = $('#srch-term').val();
	 var url = window.location.href; 
	 var path = url + "../search/word/" + term
	 
	$.ajax({
       url: path,
       statusCode: {
           500: function() {
	            var html = [];
	            html.push('<p><strong>Sorry But No Data Was Found!</strong></p>');
	            $('#data-result').css('display', 'block');
	   	    	$('#data-result').html(html.join('')); 
           }
       }
   }).then(function(data) {
   	var id = 'results';
   	var html = [];
   	
   	if(data.length != 0) {
	
	   	for(var x = 0; x<data.length; x++){
	   		
	   		if(data[x].type == "") {
	   	   		var type = "N/A";
	   	   	} else {
	   	   		var type = data[x].type;
	   	   	}
	   		
			   	html.push(
			   		     "<table id='dataTable_" + x + "' cellpadding='0' cellspacing='0' border='0' class='results-table'>",
			   		     	"<tbody>",
				    		     	"<tr>",
				    		     		"<td style=\"width:100px;\"><div style=\"width:100px;\"><b><u>Section Sub:</b></u></div></td>",
				    		     		"<td style=\"width:100px;\"><div style=\"width:100px;\">" + data[x].sectionSub + "</div></td>",	 
				    		     		"<td style=\"width:40px;\"><div style=\"width:40px;\"><b><u>Type:</b></u></div></td>",
				    		     		"<td>" + type + "</td>",	
				    		     	"</tr>",
				    		     	"<tr>",
				    		     		"<td><b><u>Offense Title:</b></u></td>",
				    		     		"<td colspan=\"3\">" + data[x].offenseTitle + "</td>",	 
				    		     	"</tr>",
				    		     	"<tr>",
				    		     		"<td colspan=\"4\">",
				    		     		
				    		     			"<p>",
				    		     				"The fine range for this offense is from " + data[x].fineMin + " to " + data[x].fineMax + " (unless there are one or more offenses of this within the previous 18 months).",
				    		     			"</p>",
				    		     			
				    		     			"<p>",
			   		     					"If you are convicted with this offense in a village or town court, the mandatory New York State surcharge is " + data[x].surchargeTownVillage + ", and if you are convicted in any other court, the surcharge is " + data.surchargeOtherCourts + ".",
			   		     				"</p>",
			   		     				
			   		     				"<p>",
			   		     					"A conviction of this offense will result in two (" + data[x].pts + ") points on your license.",
			   		     				"</p>",
			   		     				
			   		     				"<p>",
					     						"If you accrue more 11 or more points on your license in any 18 month period, you risk license suspension or revocation.",
					     					"</p>",
			   		     				
				    		     		"</td>",
				    		     	"</tr>",
				    		     "</tbody>",
				    		   "</table>",
				    		   "<br>"
				    		     
			   		     );
	   		}
   	} else {
        html.push('<p><strong>Sorry But No Data Was Found!</strong></p>');
   	}
   	
   	$('#data-result').css('display', 'block');
   	$('#data-result').html(html.join(''));     
   });		
}

var sectionSubs = new Bloodhound({
	  datumTokenizer: Bloodhound.tokenizers.obj.whitespace('sectionSub'),
	  queryTokenizer: Bloodhound.tokenizers.whitespace,
	  remote: {
	    url: '../search/autocomplete/%QUERY',
	    wildcard: '%QUERY'
	  }
	});

	$('#srch-term').typeahead(null, {
	  name: 'section-subs',
	  display: 'sectionSub',
	  source: sectionSubs
	});