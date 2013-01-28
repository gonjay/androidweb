window.onload = rolloverInit;

function rolloverInit () {
  for (var i = 0; i<document.images.length; i++) {
    if (document.images[i].parentNode.tagName=="A") {
      setupRollover(document.images[i]);
    };
  };
}

function setupRollover(thisImage){
  thisImage.outImage = new Img();
  thisImage.outImage.src = thisImage.src;
  thisImage.onmouseout = rollOut;


  thisImage.overImage = new Image();
  thisImage.overImage.src = "./Images/"+thisImage.id+"on_jpg"
  thisImage.onmouseover = rollOver;
}


function rollOver(){
  this.src = this.overImage.src;
}

function rollOut(){
  this.src = thisOutImage.src;
}