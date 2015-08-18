// fixpng.js
// Petek Pekgoz

function fixPNG(myImage) // correctly handle PNG transparency in Win IE 5.5 or higher.
   {
	if (window.ie55up)
	 {
	 var imgID = (myImage.id) ? "id='" + myImage.id + "' " : ""
	 var imgClass = (myImage.className) ? "class='" + myImage.className + "' " : ""
	 var imgTitle = (myImage.title) ? "title='" + myImage.title + "' " : "title='" + myImage.alt + "' "
	 var imgStyle = "display:inline-block;" + myImage.style.cssText 
	 var strNewHTML = "<span " + imgID + imgClass + imgTitle
	 strNewHTML += " style=\"" + "width:" + myImage.width + "px; height:" + myImage.height + "px;" + imgStyle + ";"
	 strNewHTML += "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader"
	 strNewHTML += "(src=\'" + myImage.src + "\', sizingMethod='scale');\"></span>" 
	 myImage.outerHTML = strNewHTML
	 }
   }