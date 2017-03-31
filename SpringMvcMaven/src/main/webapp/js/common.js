/*-------------------------------------------- 
本程式为鼠标框选 多选框 辅助 帮手,其中还有不足. 
1. 不能将多选框单独放到body标签中. 
2. 多选框使用名子为ck+自然数, 如ck1. 
3. 就先这么多吧,可能还有........... 
制作者:八神奄 QQ:13730452 
--------------------------------------------*/ 
var x0; 
var y0; 
var selectenable=0; 

function initChkBox(obj){ 
var coll=document.forms["form1"].tags("input"); 
for (i=0;i<coll.length;i++){ 
if (coll.item(i).name.substr(0,2)=="ck") { 
var offsetTop = 0; 
var offsetLeft = 0; 
var objP = coll.item(i); 
while (objP.tagName!="BODY"&&objP){ 
offsetTop += objP.offsetTop; 
offsetLeft += objP.offsetLeft; 
objP = objP.offsetParent; 
} 
coll.item(i).X=offsetLeft+10; 
coll.item(i).Y=offsetTop+10; 
//alert(coll.item(i).X+","+coll.item(i).Y+","+coll.item(i).offsetHeight); 
} 
} 
} 

function initselect() { 
if (window.event.srcElement.tagName=="BODY") { 
window.event.returnValue = true; 
return; 
} 

x0=document.body.scrollLeft+event.clientX; 
y0=document.body.scrollTop+event.clientY; 
selectarea.setCapture(); 
selectenable=1; 
} 
function startselect() { 
if (selectenable==1) { 
selectarea.style.visibility='visible'; 

if(document.body.scrollLeft+event.clientX-x0>0) { 
selectarea.style.left=x0; 
selectarea.style.width=document.body.scrollLeft+event.clientX-x0; 
} 
else{ 
selectarea.style.left=document.body.scrollLeft+event.clientX; 
selectarea.style.width=x0-(document.body.scrollLeft+event.clientX); 
} 
if (document.body.scrollTop+event.clientY-y0>0) { 
selectarea.style.top=y0; 
selectarea.style.height=document.body.scrollTop+event.clientY-y0; 
} 
else{ 
selectarea.style.top=document.body.scrollTop+event.clientY; 
selectarea.style.height=y0-(document.body.scrollTop+event.clientY); 
} 
} 
window.event.returnValue = true; 
} 

function endselect() { 
if (selectenable==0) return false; 
selectenable=0; 
selectarea.style.visibility='hidden'; 
selectarea.releaseCapture(); 
document.onmousemove=null; 
var coll=document.forms["form1"].tags("input"); 
for (i=0;i<coll.length;i++){ 
if (coll.item(i).name.substr(0,2)=="ck") { 
/* if (((coll.item(i).X>selectarea.offsetLeft)&&(coll.item(i).X<selectarea.offsetLeft+selectarea.offsetWidth))&&((coll.item(i).Y>selectarea.offsetTop)&&(coll.item(i).Y<selectarea.offsetTop+selectarea.offsetHeight))){ 
coll.item(i).checked=!coll.item(i).checked;} 
*/ 
if (coll.item(i).X>selectarea.offsetLeft) 
if (coll.item(i).X<selectarea.offsetLeft+selectarea.offsetWidth) 
if (coll.item(i).Y>selectarea.offsetTop) 
if (coll.item(i).Y<selectarea.offsetTop+selectarea.offsetHeight) 
coll.item(i).checked=!coll.item(i).checked 
} 
} 
selectarea.style.pixelHeight=0; 
selectarea.style.pixelWidth=0; 
} 

/*function hideselect() { 
//if (document.body.scrollLeft+event.clientX==x0 && document.body.scrollTop+event.clientY==y0 && event.srcElement!=selectarea) 
selectarea.style.visibility='hidden'; 
}*/ 
function checkAll(){ 
document.form1.allsel.checked=false; 
var coll=document.forms["form1"].tags("input"); 
for (i=0;i<coll.length;i++){ 
if (coll.item(i).name.substr(0,2)=="ck") { 
coll.item(i).checked=false; 
} 
} 
} 
function change(v){ 
var f = document.forms["form1"]; 
for (i=0;i<f.elements.length;i++) 
if (f.elements[i].name.substr(0,2)=="ck") f.elements[i].checked = v; 
} 


<!-- 
function MM_reloadPage(init) { //reloads the window if Nav4 resized 
if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) { 
document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }} 
else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload(); 
} 
MM_reloadPage(true); 
//--> 
