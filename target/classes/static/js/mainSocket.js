var stompClient = null;
var chapter = $("#chapter").text();
connectNotification();
function connectNotification() {
	var socket = new SockJS('/gs-guide-websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {

		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/notification/1' , function(notification) {
			console.log("inc");
			showNotification(JSON.parse(notification.body).content,JSON.parse(notification.body).fromuser);
	

	});
	
});
}
$(document).keypress(function (e) {
	  if (e.which == 13) {
		  var cursorPosition = $('#1').prop("selectionStart");
		  console.log(cursorPosition);
		  if(cursorPosition==19)
			  {
			  	$(".pages").append("" +
			  			"<textarea id='1' rows='20' cols='100'></textarea>" +
			  			"");
			  	
			  	stompClient.send("/app/createpage/1", {},JSON
						.stringify({
							'data' : chapter
						}));
			  	
			  	
			  	return false;
			  }
		  
	  }
	});
var letters=0;
$(".page").keyup(function(){
    letters++;
    console.log(letters);
    if(letters==10)
    	{
    		letters=0;
    		$( ".page" ).each(function( index ) {
    			var i =  index+1;
    			var texts=$(this).val();
    			stompClient.send("/app/editpage/1", {},JSON
						.stringify({
							'id' : $(this).attr('id'),
							'data' : texts
						}));
    			});
    	}
});