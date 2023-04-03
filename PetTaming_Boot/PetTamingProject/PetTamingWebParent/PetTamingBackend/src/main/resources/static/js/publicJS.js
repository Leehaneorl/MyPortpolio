$(document).ready(function() {

	$("#logoutLink").on("click", function(e) {
		e.preventDefault();
		document.logoutForm.submit();
	});
	
	$("#buttonCancle").on("click",function(){ 
	   location.href = "/PetTaming/MainPage/home";
	   window.location = "/PetTaming/MainPage/home";
    });
    
    $("#fileImage").change(function(){
		fileSize = this.files[0].size;
			if(fileSize > 1048576){
				this.setCustomValidity("1MB를 초과하는 파일은 업로드 할 수 없습니다.");
				this.reportValidity();
			}else{
				this.setCustomValidity("");
				showImageThumbnail(this);
		   }
	}); 
});	

setInterval(function() {
	$('.animal_action').fadeToggle()}, 1000);

$('#button').click(function(){
	
	alert("javascript start");
	
	$('.animal_action').fadeToggle();
});

function showImageThumbnail(fileInput){
	   var file = fileInput.files[0];
	   var reader = new FileReader();
	   reader.onload = function(e){
		   $("#thumbnail").attr("src", e.target.result);
	   };	   
	   reader.readAsDataURL(file);
}
function clearFilter(){
		//location.href = "[[@{/users}]]";
		window.location = "/PetTaming/MainPage/User";
}

function clearFilters(){
		//location.href = "[[@{/users}]]";
		window.location = "/PetTaming/MainPage/Post";
}		
	
