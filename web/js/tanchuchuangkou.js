// JavaScript Document
<script>
function openwin(){
window.open("index.html","","width=200,height=200";)}
function get_cookie(Name){
	var search=Name+"="
	var returnvalue="";
	if(documents.cookie.length >0){
		offset = documents.cookie.index0f(search)
		if(offset!=-1){
			offset += search.length
			end=documents.cookie.index0f(";",offset);
			if(end==-1)
			end = documents.cookie.length;
			returnvalue=unescape(documents.cookie.substring(offset,end))
		}
	}
	rerurn returnvalue;
}
function loadpopup(){
	if(get_cookie('popped')==";){
		openwin()
		documents.cookie="popped=yes"
	}
}
</script>